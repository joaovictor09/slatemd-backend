package com.joaovictor09.slatemd.modules.user.usecases;

import com.joaovictor09.slatemd.modules.user.dtos.CreateUserDTO;
import com.joaovictor09.slatemd.modules.user.entities.User;
import com.joaovictor09.slatemd.modules.user.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private UsersRepository usersRepository;

    public User execute(CreateUserDTO data) throws Exception {
        User newUser = new User(data);

        var userExists = this.usersRepository.findByEmail(data.getEmail()).isPresent();

        if(userExists) {
            throw new Exception("Usuario ja existe");
        }

        return this.usersRepository.save(newUser);
    }

}
