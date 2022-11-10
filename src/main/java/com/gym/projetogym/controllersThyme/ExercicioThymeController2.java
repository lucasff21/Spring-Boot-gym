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

import com.gym.projetogym.model.Exercicio;
import com.gym.projetogym.model.Musculo;
import com.gym.projetogym.repository.ExercicioRepository;
import com.gym.projetogym.repository.MusculoRepository;

@Controller
public class ExercicioThymeController2 {
	
	@Autowired
	private ExercicioRepository exercicioRep;
	
	@Autowired
	private MusculoRepository musculoRep;

	@GetMapping("/exercicios")
	public String showExercicios(Model model) {
		
		model.addAttribute("exercicios", exercicioRep.findAll());
		
	
		return "/exercicio/index";
	}
	
	@GetMapping("/exercicios/criar")
	public String novoExercicio(@ModelAttribute("exercicio") Exercicio exercicio, Model model) {
		List<Musculo> listaMusculo = musculoRep.findAll();
		model.addAttribute("listaMusculo", listaMusculo);
		return "/exercicio/create";
	}
	
	@PostMapping("/exercicios/salvar")
	public String salvarExercicio(@ModelAttribute("exercicio") Exercicio exercicio) {
		exercicioRep.save(exercicio);
		return "redirect:/exercicios";
	}
	
	
	@GetMapping("/exercicios/{id}")
	public String alterarExercicio(@PathVariable("id") Long id, Model model) {
		Optional<Exercicio> exercicioOpt = exercicioRep.findById(id);
		if(exercicioOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa invalida");
		}
		
		List<Musculo> listaMusculo = musculoRep.findAll();
		model.addAttribute("listaMusculo", listaMusculo);
		
		model.addAttribute("exercicio", exercicioOpt.get());
		return "/exercicio/create";
	}
	
	@GetMapping("/exercicios/excluir/{id}")
	public String excluirExercicio(@PathVariable("id") Long id) {
		Optional<Exercicio> exercicioOpt = exercicioRep.findById(id);
		if(exercicioOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa invalida");
		}

		exercicioRep.delete(exercicioOpt.get());
		return "redirect:/exercicios";
	}
	
	
	
} 
