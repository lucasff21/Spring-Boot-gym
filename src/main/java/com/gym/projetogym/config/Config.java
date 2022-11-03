package com.gym.projetogym.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gym.projetogym.model.Musculo;
import com.gym.projetogym.repository.MusculoRepository;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private MusculoRepository musculoRepo;

	@Override
	public void run(String... args) throws Exception {
	
		
	}
	
	
}
