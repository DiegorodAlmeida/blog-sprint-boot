package com.diegorodalmeida.blogtangerino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegorodalmeida.blogtangerino.domain.Usuario;
import com.diegorodalmeida.blogtangerino.dto.UsuarioDTO;
import com.diegorodalmeida.blogtangerino.repository.UsuarioRepository;




@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public List <Usuario> findAll (){
		return repo.findAll();
	}
	
	public Usuario insert (Usuario obj) {
		return repo.insert(obj);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) { 
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
} 
