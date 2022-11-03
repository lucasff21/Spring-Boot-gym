package com.gym.projetogym.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gym.projetogym.model.Musculo;
import com.gym.projetogym.repository.MusculoRepository;

@Controller
@RequestMapping("/")
public class MusculoThymeController {
	
	@Autowired
	private MusculoRepository musculoRep;

	@RequestMapping
	public String showMusculos(Model model) {
		model.addAttribute("musculos", musculoRep.findAll());
		return "index";
	}
}
