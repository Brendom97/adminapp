package com.isi.adminapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDTO {
    private int id;
    @NotNull(message = "Le nom ne doit pas être null")
    private String nom;
    @NotNull(message = "Le prénom ne doit pas être null")
    private String prenom;
    @NotNull(message = "L'email ne doit pas être null")
    private String email;
    @NotNull(message = "Le mot de passe ne doit pas être null")
    private String password;
    @NotNull
    private int etat;
}
