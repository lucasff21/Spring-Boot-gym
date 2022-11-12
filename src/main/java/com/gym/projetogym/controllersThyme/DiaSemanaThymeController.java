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
public class DiaSemanaThymeController {

	@Autowired
	private DiaSemanaRepository diaServ;
	
	@Autowired
	private MusculoRepository musculoRep;
	
	@Autowired
	private ExercicioRepository exercicioRep;
	
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
	
	@GetMapping("/dias/update/{id}")
	public String changeDia(@PathVariable("id") Long id, Model model) {
		Optional<DiaSemana> diaOpt = diaServ.findById(id);
		if(diaOpt.isEmpty()) {
			throw new IllegalArgumentException("Dia invalida");
		}
		
		model.addAttribute("dia", diaOpt.get());
		return "/dia/create";
	}
	
	@GetMapping("/dias/delete/{id}")
	public String deleteDia(@PathVariable("id") Long id) {
		Optional<DiaSemana> diaOpt = diaServ.findById(id);
		if(diaOpt.isEmpty()) {
			throw new IllegalArgumentException("Dia invalida");
		}
		diaServ.delete(diaOpt.get());
		return "redirect:/dias";
		
	}
	
	
	@GetMapping("/dias/{id}")
	public String getDiaId(@PathVariable("id") Long id, Model model, Musculo musculo,  Exercicio exercicio) {
		List<Exercicio> exercicios = exercicioRep.getExerciciosDia(id);
		List<Musculo> musculos = musculoRep.getMusculos(id);
		Optional<DiaSemana> diaSemanaOpt = diaServ.findById(id);
		if(diaSemanaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa invalida");
		}
		
		model.addAttribute("exercicios", exercicios);
		model.addAttribute("musculos", musculos);
		model.addAttribute("dias", diaSemanaOpt.get());
		
		return "/dia/diaid";		
	}
}
