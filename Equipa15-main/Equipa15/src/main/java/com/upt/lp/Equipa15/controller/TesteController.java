package com.upt.lp.Equipa15.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@GetMapping
	public String hello() {
		return "API working!";
	}
}
