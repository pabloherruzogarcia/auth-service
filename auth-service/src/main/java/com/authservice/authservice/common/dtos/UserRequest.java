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
    private String password;
}
