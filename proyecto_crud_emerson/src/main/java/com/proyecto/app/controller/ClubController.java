package com.proyecto.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.proyecto.app.service.IClubService;
import com.proyecto.app.entity.Club;


import java.util.Map;

@Controller
@SessionAttributes("club")
public class ClubController {

    @Autowired
    private IClubService clubService;

    @GetMapping("/listarClubs")
    public String listarClubs(Model model) {
        model.addAttribute("clubs", clubService.findAll());
        return "listarClubs";
    }

    @GetMapping("/clubs/nuevo")
    public String crearClub(Map<String, Object> model) {
        Club club = new Club();
        model.put("club", club);
        return "formClub";
    }

    @PostMapping("/clubs/nuevo")
    public String guardarClub(@Validated Club club, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "formClub";
        }

        clubService.save(club);
        status.setComplete();
        return "redirect:/listarClubs";
    }

    @GetMapping("/clubs/editar/{id}")
    public String editarClub(@PathVariable("id") Long id, Map<String, Object> model) {
        Club club = clubService.findOne(id);
        model.put("club", club);
        return "formClub";
    }

    @GetMapping("/clubs/eliminar/{id}")
    public String eliminarClub(@PathVariable("id") Long id) {
        clubService.delete(id);
        return "redirect:/listarClubs";
    }
}

