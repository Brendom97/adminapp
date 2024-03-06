package com.isi.adminapp.service;

import com.isi.adminapp.entity.Produit;
import com.isi.adminapp.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProduitService {

    private ProduitRepository produitRepository;

    public void create(Produit produit){

        Produit clientDansLaBDD = this.produitRepository.findByNom(produit.getNom());
        if(clientDansLaBDD == null){
            this.produitRepository.save(produit);
        }

    }
}
