package com.fatec.scel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.result.ViewResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class REC01CadastrarLivroMVC {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void status0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/livros/cadastrar"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	public void status1() throws Exception {
		ResultActions resultActions1 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/consulta"));
		resultActions1.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions1.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	public void status2() throws Exception {
		ResultActions resultActions2 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/edit"));
		resultActions2.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions2.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	public void status3() throws Exception {
		ResultActions resultActions3 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/delete"));
		resultActions3.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions3.andExpect(MockMvcResultMatchers.status().is(200));
	}
	@Test
	public void status4() throws Exception {
		ResultActions resultActions4 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/update"));
		resultActions4.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions4.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	
	@Test
	public void verificaView0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/livros/cadastrar"));
		ViewResultMatchers view = MockMvcResultMatchers.view();
		resultActions.andExpect(view.name("CadastrarLivro"));
	}
	
	@Test
	public void verificaView1() throws Exception {
	
		ResultActions resultActions1 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/consulta"));
		ViewResultMatchers view1 = MockMvcResultMatchers.view();
		resultActions1.andExpect(view1.name("ConsultarLivros"));
	}
	
	@Test
	public void verificaView2() throws Exception {
		ResultActions resultActions2 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/edit"));
		ViewResultMatchers view2 = MockMvcResultMatchers.view();
		resultActions2.andExpect(view2.name("AtualizaLivro"));
	}
	
	@Test
	public void verificaView3() throws Exception {
		ResultActions resultActions3 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/delete"));
		ViewResultMatchers view3 = MockMvcResultMatchers.view();
		resultActions3.andExpect(view3.name("ConsultarLivros"));
	}
	
	@Test
	public void verificaView4() throws Exception {
		ResultActions resultActions4 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/update"));
		ViewResultMatchers view4 = MockMvcResultMatchers.view();
		resultActions4.andExpect(view4.name("AtualizaLivro"));
	}

	

	@Test // verifica o model
	public void verificaModel0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/livros/cadastrar"));
		ModelResultMatchers model = MockMvcResultMatchers.model();
		resultActions.andExpect(model.attributeExists("livro"));
	}
	
	@Test // verifica o model
	public void verificaModel1() throws Exception {
		ResultActions resultActions1 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/consulta"));
		ModelResultMatchers model1 = MockMvcResultMatchers.model();
		resultActions1.andExpect(model1.attributeExists("livro"));
	}
	
	@Test // verifica o model
	public void verificaModel2() throws Exception {
		ResultActions resultActions2 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/edit"));
		ModelResultMatchers model2 = MockMvcResultMatchers.model();
		resultActions2.andExpect(model2.attributeExists("livro"));
	}
	
	@Test // verifica o model
	public void verificaModel3() throws Exception {
		ResultActions resultActions3 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/delete"));
		ModelResultMatchers model3 = MockMvcResultMatchers.model();
		resultActions3.andExpect(model3.attributeExists("livro"));
	}
	
	@Test // verifica o model
	public void verificaModel4() throws Exception {
		ResultActions resultActions4 = mockMvc.perform(MockMvcRequestBuilders.get("/livros/update"));
		ModelResultMatchers model4 = MockMvcResultMatchers.model();
		resultActions4.andExpect(model4.attributeExists("livro"));
	}
	
	
		
		
		
		
		
	
}
