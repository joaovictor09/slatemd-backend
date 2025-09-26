package com.joaovictor09.slatemd.modules.user.controllers;

import com.joaovictor09.slatemd.modules.user.dtos.CreateUserDTO;
import com.joaovictor09.slatemd.modules.user.entities.User;
import com.joaovictor09.slatemd.modules.user.usecases.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody CreateUserDTO createUserDTO) throws Exception {
        var user = this.createUserUseCase.execute(createUserDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
