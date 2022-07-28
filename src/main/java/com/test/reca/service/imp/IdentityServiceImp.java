package com.test.reca.service.imp;

import com.test.reca.model.IdentityDocument;
import com.test.reca.repository.IdentityDocumentRepository;
import com.test.reca.service.IIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityServiceImp implements IIdentityService{

    @Autowired
    IdentityDocumentRepository identityRepository;

    @Override
    public IdentityDocument saveIdentityDocument(IdentityDocument document) {
        return identityRepository.save(document);
    }

    @Override
    public IdentityDocument updateIdentityDocument(IdentityDocument document) {
        return identityRepository.save(document);
    }

    @Override
    public List<IdentityDocument> getAllIdentityDocument() {
        return identityRepository.findAll();
    }

    @Override
    public void deleteIdentityDocument(String id) {
        identityRepository.deleteById(id);
    }
}
