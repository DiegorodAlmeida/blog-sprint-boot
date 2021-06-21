package com.diegorodalmeida.blogtangerino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegorodalmeida.blogtangerino.domain.Usuario;
import com.diegorodalmeida.blogtangerino.dto.UsuarioDTO;
import com.diegorodalmeida.blogtangerino.repository.UsuarioRepository;
import com.diegorodalmeida.blogtangerino.service.exception.ObjectNotFoundException;




@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public List <Usuario> findAll (){
		return repo.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Usuario insert (Usuario obj) {
		return repo.insert(obj);
	}
	
	public void delete (String Id) {
		findById(Id);
		repo.deleteById(Id);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) { 
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
	
	public Usuario update (Usuario obj) {
		Usuario newObj = findById(obj.getId());
		updateData (newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Usuario newObj, Usuario obj) {
		// TODO Auto-generated method stub
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}

	
} 
