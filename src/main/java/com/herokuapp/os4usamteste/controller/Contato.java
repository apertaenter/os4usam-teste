package com.herokuapp.os4usamteste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Contato {
	
	@RequestMapping("/contatos")
	@ResponseBody
	String home() {
		return "Hello World! [CONTROLLER]";
	}
}
