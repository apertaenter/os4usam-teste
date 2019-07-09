package com.herokuapp.os4usamteste.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.os4usamteste.model.Contato;

@RestController
public class ContatoController {
	
	Map<Integer,Contato> contatos;
	Integer proximoId = 0;
	
	// Business
	
	private Contato incluir(Contato contato) {
		
		if (contatos == null) {
			contatos = new HashMap<>();
		}
		
		contato.setId(++proximoId);
		contatos.put(contato.getId(),contato);
		
		return contato;
	}
	
	private Collection<Contato> listar(){
		if (contatos == null) {
			contatos = new HashMap<>();
		}
		return contatos.values();
	}
	
	// End points
	
	@RequestMapping(method=RequestMethod.POST,value="/contatos",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> incluirContato(@RequestBody Contato contato) {
		
		Contato contatoIncluido = incluir(contato);
		
		return new ResponseEntity<Contato>(contatoIncluido,HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/contatos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Contato>> listarContatos() {
		
		Collection<Contato> listaDeContatos = listar();
		
		return new ResponseEntity<>(listaDeContatos,HttpStatus.OK);
	}
}
