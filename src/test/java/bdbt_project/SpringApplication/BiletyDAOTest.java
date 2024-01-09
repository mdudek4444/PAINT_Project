package bdbt_project.SpringApplication;

import static org.junit.jupiter.api.Assertions.*;

import bdbt_project.SpringApplication.Bilety.Bilety;
import bdbt_project.SpringApplication.Bilety.BiletyDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.*;

class BiletyDAOTest {

    private BiletyDAO dao;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin@localhost:1521:xe");
        datasource.setUsername("MDUDEK6");
        datasource.setPassword("MDUDEK6");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        /* Import JdbcTemplate */
        dao = new BiletyDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testlist() {
        List<Bilety> listBilety = dao.list();

        assertTrue(listBilety.isEmpty());
    }

    @Test
    void save() {
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}