package com.rayyan.ecommerce.service;

import com.rayyan.ecommerce.dto.*;
import com.rayyan.ecommerce.ecommerceObjects.Payment;
import com.rayyan.ecommerce.ecommerceObjects.Product;
import com.rayyan.ecommerce.ecommerceObjects.Roles;
import com.rayyan.ecommerce.repositories.ReviewRepository;
import com.rayyan.ecommerce.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesService {

    @Autowired
    RolesRepository rolesRepository;

    public List<Roles> getlist(){
        return rolesRepository.findAll();
    }

    public String addRoles(RolesAddDto rolesAddDto){
        Roles roles = new Roles();
        roles.setName(rolesAddDto.getName());
        roles.setDescription(rolesAddDto.getDescription());

        rolesRepository.save(roles);
        return "Roles added";

    }

    public Roles findRolesById(Long id){
        return rolesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Roles not found"));
    }


    public Roles editRoles(Long id, RolesEditDto rolesEditDto) {

        Roles existingRoles = findRolesById(id);
        existingRoles.setName(rolesEditDto.getName());
        existingRoles.setDescription(rolesEditDto.getDescription());

        return rolesRepository.save(existingRoles);
    }

    public List<RoleDTO> getDroplist(){
        List<Roles> roles = rolesRepository.findAll();
        List<RoleDTO> roleDTOList = new ArrayList<>();
        for(Roles roles1 : roles){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(roles1.getId());
            roleDTO.setName(roles1.getName());
            roleDTOList.add(roleDTO);
        }
        return roleDTOList;
    }

}
