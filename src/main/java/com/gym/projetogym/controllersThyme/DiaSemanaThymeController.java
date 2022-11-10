package com.gym.projetogym.controllersThyme;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gym.projetogym.model.DiaSemana;
import com.gym.projetogym.repository.DiaSemanaRepository;
import com.gym.projetogym.repository.MusculoRepository;

@Controller
public class DiaSemanaThymeController {

	@Autowired
	private DiaSemanaRepository diaServ;
	
	@GetMapping("/dias")
	public String showDias(Model model) {
		model.addAttribute("dias", diaServ.findAll());
		return "/dia/index";
	}
	
	@GetMapping("/dias/criar")
	public String createDia(@ModelAttribute("dia") DiaSemana diasemana) {
		return "/dia/create";
	}
	
	@PostMapping("/dias/salvar")
	public String saveDia(@ModelAttribute("dia") DiaSemana diasemana) {
		diaServ.save(diasemana);
		return "redirect:/dias";
	}
	
	@GetMapping("/dia/{id}")
	public String changeDia(@PathVariable("id") Long id, Model model) {
		Optional<DiaSemana> diaOpt = diaServ.findById(id);
		if(diaOpt.isEmpty()) {
			throw new IllegalArgumentException("Dia invalida");
		}
		
		model.addAttribute("dia", diaOpt.get());
		return "/dia/create";
	}
	
	@GetMapping("/dia/excluir/{id}")
	public String deleteDia(@PathVariable("id") Long id) {
		Optional<DiaSemana> diaOpt = diaServ.findById(id);
		if(diaOpt.isEmpty()) {
			throw new IllegalArgumentException("Dia invalida");
		}
		diaServ.delete(diaOpt.get());
		return "redirect:/dias";
		
	}
}
