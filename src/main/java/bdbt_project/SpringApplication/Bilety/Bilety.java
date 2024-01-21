package bdbt_project.SpringApplication.Bilety;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bilety {

    @NotNull(message = "Pole nie może być puste")
    private int Nr_biletu;

    @NotEmpty(message = "Pole nie może być puste")
    private String Rodzaj_biletu;

    @NotNull(message = "Pole nie może być puste")
    private float Cena;

    @NotNull(message = "Pole nie może być puste")
    private String Data;

    @NotNull(message = "Pole nie może być puste")
    private int Nr_klubu;

    @NotNull(message = "Pole nie może być puste")
    private int Nr_kibica;

    @NotNull(message = "Pole nie może być puste")
    private int Nr_meczu;

    public Bilety(int nr_biletu, String rodzaj_biletu, float cena, Date data, int nr_klubu, int nr_kibica, int nr_meczu) {
        this.Nr_biletu = nr_biletu;
        this.Rodzaj_biletu = rodzaj_biletu;
        this.Cena = cena;
        this.Data = String.valueOf(data);
        this.Nr_klubu = nr_klubu;
        this.Nr_kibica = nr_kibica;
        this.Nr_meczu = nr_meczu;
    }

    public Bilety() {
        // Konstruktor domyślny bez argumentów
    }

    public String getFormattedData() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Data);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return Data; // Return the original date if an error occurs
        }
    }


    public int getNr_biletu() {
        return Nr_biletu;
    }

    public void setNr_biletu(int nr_biletu) {
        Nr_biletu = nr_biletu;
    }

    public String getRodzaj_biletu() {
        return Rodzaj_biletu;
    }

    public void setRodzaj_biletu(String rodzaj_biletu) {
        Rodzaj_biletu = rodzaj_biletu;
    }

    public float getCena() {
        return Cena;
    }

    public void setCena(float cena) {
        Cena = cena;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }



    public int getNr_klubu() {
        return Nr_klubu;
    }

    public void setNr_klubu(int nr_klubu) {
        Nr_klubu = nr_klubu;
    }

    public int getNr_kibica() {
        return Nr_kibica;
    }

    public void setNr_kibica(int nr_kibica) {
        Nr_kibica = nr_kibica;
    }

    public int getNr_meczu() {
        return Nr_meczu;
    }

    public void setNr_meczu(int nr_meczu) {
        Nr_meczu = nr_meczu;
    }


    @Override
    public String toString() {
        return "Bilet[" + "Nr_biletu=" + Nr_biletu + ", Rodzaj_biletu='" + Rodzaj_biletu  + ", Cena=" + Cena + ", Data='" + Data  + ", Nr_klubu=" + Nr_klubu + ", Nr_kibica=" + Nr_kibica + ", Nr_meczu=" + Nr_meczu + ']';
    }
}
