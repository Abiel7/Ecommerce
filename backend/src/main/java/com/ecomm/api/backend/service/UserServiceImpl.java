package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AddressEntity;
import com.ecomm.api.backend.entity.CardEntity;
import com.ecomm.api.backend.entity.UserEntity;
import com.ecomm.api.backend.entity.UserTokenEntity;
import com.ecomm.api.backend.exceptions.GenericAlreadyExistsException;
import com.ecomm.api.backend.repository.UserRepository;
import com.ecomm.api.backend.repository.UserTokenRepository;
import com.ecomm.api.backend.security.JwtManager;
import com.ecommerce.api.model.RefreshToken;
import com.ecommerce.api.model.SignedInUser;
import com.ecommerce.api.model.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserTokenRepository userTokenRepository;
    private final JwtManager tokenManager;
    ;

    public UserServiceImpl(UserRepository userRepository, UserTokenRepository userTokenRepository, PasswordEncoder passwordEncoder,
                           JwtManager tokenManager) {
        this.userRepository = userRepository;
        this.userTokenRepository = userTokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenManager = tokenManager;
    }


    @Override
    public void deleteCustomerById(String id) {
        userRepository.deleteById(UUID.fromString(id));

    }

    @Override
    public Optional<Iterable<AddressEntity>> getAddressesByCustomerID(String id) {
        return userRepository.findById(UUID.fromString(id)).map(UserEntity::getAddresses);
    }

    @Override
    public Iterable<UserEntity> getAllCustomers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<CardEntity> getCardByCustomerId(String id) {
        AtomicReference<Optional<CardEntity>> cardEntityAtomicReference = new AtomicReference<>(Optional.empty());
        userRepository.findById(UUID.fromString(id)).ifPresent(userEntity -> {


                    if (Objects.nonNull(userEntity.getCard()) && userEntity.getCard().isEmpty()) {
                        cardEntityAtomicReference.set(Optional.of(userEntity.getCard().get(0)));
                    }
                }
        );
        return cardEntityAtomicReference.get();
    }

    @Override
    public Optional<UserEntity> getCustomerByID(String id) {
        return userRepository.findById(UUID.fromString(id));
    }

    /**
     * first check if the user exists if there is it simply raises and exception
     * if there is no user signed in with the the same name and email it create a new user  and  add it to the database
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    public Optional<SignedInUser> createUser(User user) {
        Integer count = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        if (count > 0) {
            throw new GenericAlreadyExistsException("User already exists use a different username and email");
        }
        UserEntity savedUser = userRepository.save(toEntity(user));
        return Optional.of(createSignedUserWithRefToken(savedUser));
    }

    private SignedInUser createSignedUserWithRefToken(UserEntity userEntity) {
        return createSignedInUser(userEntity)
                .refreshtoken(createRefreshToken(userEntity));
    }

    private SignedInUser createSignedInUser(UserEntity userEntity) {

        String token = tokenManager.create(org.springframework.security.core.userdetails.User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(Objects.nonNull(userEntity.getRole()) ? userEntity.getRole().name() : "")
                .build());
        return new SignedInUser().username(userEntity.getUsername()).accessToken(token).userId(userEntity.getId().toString());
    }

    private String createRefreshToken(UserEntity userEntity) {
        String token = RandomHolder.randomKey(128);
        userTokenRepository.save(new UserTokenEntity().setRefreshToken(token).setUser(userEntity));
        return token;
    }

    private UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        return userEntity;
    }

    @Override
    public UserEntity findUserByUsername(String userName) {
        if (Strings.isBlank(userName)) {
            throw new UsernameNotFoundException("Username is blank");
        }
        final String name = userName.trim();
        Optional<UserEntity> userEntity = userRepository.findByUsername(name);
        UserEntity user = userEntity.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    @Override
    public SignedInUser getSignedInUser(UserEntity userEntity) {
        userTokenRepository.deleteByUserID(userEntity.getId());
        return createSignedUserWithRefToken(userEntity);
    }

    @Override
    public Optional<SignedInUser> getAccessToken(RefreshToken refreshToken) {
        return Optional.empty();
    }

    @Override
    public void removeRefreshToken(RefreshToken refreshToken) {

    }

    private static class RandomHolder {
        static final Random random = new SecureRandom();

        // generate  a big-Integer instance then it is converted to a string using  the radix 32 at the end the space is replaced with 0 if there are any space
        public static String randomKey(int length) {
            return String.format("%" + length + "s", new BigInteger(length * 5/*base 32,2^5*/, random).toString(32)).replace('\u0020', '0');
        }
    }
}
