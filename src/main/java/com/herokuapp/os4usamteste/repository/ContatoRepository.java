package com.herokuapp.os4usamteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.herokuapp.os4usamteste.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Integer>{

}
