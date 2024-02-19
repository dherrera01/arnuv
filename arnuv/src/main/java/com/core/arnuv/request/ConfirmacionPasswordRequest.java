package com.core.arnuv.request;

import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
public class ConfirmacionPasswordRequest {

    @Comment("serial telefono")
    private String serial;

    @Comment("passwordAnterior")
    private String passwordAnterior;

    @Comment("nuevoPass")
    private String nuevoPass;

    @Comment("confirmacionPass")
    private String confirmacionPass;
}
