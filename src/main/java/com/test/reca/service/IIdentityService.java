package com.test.reca.service;

import com.test.reca.model.IdentityDocument;

import java.util.List;

public interface IIdentityService {

    /**
     * Method to save Document.
     * @param document
     * @return {@code IdentityDocument}
     */
    IdentityDocument saveIdentityDocument(IdentityDocument document);

    /**
     * Method to update Document.
     * @param document
     * @return {@code IdentityDocument}
     */
    IdentityDocument updateIdentityDocument(IdentityDocument document);

    /**
     * Method to get all documents.
     * @return List {@code IdentityDocument}
     */
    List<IdentityDocument> getAllIdentityDocument();

    /**
     * Method to delete Document.
     * @param id
     */
    void deleteIdentityDocument(String id);

}
