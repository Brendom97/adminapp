package com.isi.adminapp.controller;

import com.isi.adminapp.entity.Produit;
import com.isi.adminapp.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "produit")
public class ProduitController {

    private ProduitService produitService;
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Produit produit){
        this.produitService.create(produit);
    }

}
