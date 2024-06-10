package bdbt_project.SpringApplication.Kibice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KibiceDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public KibiceDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Kibice> list() {
        String sql = "SELECT * FROM Kibice";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Kibice.class));
    }

    public void save(Kibice kibice) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("kibice")
                .usingColumns("Nr_kibica", "Imie", "Nazwisko", "PESEL", "Email", "Telefon", "Data_urodzenia", "Nr_klubu", "Nr_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kibice);
        insertActor.execute(param);
    }

    public Kibice get(int Nr_kibica) {
        String sql = "SELECT * FROM Kibice WHERE Nr_kibica = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{Nr_kibica}, BeanPropertyRowMapper.newInstance(Kibice.class));
    }

    public Kibice getFirst() {
        String sql = "SELECT * FROM Kibice WHERE ROWNUM = 1 ORDER BY Nr_kibica";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Kibice.class));
    }

    public void update(Kibice kibice) {
        String sql = "UPDATE Kibice SET Imie=:Imie, Nazwisko=:Nazwisko, PESEL=:PESEL, " +
                "Email=:Email, Telefon=:Telefon, Data_urodzenia=:Data_urodzenia, " +
                "Nr_klubu=:Nr_klubu, Nr_adresu=:Nr_adresu " + "WHERE Nr_kibica=:Nr_kibica";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kibice);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);


        template.update(sql, param);
    }

    public void delete(int Nr_kibica) {
        String sql = "DELETE FROM Kibice WHERE Nr_kibica = ?";
        jdbcTemplate.update(sql, Nr_kibica);
    }
}
