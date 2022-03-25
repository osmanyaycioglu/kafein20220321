package com.training.spring.jpa;

import javax.persistence.AttributeConverter;

import com.training.spring.security.EncryptionConfig;

public class EncryptorConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(final String attributeParam) {
        String encryptLoc = EncryptionConfig.getEncryptor()
                                            .encrypt(attributeParam);
        return encryptLoc;
    }

    @Override
    public String convertToEntityAttribute(final String dbDataParam) {
        return EncryptionConfig.getEncryptor()
                               .decrypt(dbDataParam);
    }

}
