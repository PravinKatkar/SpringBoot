package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaxServiceTest {

	@Autowired
	JoinedService js;
	
	@Test
	public void brackets() {
		final String bk = js.getBracket(5000);
		assertThat(bk).isEqualTo("LOW");
	}

	@Test
	public void allBrackets() {
		final List<String> ab = js.getAllBrackets();
		assertThat(ab).isNotEmpty();
		assertThat(ab).contains("LOW", "MEDIUM", "HIGH");
	}
	
	
}
