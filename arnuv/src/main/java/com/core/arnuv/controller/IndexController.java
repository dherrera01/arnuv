package com.core.arnuv.controller;

import com.core.arnuv.model.Usuariodetalle;
import com.core.arnuv.service.IPersonaDetalleService;
import com.core.arnuv.service.IUsuarioDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "/index";
    }

    @Autowired
    private IUsuarioDetalleService servicioUsuarioDetalle;

    @GetMapping("/listarusuario")
    public String listarUsuarios(Model model) {
        List<Usuariodetalle> lusuariodetalle = servicioUsuarioDetalle.listarTodosUsuariosDetalle();
        model.addAttribute("listaUserD", lusuariodetalle);
        return "/usuario/listarusuario";
    }

    @GetMapping("/nuevousuario")
    public String nuevosClientes(Model model) {
//        List<Usuariodetalle> lusuariodetalle = servicioUsuarioDetalle.listarTodosUsuariosDetalle();
//        model.addAttribute("listaUserD", lusuariodetalle);
        return "/usuario/nuevousuario";
    }
}
