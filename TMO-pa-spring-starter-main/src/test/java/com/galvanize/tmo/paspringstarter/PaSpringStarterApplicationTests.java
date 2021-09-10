package com.galvanize.tmo.paspringstarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PaSpringStarterApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void isHealthy() throws Exception {
		mockMvc.perform(get("/health"))
				.andExpect(status().isOk());
	}
				.andExpect(status().isOk());
	}
	
	@Test
	void getBook() throws Exception {
		mockMvc.perform(get("/api/books"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.author").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.yearPublished").exists());
	}

	@Test
	void postBook() throws Exception {
		mockMvc.perform(post("/api/books"))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.author").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.yearPublished").exists());
	}
	
	@Test
	void deleteBook() throws Exception {
		mockMvc.perform(delete("/api/books"))
		.andExpect(status().isAccepted());
	}
	
}
