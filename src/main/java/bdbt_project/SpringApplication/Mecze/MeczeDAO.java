package bdbt_project.SpringApplication.Mecze;

import bdbt_project.SpringApplication.Pracownicy.Pracownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeczeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MeczeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // Default constructor

    /* Import org.springframework.jd....Template */
    /* Import java.util.List (zawiera info z bazy danych) */
    public List<Mecze> list(){
        String sql = "SELECT * FROM Mecze";
        List<Mecze> listMecze = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Mecze.class));
        return listMecze;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Mecze mecze) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        // Explicitly set the date format
        insertActor.getJdbcTemplate().execute("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'");

        insertActor.withTableName("mecze").usingColumns("Nr_meczu","Druzyna_przeciwna","Data","Godzina",
                "Imie_sedziego","Nazwisko_sedziego","Wynik", "Nr_klubu","Nr_stadionu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(mecze);
        insertActor.execute(param);
    }


    public Mecze get(int Nr_meczu) {

        Object[] args ={Nr_meczu};
        String sql = "SELECT * FROM Mecze WHERE Nr_meczu = " + args[0];
        Mecze mecze = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Mecze.class));
        return mecze;
    }

    /* Update – aktualizacja danych */
    /* Update – aktualizacja danych */
    public void update(Mecze mecze) {
        String sql = "UPDATE Mecze SET Druzyna_przeciwna=:Druzyna_przeciwna, Data=:Data, Godzina=:Godzina, " +
                "Imie_sedziego=:Imie_sedziego, Nazwisko_sedziego=:Nazwisko_sedziego, Wynik=:Wynik, " +
                "Nr_klubu=:Nr_klubu, Nr_stadionu=:Nr_stadionu WHERE Nr_meczu=:Nr_meczu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(mecze);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_meczu) {

        String sql = "DELETE FROM Mecze WHERE Nr_meczu = ?";
        jdbcTemplate.update(sql, Nr_meczu);

    }


}
