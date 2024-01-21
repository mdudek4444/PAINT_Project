package bdbt_project.SpringApplication.Kibice;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Kibice {

    @NotNull(message = "Pole nie może być puste")
    private int Nr_kibica;

    @NotEmpty(message = "Pole nie może być puste")
    private String Imie;

    @NotEmpty(message = "Pole nie może być puste")
    private String Nazwisko;


    @Min(value = 10000000000L, message = "PESEL must be at least 11 digits long")
    private int PESEL;

    @NotEmpty(message = "Pole nie może być puste")
    private String Email;

    @NotNull(message = "Pole nie może być puste")
    private int Telefon;

    @NotEmpty(message = "Pole nie może być puste")
    private String Data_urodzenia;

    @NotNull(message = "Pole nie może być puste")
    private int Nr_klubu;

    @NotNull(message = "Pole nie może być puste")
    private int Nr_adresu;

    public Kibice(int nr_kibica, String imie, String nazwisko, int PESEL, String email,
                  int telefon, Date data_urodzenia, int nr_klubu, int nr_adresu) {
        this.Nr_kibica = nr_kibica;
        this.Imie = imie;
        this.Nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.Email = email;
        this.Telefon = telefon;
        this.Data_urodzenia = String.valueOf(data_urodzenia);
        this.Nr_klubu = nr_klubu;
        this.Nr_adresu = nr_adresu;
    }

    public Kibice(){

    }

    public String getFormattedDataUrodzenia() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Data_urodzenia);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return Data_urodzenia; // Return the original date if an error occurs
        }
    }


    public int getNr_kibica() {
        return Nr_kibica;
    }

    public void setNr_kibica(int nr_kibica) {
        Nr_kibica = nr_kibica;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public int getPESEL() {
        return PESEL;
    }

    public void setPESEL(int PESEL) {
        this.PESEL = PESEL;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getTelefon() {
        return Telefon;
    }

    public void setTelefon(int telefon) {
        Telefon = telefon;
    }

    public String getData_urodzenia() {
        return Data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        Data_urodzenia = data_urodzenia;
    }

    public int getNr_klubu() {
        return Nr_klubu;
    }

    public void setNr_klubu(int nr_klubu) {
        Nr_klubu = nr_klubu;
    }

    public int getNr_adresu() {
        return Nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        Nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Kibice{" +
                "Nr_kibica=" + Nr_kibica +
                ", Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", PESEL=" + PESEL +
                ", Email='" + Email + '\'' +
                ", Telefon=" + Telefon +
                ", Data_urodzenia='" + Data_urodzenia + '\'' +
                ", Nr_klubu=" + Nr_klubu +
                ", Nr_adresu=" + Nr_adresu +
                '}';
    }
}
