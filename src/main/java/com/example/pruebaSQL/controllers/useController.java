package com.example.pruebaSQL.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaSQL.models.User;
import com.example.pruebaSQL.repositories.UserRepositories;

@RestController
@RequestMapping("/users")
public class useController {

    private final UserRepositories repositorio;

    @Autowired
    public useController(UserRepositories repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<User> Hola(){
        return repositorio.getAlluser();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable int id){
        return repositorio.getUserById(id);
    }

    @PostMapping
    public User AddUser(@RequestBody User user){
        repositorio.newUser(user);
        return user;
    }

    @PutMapping("/{id}")
    public String UpdateUserByID(@PathVariable int id, @RequestBody User use){
        repositorio.updateUser(id, use);
        return "Se actualizaron los datos";
    }

    @DeleteMapping("/{id}")
    public String DeleteUser(@PathVariable int id){
        repositorio.deleteById(id);
        return "Se elimino el usuario";
    }
}
