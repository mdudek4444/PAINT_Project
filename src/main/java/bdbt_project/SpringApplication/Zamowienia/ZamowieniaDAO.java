package bdbt_project.SpringApplication.Zamowienia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZamowieniaDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ZamowieniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // Default constructor

    /* Import org.springframework.jd....Template */
    /* Import java.util.List (zawiera info z bazy danych) */
    public List<Zamowienia> list(){
        String sql = "SELECT * FROM Zamowienia";
        List<Zamowienia> listZamowienia = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Zamowienia.class));
        return listZamowienia;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Zamowienia zamowienia) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        // Explicitly set the date format
        insertActor.getJdbcTemplate().execute("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'");

        insertActor.withTableName("zamowienia").usingColumns("Nr_zamowienia","Data_zlozenia","Data_wplaty",
                "Data_przyjecia_zamowienia","Nr_klubu","Nr_kibica","Nr_faktury");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zamowienia);
        insertActor.execute(param);
    }


    public Zamowienia get(int Nr_zamowienia) {

        Object[] args ={Nr_zamowienia};
        String sql = "SELECT * FROM Zamowienia WHERE Nr_zamowienia = " + args[0];
        Zamowienia zamowienia = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Zamowienia.class));
        return zamowienia;
    }

    /* Update – aktualizacja danych */
    /* Update – aktualizacja danych */
    public void update(Zamowienia zamowienia) {
        String sql = "UPDATE Zamowienia SET Data_zlozenia=:Data_zlozenia, Data_wplaty=:Data_wplaty, " +
                "Data_przyjecia_zamowienia=:Data_przyjecia_zamowienia, " + "Nr_klubu=:Nr_klubu, Nr_kibica=:Nr_kibica," +
                " Nr_faktury=:Nr_faktury WHERE Nr_zamowienia=:Nr_zamowienia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zamowienia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_zamowienia) {

        String sql = "DELETE FROM Zamowienia WHERE Nr_zamowienia = ?";
        jdbcTemplate.update(sql, Nr_zamowienia);

    }

}
