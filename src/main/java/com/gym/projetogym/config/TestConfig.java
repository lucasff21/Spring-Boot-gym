package com.gym.projetogym.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gym.projetogym.model.DiaSemana;
import com.gym.projetogym.model.Exercicio;
import com.gym.projetogym.model.Musculo;
import com.gym.projetogym.repository.DiaSemanaRepository;
import com.gym.projetogym.repository.ExercicioRepository;
import com.gym.projetogym.repository.MusculoRepository;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{
	
	
	@Autowired
	private ExercicioRepository exerc;
	
	@Autowired
	private MusculoRepository musc;

	@Autowired
	private DiaSemanaRepository dia;
	@Override
	public void run(String... args) throws Exception {
		/*
		DiaSemana dia1 = new DiaSemana(null, "Segunda-feira");
		
		dia.saveAll(Arrays.asList(dia1));
		
		Musculo msc = new Musculo(null ,"Costas", "null", dia1);
		
		musc.saveAll(Arrays.asList(msc));
		
		
		Exercicio ex =  new Exercicio(null, "Remada", 4, 12, "45°", 20, msc);
		
		exerc.saveAll(Arrays.asList(ex));
		*/
		
	}

}
