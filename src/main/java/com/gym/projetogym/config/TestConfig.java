package com.gym.projetogym.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gym.projetogym.model.Exercicio;
import com.gym.projetogym.model.Musculo;
import com.gym.projetogym.repository.ExercicioRepository;
import com.gym.projetogym.repository.MusculoRepository;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{
	
	
	@Autowired
	private ExercicioRepository exerc;
	
	@Autowired
	private MusculoRepository musc;

	@Override
	public void run(String... args) throws Exception {
		/*
		Musculo msc = new Musculo(null ,"Peito", "deitado");
		
		musc.saveAll(Arrays.asList(msc));
		
		
		Exercicio ex =  new Exercicio(null, "supino reto", 4, 12, "aquecer", msc);
		
		exerc.saveAll(Arrays.asList(ex));
		*/
	}

}
