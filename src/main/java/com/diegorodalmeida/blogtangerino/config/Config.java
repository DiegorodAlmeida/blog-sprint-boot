package com.diegorodalmeida.blogtangerino.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.diegorodalmeida.blogtangerino.domain.Post;
import com.diegorodalmeida.blogtangerino.domain.Usuario;
import com.diegorodalmeida.blogtangerino.repository.PostRepository;
import com.diegorodalmeida.blogtangerino.repository.UsuarioRepository;

@Configuration
public class Config implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepository.deleteAll();
		postRepository.deleteAll();
		
		Usuario Renan = new Usuario(null, "Renan Almeida", "renan@gmail.com");
		Usuario Isabella = new Usuario(null, "Isabella Almeida", "isabella@gmail.com");
		Usuario Celio = new Usuario(null, "Celio Santos", "celio@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(Renan, Isabella, Celio));
		
		Post post1 = new Post(null, sdf.parse("24/06/2021"), "Estude programação Diego, é tranquilo", "hahaha", Renan);
		Post post2 = new Post(null, sdf.parse("25/06/2021"), "Em pouco tempo, vc sera gerente de projetos", "Não desista", Renan);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
