package bdbt_project.SpringApplication.Kibice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.sql.Types;

@Repository
public class KibiceDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public KibiceDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // Default constructor

    /* Import org.springframework.jd....Template */
    /* Import java.util.List (zawiera info z bazy danych) */
    public List<Kibice> list(){
        String sql = "SELECT * FROM Kibice";
        List<Kibice> listKibice = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Kibice.class));
        return listKibice;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Kibice kibice) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        // Explicitly set the date format
/*
            insertActor.getJdbcTemplate().execute("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD'");
*/

        insertActor.withTableName("kibice").usingColumns("Nr_kibica","Imie","Nazwisko","PESEL","Email",
                "Telefon","Data_urodzenia", "Nr_klubu","Nr_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kibice);
        insertActor.execute(param);
    }


    public Kibice get(int Nr_kibica) {

        Object[] args ={Nr_kibica};
        String sql = "SELECT * FROM Kibice WHERE Nr_kibica = " + args[0];
        Kibice kibice = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Kibice.class));
        return kibice;
    }

    /* Update – aktualizacja danych */
    public void update(Kibice kibice) {
        String sql = "UPDATE Kibice SET Imie=:Imie, Nazwisko=:Nazwisko, PESEL=:PESEL, " +
                 "Email=:Email, Telefon=:Telefon, Data_urodzenia=:Data_urodzenia, " +
                "Nr_klubu=:Nr_klubu, Nr_adresu=:Nr_adresu " + "WHERE Nr_kibica=:Nr_kibica";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kibice);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

/*        template.getJdbcTemplate().execute("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD'");*/

        template.update(sql, param);
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_kibica) {

        String sql = "DELETE FROM Kibice WHERE Nr_kibice = ?";
        jdbcTemplate.update(sql, Nr_kibica);

    }

}
