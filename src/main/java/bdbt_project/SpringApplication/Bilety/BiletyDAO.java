package bdbt_project.SpringApplication.Bilety;

import java.util.List;

import bdbt_project.SpringApplication.Bilety.Bilety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class BiletyDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BiletyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // Default constructor

    /* Import org.springframework.jd....Template */
    /* Import java.util.List (zawiera info z bazy danych) */
    public List<Bilety> list(){
        String sql = "SELECT * FROM Bilety";
        List<Bilety> listBilety = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Bilety.class));
        return listBilety;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Bilety bilety) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        // Explicitly set the date format

        insertActor.withTableName("bilety").usingColumns("Nr_biletu","Rodzaj_biletu","Cena","Data",
                "Nr_klubu","Nr_kibica","Nr_meczu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bilety);
        insertActor.execute(param);
    }


    public Bilety get(int Nr_biletu) {

        Object[] args ={Nr_biletu};
        String sql = "SELECT * FROM Bilety WHERE Nr_biletu = " + args[0];
        Bilety bilety = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Bilety.class));
        return bilety;
    }

    /* Update – aktualizacja danych */
    /* Update – aktualizacja danych */
    public void update(Bilety bilety) {
        String sql = "UPDATE Bilety SET Rodzaj_biletu=:Rodzaj_biletu, Cena=:Cena, Data=:Data, " +
                "Nr_klubu=:Nr_klubu, Nr_kibica=:Nr_kibica, Nr_meczu=:Nr_meczu WHERE Nr_biletu=:Nr_biletu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bilety);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_biletu) {

        String sql = "DELETE FROM Bilety WHERE Nr_biletu = ?";
        jdbcTemplate.update(sql, Nr_biletu);

    }


}