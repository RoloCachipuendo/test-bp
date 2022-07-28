package com.test.reca.repository;

import com.test.reca.model.IdentityDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IdentityDocumentRepository extends MongoRepository<IdentityDocument, String> {
}
