package com.project.yaakhayer.dto;

import com.project.yaakhayer.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDonateurRequest {

    private String username;

    private String email;

    private Role role;

    private String password;

    private String firstName;

    private String lastName;

    private int numero;

}
