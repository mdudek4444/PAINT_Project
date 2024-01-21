package bdbt_project.SpringApplication.Mecze;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mecze {

    private int Nr_meczu;
    private String Druzyna_przeciwna;
    private String Data;
    private String Godzina;
    private String Imie_sedziego;
    private String Nazwisko_sedziego;
    private String Wynik;
    private int Nr_klubu;
    private int Nr_stadionu;


    public Mecze(int nr_meczu, String druzyna_przeciwna, Date data, String godzina, String imie_sedziego,
                 String nazwisko_sedziego, String wynik, int nr_klubu, int nr_stadionu) {
        this.Nr_meczu = nr_meczu;
        this.Druzyna_przeciwna = druzyna_przeciwna;
        this.Data = String.valueOf(data);
        this.Godzina = godzina;
        this.Imie_sedziego = imie_sedziego;
        this.Nazwisko_sedziego = nazwisko_sedziego;
        this.Wynik = wynik;
        this.Nr_klubu = nr_klubu;
        this.Nr_stadionu = nr_stadionu;
    }

    public Mecze(){

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


    public int getNr_meczu() {
        return Nr_meczu;
    }

    public void setNr_meczu(int nr_meczu) {
        Nr_meczu = nr_meczu;
    }

    public String getDruzyna_przeciwna() {
        return Druzyna_przeciwna;
    }

    public void setDruzyna_przeciwna(String druzyna_przeciwna) {
        Druzyna_przeciwna = druzyna_przeciwna;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getGodzina() {
        return Godzina;
    }

    public void setGodzina(String godzina) {
        Godzina = godzina;
    }

    public String getImie_sedziego() {
        return Imie_sedziego;
    }

    public void setImie_sedziego(String imie_sedziego) {
        Imie_sedziego = imie_sedziego;
    }

    public String getNazwisko_sedziego() {
        return Nazwisko_sedziego;
    }

    public void setNazwisko_sedziego(String nazwisko_sedziego) {
        Nazwisko_sedziego = nazwisko_sedziego;
    }

    public String getWynik() {
        return Wynik;
    }

    public void setWynik(String wynik) {
        Wynik = wynik;
    }

    public int getNr_klubu() {
        return Nr_klubu;
    }

    public void setNr_klubu(int nr_klubu) {
        Nr_klubu = nr_klubu;
    }

    public int getNr_stadionu() {
        return Nr_stadionu;
    }

    public void setNr_stadionu(int nr_stadionu) {
        Nr_stadionu = nr_stadionu;
    }

    @Override
    public String toString() {
        return "Mecze{" +
                "Nr_meczu=" + Nr_meczu +
                ", Druzyna_przeciwna='" + Druzyna_przeciwna + '\'' +
                ", Data='" + Data + '\'' +
                ", Godzina=" + Godzina +
                ", Imie_sedziego='" + Imie_sedziego + '\'' +
                ", Nazwisko_sedziego=" + Nazwisko_sedziego +
                ", Wynik='" + Wynik + '\'' +
                ", Nr_klubu=" + Nr_klubu +
                ", Nr_stadionu=" + Nr_stadionu +
                '}';
    }
}
