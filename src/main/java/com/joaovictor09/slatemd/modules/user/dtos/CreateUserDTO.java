package com.joaovictor09.slatemd.modules.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateUserDTO {

    @NotNull
    @Length(min = 4, max = 256)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 8, max = 100)
    private String password;

}
