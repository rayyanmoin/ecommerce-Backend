package com.rayyan.ecommerce.service;

import com.rayyan.ecommerce.dto.*;
import com.rayyan.ecommerce.ecommerceObjects.Review;
import com.rayyan.ecommerce.ecommerceObjects.Roles;
import com.rayyan.ecommerce.ecommerceObjects.Users;
import com.rayyan.ecommerce.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserListDto> getlist(){
        List<UserListDto> userListDtos = new ArrayList<>();

        List<Users> users = userRepository.findAll();
        for (Users user : users) {
            UserListDto dto = new UserListDto();
            dto.setId(user.getId());
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            dto.setEmail(user.getEmail());
            dto.setCreatedAt(user.getCreatedAt());
            dto.setPassword(user.getPassword());
            dto.setPhone(user.getPhone());
            dto.setRoleID(user.getRoleID());
            dto.setUpdatedAt(user.getUpdatedAt());
            dto.setUsername(user.getUsername());
            dto.setRoleName(user.getRole().getName());

            // Add the DTO to the list
            userListDtos.add(dto);
        }
        return  userListDtos;
    }


    public Users findUsersById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Users not found"));
    }


    public String addUser(UserAddDto userAddDto){
        Users user = new Users();

        user.setUsername(userAddDto.getUsername());
        user.setRoleID(userAddDto.getRoleId());
        user.setEmail(userAddDto.getEmail());
        user.setPassword(userAddDto.getPassword());
        user.setFirstName(userAddDto.getFirstName());
        user.setLastName(userAddDto.getLastName());
        user.setPhone(userAddDto.getPhone());
        user.setCreatedAt(userAddDto.getCreatedAt());
        user.setUpdatedAt(userAddDto.getUpdatedAt());

        userRepository.save(user);
        return "User added";

    }

    public Users editUsers(Long id, UserEditDto userEditDto) {

        Users existingUsers = findUsersById(id);
        existingUsers.setUsername(userEditDto.getUsername());
        existingUsers.setRoleID(userEditDto.getRoleId());
        existingUsers.setEmail(userEditDto.getEmail());
        existingUsers.setPassword(userEditDto.getPassword());
        existingUsers.setFirstName(userEditDto.getFirstName());
        existingUsers.setLastName(userEditDto.getLastName());
        existingUsers.setPhone(userEditDto.getPhone());
        existingUsers.setCreatedAt(userEditDto.getCreatedAt());
        existingUsers.setUpdatedAt(userEditDto.getUpdatedAt());

        return userRepository.save(existingUsers);
    }

    public List<UsersDTO> getDroplist(){
        List<Users> users = userRepository.findAll();
        List<UsersDTO> userDropList = new ArrayList<>();
        for(Users users1 : users){
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setId(users1.getId());
            usersDTO.setName(users1.getFirstName()+users1.getLastName());
            userDropList.add(usersDTO);
        }
        return userDropList;
    }


}
