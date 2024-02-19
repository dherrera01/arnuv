package com.core.arnuv.request;

import com.core.arnuv.model.Paseo;
import com.core.arnuv.utils.RequestComun;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalTime;

@Data
public class PaseoRequest extends RequestComun<Paseo> {
    @Comment("Codigo del paseo")
    private String idpaseo;
    @Comment("Fecha real de inicio del paseo")
    private Instant fecharealinicio;
    @Comment("Fecha real de fin del paseo")
    private Instant fecharealfin;
    @Comment("Fecha de inicio del paseo formato YYYYMMDD")
    private BigDecimal fechainicio;
    @Comment("Fecha de fin del paseo formato YYYYMMDD")
    private BigDecimal fechafin;
    @Comment("Hora de inicio del paseo")
    private LocalTime horainicio;
    @Comment("Hora de fin del paseo")
    private LocalTime horafin;
    @Comment("Precio total del paseo")
    private BigDecimal preciototal;
    @Comment("Observacion del cliente sobre el paseo")
    private String observacionpaseo;
    @Comment("Observacion del cliente sobre el paseador y su servicio")
    private String observacionpaseador;
}
