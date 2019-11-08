package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fatec.scel.model.Livro;
import com.fatec.scel.model.LivroRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class REC03ExcluirLivro {

	@Autowired
	LivroRepository repository;
	@Test
	public void CT01ExcluirLivroComSucesso() {
		repository.deleteAll();
		Livro livro = new Livro("3333", "Teste de Software", "Delamaro");
		repository.save(livro);
		Livro ro = repository.findByIsbn("3333");
		repository.deleteById(ro.getId());
		assertThat(repository.findByIsbn("3333")).isEqualTo(null);
	}
}
