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
public class AuthenticationResponse {
    private long id;
    private String token;
    private String username;
    private Role role;
}
