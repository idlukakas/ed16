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
public class REQ05CadastrarUsuarioMVC {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void status0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/cadastrar"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	public void status1() throws Exception {
		ResultActions resultActions1 = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/consulta"));
		resultActions1.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions1.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	
	@Test
	public void verificaView0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/cadastrar"));
		ViewResultMatchers view = MockMvcResultMatchers.view();
		resultActions.andExpect(view.name("CadastrarUsuario"));
	}
	
	@Test
	public void verificaView1() throws Exception {
	
		ResultActions resultActions1 = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/consulta"));
		ViewResultMatchers view1 = MockMvcResultMatchers.view();
		resultActions1.andExpect(view1.name("ConsultarUsuario"));
	}
	

	@Test // verifica o model
	public void verificaModel0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/cadastrar"));
		ModelResultMatchers model = MockMvcResultMatchers.model();
		resultActions.andExpect(model.attributeExists("usuario"));
	}
	
	@Test // verifica o model
	public void verificaModel1() throws Exception {
		ResultActions resultActions1 = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/consulta"));
		ModelResultMatchers model1 = MockMvcResultMatchers.model();
		resultActions1.andExpect(model1.attributeExists("usuarios"));
	}	
}
