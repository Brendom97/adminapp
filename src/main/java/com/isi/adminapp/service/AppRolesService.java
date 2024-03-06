package com.isi.adminapp.service;

import com.isi.adminapp.mapper.AppRolesMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import com.isi.adminapp.repository.AppRolesRepository;


import com.isi.adminapp.dto.AppRolesDTO;
import com.isi.adminapp.exception.EntityNotFoundException;
import com.isi.adminapp.exception.RequestException;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class AppRolesService {

    private AppRolesRepository appRolesRepository;
    private AppRolesMapper appRolesMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public List<AppRolesDTO>  getAppRolesDTO() {
        return StreamSupport.stream(appRolesRepository.findAll().stream().spliterator(), false)
                .map(appRolesMapper::toAppRolesDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AppRolesDTO getAppRoleDTO(int id) {
        return appRolesMapper.toAppRolesDTO(appRolesRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public AppRolesDTO createAppRoles(AppRolesDTO appRolesDTO) {
        return appRolesMapper.toAppRolesDTO(appRolesRepository.save(appRolesMapper.fromAppRolesDTO(appRolesDTO)));
    }

    @Transactional
    public AppRolesDTO updateAppRolesDTO(int id, AppRolesDTO appRolesDTO) {
        return appRolesRepository.findById(id)
                .map(entity -> {
                    appRolesDTO.setId(id);
                    return appRolesMapper.toAppRolesDTO(
                            appRolesRepository.save(appRolesMapper.fromAppRolesDTO(appRolesDTO)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppRolesDTO(int id) {
        try {
            appRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
