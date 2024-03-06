package com.example.restservice.controller;

import com.example.restservice.dto.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/crear")
	public Greeting greeting(@RequestBody Greeting usuario){
		System.out.println("usuario creado: "+ usuario.getContent());
		usuario.setContent("hola desde el servidor");

		return  usuario;
	}
}
