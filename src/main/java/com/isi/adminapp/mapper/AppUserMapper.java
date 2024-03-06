package com.isi.adminapp.mapper;

import com.isi.adminapp.dto.AppUserDTO;
import com.isi.adminapp.entity.AppUser;
import org.mapstruct.Mapper;


@Mapper
public interface AppUserMapper {
    AppUserDTO toAppUserDTO(AppUser appUser);
    AppUser fromAppUserDTO(AppUserDTO AppUserDTO);
}
