package com.skokcmd.homework;

import com.skokcmd.homework.model.HistoryRecord;
import com.skokcmd.homework.service.HistoryRecordServiceImp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class HomeworkApplicationTests {

    @Autowired
    private HistoryRecordServiceImp historyRecordService;

    @Container
    static final PostgreSQLContainer<?> container =
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

    @Test
    void createRecord() {
        HistoryRecord hr = new HistoryRecord(
                "Ostrava",
                19.3
        );
        assertThat(hr.getMesto().equals("Ostrava"));
        assertThat(hr.getTeplota() == 19.3);
    }

    @Test
    void saveRecord() {

        HistoryRecord hr = new HistoryRecord(
                "Ostrava",
                19.3
        );
        historyRecordService.saveRecord(hr);
        List<HistoryRecord> testList = historyRecordService.getAllRecords();
        // checks
        assertThat(!testList.isEmpty());
        assertThat(testList.size() == 1);
        assertThat(testList.get(0).getMesto().equals("Ostrava"));
    }

    @Test
    void readRecord() {
		
        HistoryRecord hr = new HistoryRecord(
                "Prague",
                20.2
        );
        historyRecordService.saveRecord(hr);
        HistoryRecord readFromDb = historyRecordService.getAllRecords().get(0);
        assertThat(readFromDb.getMesto().equals("Prague"));
        assertThat(readFromDb.getTeplota() == 20.2);
    }
}
