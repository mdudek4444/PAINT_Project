package bdbt_project.SpringApplication.Pracownicy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pracownicy {

    private int Nr_pracownika;
    private String Imie;
    private String Nazwisko;
    private int PESEL;
    private String Plec;
    private int Telefon_sluzbowy;
    private String Obywatelstwo;
    private Date Data_urodzenia;
    private Date Data_zatrudnienia;
    private String Email;
    private Date Data_zwolnienia;
    private int Nr_klubu;
    private int Nr_stadionu;
    private int Nr_stanowiska;
    private int Nr_adresu;


    public Pracownicy(int nr_pracownika, String imie, String nazwisko, int PESEL, String plec, int telefon_sluzbowy,
                      String obywatelstwo, Date data_urodzenia, Date data_zatrudnienia, String email,
                      Date data_zwolnienia, int nr_klubu, int nr_stadionu, int nr_stanowiska, int nr_adresu) {
        this.Nr_pracownika = nr_pracownika;
        this.Imie = imie;
        this.Nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.Plec = plec;
        this.Telefon_sluzbowy = telefon_sluzbowy;
        this.Obywatelstwo = obywatelstwo;
        this.Data_urodzenia = data_urodzenia;
        this.Data_zatrudnienia = data_zatrudnienia;
        this.Email = email;
        this.Data_zwolnienia = data_zwolnienia;
        this.Nr_klubu = nr_klubu;
        this.Nr_stadionu = nr_stadionu;
        this.Nr_stanowiska = nr_stanowiska;
        this.Nr_adresu = nr_adresu;
    }

    public Pracownicy() {
        // Konstruktor domyślny bez argumentów
    }

    public String getFormattedDataUrodzenia() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(Data_urodzenia));
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return String.valueOf(Data_urodzenia); // Return the original date if an error occurs
        }
    }

    public String getFormattedDataZatrudnienia() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(Data_zatrudnienia));
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return String.valueOf(Data_zatrudnienia); // Return the original date if an error occurs
        }
    }
    public String getFormattedDataZwolnienia() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(Data_zwolnienia));
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return String.valueOf(Data_zwolnienia); // Return the original date if an error occurs
        }
    }

    public int getNr_pracownika() {
        return Nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        Nr_pracownika = nr_pracownika;
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

    public String getPlec() {
        return Plec;
    }

    public void setPlec(String plec) {
        Plec = plec;
    }

    public int getTelefon_sluzbowy() {
        return Telefon_sluzbowy;
    }

    public void setTelefon_sluzbowy(int telefon_sluzbowy) {
        Telefon_sluzbowy = telefon_sluzbowy;
    }

    public String getObywatelstwo() {
        return Obywatelstwo;
    }

    public void setObywatelstwo(String obywatelstwo) {
        Obywatelstwo = obywatelstwo;
    }

    public Date getData_urodzenia() {
        return Data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        Data_urodzenia = data_urodzenia;
    }

    public Date getData_zatrudnienia() {
        return Data_zatrudnienia;
    }

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        Data_zatrudnienia = data_zatrudnienia;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getData_zwolnienia() {
        return Data_zwolnienia;
    }

    public void setData_zwolnienia(Date data_zwolnienia) {
        Data_zwolnienia = data_zwolnienia;
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

    public int getNr_stanowiska() {
        return Nr_stanowiska;
    }

    public void setNr_stanowiska(int nr_stanowiska) {
        Nr_stanowiska = nr_stanowiska;
    }

    public int getNr_adresu() {
        return Nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        Nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Pracownicy{" +
                "Nr_pracownika=" + Nr_pracownika +
                ", Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", PESEL=" + PESEL +
                ", Plec='" + Plec + '\'' +
                ", Telefon_sluzbowy=" + Telefon_sluzbowy +
                ", Obywatelstwo='" + Obywatelstwo + '\'' +
                ", Data_urodzenia=" + Data_urodzenia +
                ", Data_zatrudnienia=" + Data_zatrudnienia +
                ", Email='" + Email + '\'' +
                ", Data_zwolnienia=" + Data_zwolnienia +
                ", Nr_klubu=" + Nr_klubu +
                ", Nr_stadionu=" + Nr_stadionu +
                ", Nr_stanowiska=" + Nr_stanowiska +
                ", Nr_adresu=" + Nr_adresu +
                '}';
    }
}
