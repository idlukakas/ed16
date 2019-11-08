package com.fatec.scel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.fatec.scel.model.Usuario;
import com.fatec.scel.model.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class REQ05CadastrarUsuario {
	@Autowired
	UsuarioRepository repository;
	private Validator validator;
	private ValidatorFactory validatorFactory;

	@SuppressWarnings("deprecation")
	@Test
	public void CT01CadastrarUsuarioComSucesso() {
		repository.deleteAll();
		Usuario usuario = new Usuario();
		usuario.setNome("Heitor");
		usuario.setRa("666");
		usuario.setCep("04265-060");
		usuario.setEmail("heitor.nobu@gmail.br");
		usuario.setEndereco("Rua Rafinha Tp 43");
		Usuario usuariorep = repository.save(usuario);
		Assert.notNull(usuariorep.getId());
		Assert.notNull(usuariorep.getNome());
		Assert.notNull(usuariorep.getRa());
		Assert.notNull(usuariorep.getCep());
		Assert.notNull(usuariorep.getEmail());
		Assert.notNull(usuariorep.getEndereco());
		assertEquals(1, repository.count());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void CT02CadastrarUsuarioComSucesso_dados_validos() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		Usuario usuario = new Usuario();
		usuario.setNome("Heitor");
		usuario.setRa("666");
		usuario.setCep("04265-060");
		usuario.setEmail("heitor.nobu@gmail.br");
		usuario.setEndereco("Rua Rafinha Tp 43");
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
//		Se os dados estiverem passando, não vai ter nenhuma violação de campo
		assertTrue(violations.isEmpty());
		Assert.notNull(usuario.getNome());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void CT03DeveDetectarTituloInvalido() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		Usuario usuario = new Usuario();
		usuario.setNome("Heitor");
		usuario.setCep("04265-060");
		usuario.setEmail("heitor.nobu@gmail.br");
		usuario.setEndereco("Rua Rafinha Tp 43");
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		assertEquals(violations.size(), 1);
		assertEquals("O ra deve ser preenchido", violations.iterator().next().getMessage());
		Assert.notNull(usuario.getEmail());
	}

}