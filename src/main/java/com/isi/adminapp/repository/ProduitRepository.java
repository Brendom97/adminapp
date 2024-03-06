package com.isi.adminapp.repository;

import com.isi.adminapp.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    Produit findByNom(String nom);
}
