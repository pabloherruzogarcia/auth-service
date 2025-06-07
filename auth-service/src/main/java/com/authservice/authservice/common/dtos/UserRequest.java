package com.authservice.authservice.common.dtos;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;

}
