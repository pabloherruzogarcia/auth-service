package com.authservice.authservice.common.dtos;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
