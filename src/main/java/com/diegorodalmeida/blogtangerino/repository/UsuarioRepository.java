package com.diegorodalmeida.blogtangerino.repository;

import javax.swing.Spring;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diegorodalmeida.blogtangerino.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Spring> {

}