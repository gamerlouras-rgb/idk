package com.upt.lp.Equipa15.controller;

import com.upt.lp.Equipa15.DTO.UserDTO;
import com.upt.lp.Equipa15.entity.User;
import com.upt.lp.Equipa15.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



    @RestController
    @RequestMapping("/api/users")
    public class UserController{
        private final UserService userService;

        public UserController(UserService userService){
            this.userService = userService;
        }
        @GetMapping //GET/api/users
        public List<User> getAll(){
            return userService.getAllUsers();
        }
        @GetMapping("/{id}") //GET/api/users/{id}
        public User getById(@PathVariable Long id){
            return userService.getUser(id);
        }

        @PostMapping
        public User create(@RequestBody UserDTO dto) {
            return userService.createUser(dto);
       }

    
        @PutMapping("/{id}")
        public User update(@PathVariable Long id, @RequestBody UserDTO dto) {
            return userService.updateUser(id, dto);
        }

        @DeleteMapping("/{id}") //DELETE/api/users/{id}
        public void delete(@PathVariable Long id){
            userService.deleteUser(id);
        }

    
}

