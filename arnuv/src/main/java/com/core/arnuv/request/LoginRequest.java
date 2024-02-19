package com.core.arnuv.request;

import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class LoginRequest {
    @Comment("serial telefono")
    private String serial;

    @Comment("email")
    private String email;

    @Comment("Password")
    private String password;

    @Comment("Codigo de rol")
    private Integer idrol;
}
