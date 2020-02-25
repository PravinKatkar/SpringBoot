package com.example.demo;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(JoinedController.class)
public class MyControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	/*
	 * @Before public void setup() { this.mockMvc =
	 * MockMvcBuilders.standaloneSetup(new JoinedController()).build(); }
	 */
	@MockBean 
	JoinedService mjs;
	/*
	 * @Test public void testExample() throws Exception { //final String res
	 * MvcResult mvcResult = this.mockMvc.perform(get("/"))
	 * .andExpect(status().isOk()) .andReturn(); System.out.println("MvcResult " +
	 * mvcResult); }
	 */
	
	@Test
	public void getMedicalRepresentativeFindByIdTestAPI() throws Exception {
		List<String> bkList = Arrays.asList("LOW", "MEDIUM", "HIGH");	
		when(mjs.getAllBrackets()).thenReturn(bkList);
		RequestBuilder request = MockMvcRequestBuilders.get("/getAllBk").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
					andExpect(status().isOk()).
					andExpect(content().json("[\"LOW\", \"MEDIUM\", \"HIGH\"]"))
					.andReturn();
	}
}
