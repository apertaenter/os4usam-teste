package com.herokuapp.os4usamteste.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.herokuapp.os4usamteste.model.Contato;

@Service
public class ContatoService {
	private Map<Integer, Contato> contatos = new HashMap<>();
	private Integer proximoId = 0;

	public Contato incluir(Contato contato) {

		contato.setId(++proximoId);
		contatos.put(contato.getId(), contato);

		return contato;
	}

	public void excluir(Contato contato) {

		contatos.remove(contato.getId());
		
	}
	
	public Contato alterar(Contato contato) {

		contatos.put(contato.getId(),contato);
		return contato;
		
	}

	public Contato buscarPorId(Integer id) {
		
		return contatos.get(id);
	}

	public Collection<Contato> listar() {
		if (contatos == null) {
			contatos = new HashMap<>();
		}
		return contatos.values();
	}
}
