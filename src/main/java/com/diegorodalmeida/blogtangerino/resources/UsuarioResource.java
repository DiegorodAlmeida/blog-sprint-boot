package com.diegorodalmeida.blogtangerino.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diegorodalmeida.blogtangerino.domain.Usuario;
import com.diegorodalmeida.blogtangerino.dto.UsuarioDTO;
import com.diegorodalmeida.blogtangerino.service.UsuarioService;



@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity <List<UsuarioDTO>> findAll() {
		List<Usuario> list = service.findAll();
		List<UsuarioDTO> listDto = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
	
	//POST//
	@PostMapping
 	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDto) {
		Usuario obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
 	public ResponseEntity<Void> update(@RequestBody UsuarioDTO objDto, @PathVariable String id) {
		Usuario obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
