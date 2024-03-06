package com.isi.adminapp.repository;

import com.isi.adminapp.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    //récupération d'un utilisateur a partir de son email
    AppUser findByEmail(String email);
}
