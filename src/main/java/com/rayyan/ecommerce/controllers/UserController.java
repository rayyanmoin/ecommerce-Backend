package com.rayyan.ecommerce.controllers;

import com.rayyan.ecommerce.dto.*;
import com.rayyan.ecommerce.ecommerceObjects.Roles;
import com.rayyan.ecommerce.ecommerceObjects.Users;
import com.rayyan.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<UserListDto> getlist(){
        return userService.getlist();
    }

    @GetMapping("/dropUsers")
    public List<UsersDTO> getDroplist(){
        return userService.getDroplist();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable("id") Long id){
        Users users = userService.findUsersById(id);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserAddDto userAddDto){
        return userService.addUser(userAddDto);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Users> editUsers(@PathVariable("id") Long id, @RequestBody UserEditDto userEditDto){
        Users updatedUsers= userService.editUsers(id, userEditDto);
        return ResponseEntity.ok(updatedUsers);
    }

}
