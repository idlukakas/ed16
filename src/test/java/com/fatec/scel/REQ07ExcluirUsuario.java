package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fatec.scel.model.Livro;
import com.fatec.scel.model.LivroRepository;
import com.fatec.scel.model.Usuario;
import com.fatec.scel.model.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class REQ07ExcluirUsuario {

	@Autowired
	UsuarioRepository repository;

	@Test
	public void CT01ExcluirUsuarioComSucesso() {
		repository.deleteAll();
		Usuario usuario = new Usuario();
		usuario.setNome("Heitor");
		usuario.setRa("666");
		usuario.setCep("04265-060");
		usuario.setEmail("heitor.nobu@gmail.br");
		usuario.setEndereco("Rua Rafinha Tp 43");
		repository.save(usuario);
		Usuario user = repository.findByRa(usuario.getRa());
		repository.deleteById(user.getId());
		assertThat(repository.findByRa("666")).isEqualTo(null);
	}
}
