package bdbt_project.SpringApplication.Zamowienia;

public class Zamowienia {

    private int Nr_zamowienia;
    private String Data_zlozenia;
    private String Data_wplaty;
    private String Data_przyjecia_zamowienia;
    private int Nr_klubu;
    private int Nr_kibica;
    private int Nr_faktury;

    public Zamowienia(int nr_zamowienia, String data_zlozenia, String data_wplaty, String data_przyjecia_zamowienia,
                      int nr_klubu, int nr_kibica, int nr_faktury) {
        this.Nr_zamowienia = nr_zamowienia;
        this.Data_zlozenia = data_zlozenia;
        this.Data_wplaty = data_wplaty;
        this.Data_przyjecia_zamowienia = data_przyjecia_zamowienia;
        this.Nr_klubu = nr_klubu;
        this.Nr_kibica = nr_kibica;
        this.Nr_faktury = nr_faktury;
    }

    public Zamowienia() {
        // Konstruktor domyślny bez argumentów
    }

    public int getNr_zamowienia() {
        return Nr_zamowienia;
    }

    public void setNr_zamowienia(int nr_zamowienia) {
        Nr_zamowienia = nr_zamowienia;
    }

    public String getData_zlozenia() {
        return Data_zlozenia;
    }

    public void setData_zlozenia(String data_zlozenia) {
        Data_zlozenia = data_zlozenia;
    }

    public String getData_wplaty() {
        return Data_wplaty;
    }

    public void setData_wplaty(String data_wplaty) {
        Data_wplaty = data_wplaty;
    }

    public String getData_przyjecia_zamowienia() {
        return Data_przyjecia_zamowienia;
    }

    public void setData_przyjecia_zamowienia(String data_przyjecia_zamowienia) {
        Data_przyjecia_zamowienia = data_przyjecia_zamowienia;
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

    public int getNr_faktury() {
        return Nr_faktury;
    }

    public void setNr_faktury(int nr_faktury) {
        Nr_faktury = nr_faktury;
    }

    @Override
    public String toString() {
        return "Zamowienia{" +
                "Nr_zamowienia=" + Nr_zamowienia +
                ", Data_zlozenia='" + Data_zlozenia + '\'' +
                ", Data_wplaty='" + Data_wplaty + '\'' +
                ", Data_przyjecia_zamowienia='" + Data_przyjecia_zamowienia + '\'' +
                ", Nr_klubu=" + Nr_klubu +
                ", Nr_kibica=" + Nr_kibica +
                ", Nr_faktury=" + Nr_faktury +
                '}';
    }
}
