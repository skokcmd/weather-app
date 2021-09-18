package com.skokcmd.homework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class HomeworkApplicationTests {

	@Container
	public static PostgreSQLContainer<?> container =
			new PostgreSQLContainer<>("postgres:11-alpine")
					.withUsername("postgres")
					.withPassword("postgres")
					.withDatabaseName("homework")
					.withInitScript("db\\initial.sql"); // vytvori novou database table


	//  container predava props docker instanci
	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry props) {
		props.add("spring.datasource.url", container::getJdbcUrl);
		props.add("spring.datasource.username", container::getUsername);
		props.add("spring.datasource.password", container::getPassword);
	}


	@BeforeAll
	static void setUp() {
		container.start();
	}

	@Test
	void contextLoads() {
		System.out.println("loaded app");
	}

	// writing tests sucks

}
