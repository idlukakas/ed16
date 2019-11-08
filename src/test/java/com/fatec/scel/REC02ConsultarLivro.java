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
public class REC02ConsultarLivro {
	@Autowired
	LivroRepository repository;
	static Livro livro;

	@Test
	public void CT01ConsultaLivro() {
		repository.deleteAll();
		livro = new Livro("3333", "Teste de Software", "Delmar Rogério");
		repository.save(livro);
		Livro ro = repository.findByIsbn("3333");
		assertThat(ro.getTitulo()).isEqualTo(livro.getTitulo());
		assertThat(ro.getAutor()).isEqualTo(livro.getAutor());
		assertThat(ro.getId()).isEqualTo(livro.getId());
		assertThat(ro.getIsbn()).isEqualTo(livro.getIsbn());
		
		
	}
}