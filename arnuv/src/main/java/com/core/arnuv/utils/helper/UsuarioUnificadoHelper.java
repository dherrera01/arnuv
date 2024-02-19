package com.core.arnuv.utils.helper;

import com.core.arnuv.model.*;
import com.core.arnuv.request.UsuarioUnificadoRequest;

import java.util.Date;

public class UsuarioUnificadoHelper {

    public static Personadetalle crearPersonaDetalle(UsuarioUnificadoRequest request, CatalogoDetalle catDetEntity, Integer idusuario) {
        Personadetalle persona =new Personadetalle();
        persona.setApellidos(request.getApellidos());
        persona.setNombres(request.getNombres());
        persona.setCelular(request.getCelular());
        persona.setEmail(request.getEmail());
        persona.setIdentificacion(request.getIdentificacion());
        persona.setCatalogodetalle(catDetEntity);
        persona.setFechaingreso(new Date());
        persona.setIdusuarioing(idusuario.toString());
        return persona;
    }

    public static Usuariodetalle crearUsuarioDetalle(UsuarioUnificadoRequest request, Personadetalle persona, Integer idusuario) {
        Usuariodetalle usuario =new Usuariodetalle();
        usuario.setIdpersona(persona);
        usuario.setUsername(request.getUsername());
        usuario.setEstado(true);
        usuario.setCambiopassword(false);
        usuario.setObservacion("Ingreso completo");
        usuario.setFechaingreso(new Date());
        usuario.setFechaaprobacion(new Date());
        usuario.setPassword(request.getPassword());
        usuario.setIdusuarioaprobacion(idusuario.toString());
        usuario.setIdusuarioaprobacion(idusuario.toString());
        return usuario;
    }

    public static Usuariorol crearUsuarioRol(UsuarioUnificadoRequest request, Usuariodetalle usuario, Rol rol, Integer idusuario) {
        UsuariorolId id = new UsuariorolId();
        id.setIdrol(request.getIdrol());
        id.setIdusuario(usuario.getIdusuario());

        Usuariorol usuariorol = new Usuariorol();
        usuariorol.setId(id);
        usuariorol.setIdusuario(usuario);
        usuariorol.setIdrol(rol);
        usuariorol.setFechaingreso(new Date());
        usuariorol.setIdususarioing(idusuario.toString());

        return usuariorol;
    }


}
