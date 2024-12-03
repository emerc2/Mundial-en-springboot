package com.proyecto.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import com.proyecto.app.service.IJugadorService;
import com.proyecto.app.entity.Jugador;
import java.util.Map;

@Controller
@SessionAttributes("jugador")
public class JugadorController {

    @Autowired
    private IJugadorService jugadorService;

    @GetMapping("/listarJugadores")
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorService.findAll());
        return "listarJugadores";
    }

    @GetMapping("/jugadores/nuevo")
    public String crearJugador(Map<String, Object> model) {
        Jugador jugador = new Jugador();
        model.put("jugador", jugador);
        return "formJugador";
    }

    @PostMapping("/jugadores/nuevo")
    public String guardarJugador(@Validated Jugador jugador, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "formJugador";
        }

        jugadorService.save(jugador);
        status.setComplete();
        return "redirect:/listarJugadores";
    }

    @GetMapping("/jugadores/editar/{id}")
    public String editarJugador(@PathVariable("id") Long id, Map<String, Object> model) {
        Jugador jugador = jugadorService.findOne(id);
        model.put("jugador", jugador);
        return "formJugador";
    }

    @GetMapping("/jugadores/eliminar/{id}")
    public String eliminarJugador(@PathVariable("id") Long id) {
        jugadorService.delete(id);
        return "redirect:/listarJugadores";
    }
}
