package com.diegorodalmeida.blogtangerino.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegorodalmeida.blogtangerino.domain.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity <List<Usuario>> findAll (){
		Usuario renan = new Usuario("Nanam", "Renan Almeida", "renanrodalmeida@gmail.com");
		Usuario isabella = new Usuario("Isa", "Isabella Almeida", "isabellarodalmeida@gmail.com");
		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(renan, isabella));
		return ResponseEntity.ok().body(list);
	}

}
