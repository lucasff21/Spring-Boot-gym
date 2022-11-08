package com.gym.projetogym.controllersThyme;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gym.projetogym.model.Musculo;
import com.gym.projetogym.repository.MusculoRepository;

@Controller
public class MusculoThymeController {
	
	@Autowired
	private MusculoRepository musculoRep;

	@GetMapping("/musculos")
	public String showMusculos(Model model) {
		model.addAttribute("musculos", musculoRep.findAll());
		return "index";
	}
	
	@GetMapping("/musculos/criar")
	public String novoMusculo(@ModelAttribute("musculo") Musculo musculo) {
		return "create";
	}
	
	@PostMapping("/musculos/salvar")
	public String salvarMusculo(@ModelAttribute("musculo") Musculo musculo) {
		musculoRep.save(musculo);
		return "redirect:/musculos";
	}
	
	
	@GetMapping("/musculos/{id}")
	public String alterarMusculo(@PathVariable("id") Long id, Model model) {
		Optional<Musculo> musculoOpt = musculoRep.findById(id);
		if(musculoOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa invalida");
		}
		
		model.addAttribute("musculo", musculoOpt.get());
		return "create";
	}
	
	@GetMapping("/musculos/excluir/{id}")
	public String excluirMusculo(@PathVariable("id") Long id) {
		Optional<Musculo> musculoOpt = musculoRep.findById(id);
		if(musculoOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa invalida");
		}
		
		musculoRep.delete(musculoOpt.get());
		return "redirect:/musculos";
	}
	
	
	
} 
