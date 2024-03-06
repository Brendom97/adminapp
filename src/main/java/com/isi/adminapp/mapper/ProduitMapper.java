package com.isi.adminapp.mapper;

import com.isi.adminapp.dto.ProduitDTO;
import com.isi.adminapp.entity.Produit;
import org.mapstruct.Mapper;


@Mapper
public interface ProduitMapper {
    ProduitDTO toProduitDTO(Produit produit);
    Produit fromProduitDTO(ProduitDTO produitDTO);
}
