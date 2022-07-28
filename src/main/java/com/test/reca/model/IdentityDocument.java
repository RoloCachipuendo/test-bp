package com.test.reca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "identityDocument")
public class IdentityDocument {

    @Id
    private String number;
    private String expiryDate;
    private Date emissionDate;
    private DocumentType documentType;

}
