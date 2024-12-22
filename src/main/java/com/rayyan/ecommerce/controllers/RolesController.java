package com.rayyan.ecommerce.controllers;

import com.rayyan.ecommerce.dto.*;
import com.rayyan.ecommerce.ecommerceObjects.Payment;
import com.rayyan.ecommerce.ecommerceObjects.Review;
import com.rayyan.ecommerce.ecommerceObjects.Roles;
import com.rayyan.ecommerce.service.RolesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
@CrossOrigin(origins = "http://localhost:3000")
public class RolesController {

    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/list")
    public List<Roles> getlist(){
        return rolesService.getlist();
    }

    @PostMapping("/add")
    public String addRoles(@RequestBody RolesAddDto rolesAddDto) {
        return rolesService.addRoles(rolesAddDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRolesById(@PathVariable("id") Long id){
        Roles roles = rolesService.findRolesById(id);
        return ResponseEntity.ok(roles);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Roles> editRoles(@PathVariable("id") Long id, @RequestBody RolesEditDto rolesEditDto){
        Roles updatedRoles = rolesService.editRoles(id, rolesEditDto);
        return ResponseEntity.ok(updatedRoles);
    }


    @GetMapping("/dropRole")
    public List<RoleDTO> getDroplist(){
        return rolesService.getDroplist();
    }

}
