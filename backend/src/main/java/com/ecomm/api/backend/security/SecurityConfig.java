package com.ecomm.api.backend.security;

import com.ecomm.api.backend.security.Handlers.ApiAccessDeniedHandler;
import com.ecomm.api.backend.security.Handlers.ApiAuthenticationEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private UserDetailsService userDetailsService;
    private PasswordEncoder bCryptPasswordEncoder;
    private ApiAccessDeniedHandler apiAccessDeniedHandler;
    private ApiAuthenticationEntryPoint apiAuthenticationEntryPoint;

    @Value("${app.security.jwt.keystore-location}")
    private String keyStorePath;

    @Value("${app.security.jwt.keystore-password}")
    private String keyStorePassword;

    @Value("${app.security.jwt.keystore-alias}")
    private String keyStoreAlias;

    @Value("${app.security.jwt.private-key-passphrase}")
    private String privateKeyPassphrase;

    @Bean
    public KeyStore keyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(keyStorePath);
            keyStore.load(resourceAsStream, keyStorePassword.toCharArray());
            return keyStore;

        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException e) {
            LOG.error("Unable to load keystore", e);
        }
        throw new IllegalArgumentException("Unable to load keystore");
    }

    @Bean
    public RSAPrivateKey jwtSignInKey(KeyStore keystore) {

        try {
            Key key = keystore.getKey(keyStoreAlias, privateKeyPassphrase.toCharArray());
            if (key instanceof RSAPrivateKey) {
                return (RSAPrivateKey) key;
            }
        } catch (UnrecoverableKeyException |
                NoSuchAlgorithmException |
                KeyStoreException e) {
            LOG.error("Unable to load private key from keystore: {}", keyStorePath, e);
        }
        throw new IllegalArgumentException("Unable to load private key");
    }

    @Bean
    public RSAPublicKey jwtValidationKey(KeyStore keyStore) {
        try {
            Certificate certificate = keyStore.getCertificate(keyStoreAlias);
            PublicKey publicKey = certificate.getPublicKey();
            if (publicKey instanceof RSAPublicKey) {
                return (RSAPublicKey) publicKey;
            }
        } catch (KeyStoreException e) {
            LOG.error("Unable to load public key from keystore: {}", keyStorePath, e);
        }
        throw new IllegalArgumentException("Unable to load public key");
    }

    @Bean
    public JwtDecoder jwtDecoder(RSAPublicKey jwtValidationKey) {
        return NimbusJwtDecoder.withPublicKey(jwtValidationKey).build();
    }

}
