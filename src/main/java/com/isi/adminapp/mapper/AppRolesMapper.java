package com.isi.adminapp.mapper;

import com.isi.adminapp.dto.AppRolesDTO;
import com.isi.adminapp.entity.AppRoles;
import org.mapstruct.Mapper;


@Mapper
public interface AppRolesMapper {
    AppRolesDTO toAppRolesDTO(AppRoles appRoles);
    AppRoles fromAppRolesDTO(AppRolesDTO appRolesDTO);
}
