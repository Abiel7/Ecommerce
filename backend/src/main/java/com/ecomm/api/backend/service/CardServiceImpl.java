package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.AfterReactiv.CardEntity;
import com.ecomm.api.backend.entity.AfterReactiv.UserEntity;
import com.ecomm.api.backend.repository.CardRepository;
import com.ecomm.api.backend.repository.UserRepository;
import com.ecommerce.api.model.AddCardReq;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CardServiceImpl  implements  CardService{
    CardRepository cardRepository;
    UserRepository userRepository;

    public CardServiceImpl(CardRepository cardRepository,UserRepository userRepository) {
        this.cardRepository= cardRepository;
        this.userRepository= userRepository;
    }
    @Override
    public Iterable<CardEntity> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Optional<CardEntity> getCardById(String id) {

        return cardRepository.findById(UUID.fromString(id));
    }

    @Override
    public Optional<CardEntity> registerCard(AddCardReq addCardReq) {
        return Optional.of(cardRepository.save(toEntity(addCardReq)));
    }

    @Override
    public void deleteCardById(String id) {
        cardRepository.deleteById(UUID.fromString(id));

    }

    private CardEntity toEntity(AddCardReq addCardReq){
        CardEntity cardEntity=new CardEntity();
        Optional<UserEntity> user = userRepository.findById(UUID.fromString(addCardReq.getUserId()));
        user.ifPresent(cardEntity::setUser);

        return  cardEntity.setNumber(addCardReq.getCardnumber())
                .setCvv(addCardReq.getCcv())
                .setExpires(addCardReq.getExpires());
    }
}
