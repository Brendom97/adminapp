package com.isi.adminapp.controller;

import com.isi.adminapp.dto.AppRolesDTO;
import com.isi.adminapp.service.AppRolesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class AppRolesController {

    private AppRolesService appRolesService;

    @GetMapping
    public List<AppRolesDTO> getAppRoles() {
        return appRolesService.getAppRolesDTO();
    }

    @GetMapping("/{id}")
    public AppRolesDTO getAppRolesDTO(@PathVariable("id") int id) {
        return appRolesService.getAppRoleDTO(id);
    }

    @PostMapping(path = "create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppRolesDTO createAppRoles(@Valid @RequestBody AppRolesDTO appRolesDTO) {
        return appRolesService.createAppRoles(appRolesDTO);
    }

    @PutMapping("/{id}")
    public AppRolesDTO updateAppRoles(@PathVariable("id") int id, @Valid @RequestBody AppRolesDTO appRolesDTO) {
        return appRolesService.updateAppRolesDTO(id, appRolesDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAppRoles(@PathVariable("id") int id) {
        appRolesService.deleteAppRolesDTO(id);
    }
}
