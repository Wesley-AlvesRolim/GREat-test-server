package com.great.server.controllers;

import com.great.server.DTO.FindOneUserRequestBody;
import com.great.server.entities.User;
import com.great.server.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    public UserRepository userRepository;

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(path = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object findOneUser(@RequestBody FindOneUserRequestBody body) {

        if (body.getCpf() != "") {
            String cpf = body.getCpf();
            User user = userRepository.findByCpf(cpf);
            return ResponseEntity.ok().body(user);
        }

        if (body.getRg() != "") {
            String rg = body.getRg();
            User user = userRepository.findByRg(rg);
            return ResponseEntity.ok().body(user);
        }

        return ResponseEntity.badRequest();
    }

    @DeleteMapping(path = "/delete")
    public void deleteUser(@RequestBody FindOneUserRequestBody body) {

        // if (body.getCpf() == "cpf") {
        // User user = userRepository.findByCpf(body.getCpf());
        // userRepository.delete(user);
        // }
        // if (body.getRg() == "rg") {
        // User user = userRepository.findByRg(body.getRg());
        // userRepository.delete(user);
        // }
    }
}
