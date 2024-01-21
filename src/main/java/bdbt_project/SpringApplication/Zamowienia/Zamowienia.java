package bdbt_project.SpringApplication.Zamowienia;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Zamowienia {

    private int Nr_zamowienia;
    private Date Data_zlozenia;
    private Date Data_wplaty;
    private Date Data_przyjecia_zamowienia;
    private int Nr_klubu;
    private int Nr_kibica;
    private int Nr_faktury;

    public Zamowienia(int nr_zamowienia, Date data_zlozenia, Date data_wplaty, Date data_przyjecia_zamowienia,
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

    public String getFormattedDataZlozenia() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(Data_zlozenia));
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return String.valueOf(Data_zlozenia); // Return the original date if an error occurs
        }
    }

    public String getFormattedDataWplaty() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(Data_wplaty));
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return String.valueOf(Data_wplaty); // Return the original date if an error occurs
        }
    }

    public String getFormattedDataPrzyjeciaZamowienia() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(Data_przyjecia_zamowienia));
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return String.valueOf(Data_przyjecia_zamowienia); // Return the original date if an error occurs
        }
    }

    public int getNr_zamowienia() {
        return Nr_zamowienia;
    }

    public void setNr_zamowienia(int nr_zamowienia) {
        Nr_zamowienia = nr_zamowienia;
    }

    public Date getData_zlozenia() {
        return Data_zlozenia;
    }

    public void setData_zlozenia(Date data_zlozenia) {
        Data_zlozenia = data_zlozenia;
    }

    public Date getData_wplaty() {
        return Data_wplaty;
    }

    public void setData_wplaty(Date data_wplaty) {
        Data_wplaty = data_wplaty;
    }

    public Date getData_przyjecia_zamowienia() {
        return Data_przyjecia_zamowienia;
    }

    public void setData_przyjecia_zamowienia(Date data_przyjecia_zamowienia) {
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
