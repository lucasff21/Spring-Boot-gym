package com.gym.projetogym.controllersThyme;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gym.projetogym.model.DiaSemana;
import com.gym.projetogym.model.Exercicio;
import com.gym.projetogym.model.Musculo;
import com.gym.projetogym.repository.DiaSemanaRepository;
import com.gym.projetogym.repository.ExercicioRepository;
import com.gym.projetogym.repository.MusculoRepository;

@Controller
public class MusculoThymeController {
	
	@Autowired
	private MusculoRepository musculoRep;
	
	@Autowired
	private DiaSemanaRepository diaServ;
	
	@Autowired
	private ExercicioRepository exercicioRep;

	@GetMapping("/musculos")
	public String showMusculos(Model model) {
		
		model.addAttribute("musculos", musculoRep.findAll());
		return "/musculo/index";
	}
	
	@GetMapping("/musculos/criar")
	public String novoMusculo(@ModelAttribute("musculo") Musculo musculo, Model model) {
		List<DiaSemana> listaDias = diaServ.findAll();
		model.addAttribute("listaDias", listaDias);
		return "/musculo/create";
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
		return "/musculo/create";
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
	
	
	@GetMapping("/musculos/musculo/{id}") 
	public String getMusculoId(@PathVariable("id") Long id, Model model, Exercicio exercicio) { 
		List<Exercicio> exercicios = exercicioRep.getExercicios(id);
		Optional<Musculo> musculoOpt = musculoRep.findById(id);
		if(musculoOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa invalida");
		}
		
		model.addAttribute("exercicios", exercicios);
		model.addAttribute("musculos", musculoOpt.get());
		return "/musculo/musculoid";
	}
	
	
} 
