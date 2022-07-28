package com.test.reca.controller;

import com.test.reca.model.IdentityDocument;
import com.test.reca.service.IIdentityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/admin/document")
@Api(tags = "Administracion de Empleados")
public class IdentityController {

    @Autowired
    IIdentityService identityService;

    @PostMapping(value = "/create")
    @ApiOperation(value = "Save Identity document ", notes = "")
    public IdentityDocument saveDocument(IdentityDocument document) {
        log.info("Ingresa al método");
        return identityService.saveIdentityDocument(document);

    }

    @GetMapping(value = "/getAll")
    @ApiOperation(value = "get all Identity document ", notes = "")
    public List<IdentityDocument> getAllDocument() {
        return identityService.getAllIdentityDocument();
    }


    @DeleteMapping(value = "/deleteById/{id}")
    @ApiOperation(value = "delete document by ID", notes = "")
    public void deleteById(@PathVariable String id){
        identityService.deleteIdentityDocument(id);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "update document",notes = "")
    public IdentityDocument updateDocument(IdentityDocument document){
        return identityService.updateIdentityDocument(document);
    }

}
