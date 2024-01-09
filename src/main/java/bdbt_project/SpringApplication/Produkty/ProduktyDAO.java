package bdbt_project.SpringApplication.Produkty;

import bdbt_project.SpringApplication.Bilety.Bilety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProduktyDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProduktyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    // Default constructor

    /* Import org.springframework.jd....Template */
    /* Import java.util.List (zawiera info z bazy danych) */
    public List<Produkty> list(){
        String sql = "SELECT * FROM Produkty";
        List<Produkty> listProdukty = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Produkty.class));
        return listProdukty;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Produkty produkty) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        // Explicitly set the date format
        insertActor.getJdbcTemplate().execute("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'");

        insertActor.withTableName("produkty").usingColumns("Nr_produktu","Nazwa_produktu","Cena","Rodzaj_produktu",
                "Producent","Nr_klubu","Nr_producenta");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(produkty);
        insertActor.execute(param);
    }


    public Produkty get(int Nr_produktu) {

        Object[] args ={Nr_produktu};
        String sql = "SELECT * FROM Produkty WHERE Nr_produktu = " + args[0];
        Produkty produkty = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Produkty.class));
        return produkty;
    }

    /* Update – aktualizacja danych */
    /* Update – aktualizacja danych */
    public void update(Produkty produkty) {
        String sql = "UPDATE Produkty SET Nazwa_produktu=:Nazwa_produktu, Cena=:Cena, Rodzaj_produktu=:Rodzaj_produktu, " +
                "Producent=:Producent, Nr_klubu=:Nr_klubu, Nr_producenta=:Nr_producenta WHERE Nr_produktu=:Nr_produktu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(produkty);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }


    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_produktu) {

        String sql = "DELETE FROM Produkty WHERE Nr_produktu = ?";
        jdbcTemplate.update(sql, Nr_produktu);

    }

}
