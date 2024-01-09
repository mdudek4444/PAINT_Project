package bdbt_project.SpringApplication.Pracownicy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracownicyDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // Default constructor

    /* Import org.springframework.jd....Template */
    /* Import java.util.List (zawiera info z bazy danych) */
    public List<Pracownicy> list(){
        String sql = "SELECT * FROM Pracownicy";
        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownicy pracownicy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        // Explicitly set the date format
        insertActor.getJdbcTemplate().execute("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'");

        insertActor.withTableName("pracownicy").usingColumns("Nr_pracownika","Imie","Nazwisko","PESEL",
                "Plec","Telefon_sluzbowy","Obywatelstwo","Data_urodzenia","Data_zatrudnienia","Email","Data_zwolnienia",
                "Nr_klubu","Nr_stadionu","Nr_stanowiska","Nr_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        insertActor.execute(param);
    }


    public Pracownicy get(int Nr_pracownika) {

        Object[] args ={Nr_pracownika};
        String sql = "SELECT * FROM Pracownicy WHERE Nr_pracownika = " + args[0];
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }

    /* Update – aktualizacja danych */
    /* Update – aktualizacja danych */
    public void update(Pracownicy pracownicy) {
        String sql = "UPDATE Pracownicy SET Imie=:Imie, Nazwisko=:Nazwisko, PESEL=:PESEL, " +
                "Plec=:Plec, Telefon_sluzbowy=:Telefon_sluzbowy, Obywatelstwo=:Obywatelstwo, " +
                "Data_urodzenia=:Data_urodzenia, Data_zatrudnienia=:Data_zatrudnienia, Email=:Email, " +
                "Data_zwolnienia=:Data_zwolnienia, Nr_klubu=:Nr_klubu, Nr_stadionu=:Nr_stadionu, " +
                "Nr_stanowiska=:Nr_stanowiska, Nr_adresu=:Nr_adresu, " + "WHERE Nr_pracownika=:Nr_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_pracownika) {

        String sql = "DELETE FROM Pracownicy WHERE Nr_pracownika = ?";
        jdbcTemplate.update(sql, Nr_pracownika);

    }

}
