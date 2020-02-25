package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	public void getAllUsrsAPI() throws Exception {
		List userList = new ArrayList<User>();
		User user1 = new User();
		user1.setId(1l);
		userList.add(user1);
		user1.setFirstName("pravin");
		User user2 = new User();
		user2.setId(2l);
		user2.setFirstName("ravi");
		userList.add(user2);

		when(userService.findAll()).thenReturn(userList);
		mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
		// .andExpect(MockMvcResultMatchers.jsonPath("$.Pravin").exists())
		// .andExpect(MockMvcResultMatchers.jsonPath("$.User[*].id").isNotEmpty());
	}

	@Test
	public void getEmployeeByIdAPI() throws Exception {
		User user = new User();
		user.setId(1l);
		user.setFirstName("pravin");
		when(userService.getUsersById(1l)).thenReturn(user);
		mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", 1).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
	}

	@Test
	public void updateUsersAPI() throws Exception {
		
		 List userList = new ArrayList<User>(); User user1 = new User();
		  user1.setId(1l); userList.add(user1); user1.setFirstName("pravin"); User
		  user2 = new User(); user2.setId(2l); user2.setFirstName("ravi");
		  userList.add(user2);
		  
		  when(userService.update(1l, user1)).thenReturn(user1);
		  mockMvc.perform(MockMvcRequestBuilders.put("/users/{id}", 1)
		  .content(asJsonString(new User(1l, "firstName2", "lastName2",
		  "email2@mail.com")))
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isOk());
		 // .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
		  // .andExpect(model().attribute("user", hasProperty("id", is(1))));
		 //.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("lastName2"))
		 //.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email2@mail.com"));
		 	}

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	@Test
	public void deleteUsersAPI() throws Exception {
		//mockMvc.perform(MockMvcRequestBuilders.delete("/users/{id}", 1)).andExpect(status().isAccepted());
	}
}
