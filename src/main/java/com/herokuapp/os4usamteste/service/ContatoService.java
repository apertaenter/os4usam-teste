package com.herokuapp.os4usamteste.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.os4usamteste.model.Contato;
import com.herokuapp.os4usamteste.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	ContatoRepository contatoRepository;
	
	public Contato incluir(Contato contato) {

		return contatoRepository.save(contato);
	}

	public void excluir(Contato contato) {

		contatoRepository.delete(contato);
		
	}
	
	public Contato alterar(Contato contato) {

		return contatoRepository.save(contato);
		
	}

	public Optional<Contato> buscarPorId(Integer id) {
		
		return contatoRepository.findById(id);
	}

	public Collection<Contato> listar() {
		
		return contatoRepository.findAll();
		
	}
}
