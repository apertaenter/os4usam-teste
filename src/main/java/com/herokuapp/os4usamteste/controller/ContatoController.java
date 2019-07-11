package com.herokuapp.os4usamteste.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.os4usamteste.model.Contato;
import com.herokuapp.os4usamteste.service.ContatoService;

@RestController
public class ContatoController {

	@Autowired
	ContatoService contatoService;

	// End points

	@RequestMapping(method = RequestMethod.POST, value = "/contatos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> incluirContato(@RequestBody Contato contato) {

		Contato contatoIncluido = contatoService.incluir(contato);

		return new ResponseEntity<>(contatoIncluido, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/contatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Contato>> listarContatos() {

		Collection<Contato> listaDeContatos = contatoService.listar();

		return new ResponseEntity<>(listaDeContatos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/contatos/{id}")
	public ResponseEntity<Contato> excluirContato(@PathVariable Integer id) {

		if (contatoService.buscarPorId(id).isPresent()) {
			contatoService.excluir(contatoService.buscarPorId(id).get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/contatos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> alterarContato(@RequestBody Contato contato) {

		if (contatoService.buscarPorId(contato.getId()).isPresent()) {
			contatoService.alterar(contato);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

}
