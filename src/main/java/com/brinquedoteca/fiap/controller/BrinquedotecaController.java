package com.brinquedoteca.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.brinquedoteca.fiap.model.BrinquedotecaModel;
import com.brinquedoteca.fiap.services.BrinquedotecaService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/brinquedoteca")
public class BrinquedotecaController {

    @Autowired
    private BrinquedotecaService brinquedoService;

    @GetMapping
    public String getAllBrinquedos(@RequestParam(required = false, name="login") String login ,Model model) {
        List<BrinquedotecaModel> brinquedos = brinquedoService.getAllBrinquedos();
        model.addAttribute("brinquedos", brinquedos);
        model.addAttribute("userLogin", login);
        
        return "brinquedo_page";
    }

    @GetMapping("/create")
    public String createBrinquedoForm(Model model) {
        model.addAttribute("brinquedo", new BrinquedotecaModel());
        return "create_brinquedo";
    }

    @PostMapping("/create")
    public String createBrinquedo(@ModelAttribute BrinquedotecaModel brinquedo) {
        brinquedoService.createBrinquedo(brinquedo);
        return "redirect:/brinquedoteca";
    }

    @GetMapping("/edit/{id}")
    public String editBrinquedoForm(@PathVariable Long id, Model model) {
        Optional<BrinquedotecaModel> brinquedo = brinquedoService.getBrinquedoById(id);
        
        System.out.println("Brinquedo" + brinquedo);
        
        if (brinquedo.isPresent()) {
            model.addAttribute("brinquedo", brinquedo.get());
            return "edit_brinquedo";
        } else {
            return "redirect:/brinquedoteca";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateBrinquedo(@PathVariable Long id, @ModelAttribute BrinquedotecaModel brinquedo) {
        brinquedoService.updateBrinquedo(id, brinquedo);
        return "redirect:/brinquedoteca";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrinquedo(@PathVariable Long id) {
        brinquedoService.deleteBrinquedo(id);
        return "redirect:/brinquedoteca";
    }
}
