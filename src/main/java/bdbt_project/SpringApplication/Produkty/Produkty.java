package bdbt_project.SpringApplication.Produkty;

public class Produkty {

    private int Nr_produktu;
    private String Nazwa_produktu;
    private float Cena;
    private String Rodzaj_produktu;
    private String Producent;
    private int Nr_klubu;
    private int Nr_producenta;

    public Produkty(int nr_produktu, String nazwa_produktu, float cena,
                    String rodzaj_produktu, String producent, int nr_klubu, int nr_producenta) {
        this.Nr_produktu = nr_produktu;
        this.Nazwa_produktu = nazwa_produktu;
        this.Cena = cena;
        this.Rodzaj_produktu = rodzaj_produktu;
        this.Producent = producent;
        this.Nr_klubu = nr_klubu;
        this.Nr_producenta = nr_producenta;
    }

    public Produkty(){

    }

    public int getNr_produktu() {
        return Nr_produktu;
    }

    public void setNr_produktu(int nr_produktu) {
        Nr_produktu = nr_produktu;
    }

    public String getNazwa_produktu() {
        return Nazwa_produktu;
    }

    public void setNazwa_produktu(String nazwa_produktu) {
        Nazwa_produktu = nazwa_produktu;
    }

    public float getCena() {
        return Cena;
    }

    public void setCena(float cena) {
        Cena = cena;
    }

    public String getRodzaj_produktu() {
        return Rodzaj_produktu;
    }

    public void setRodzaj_produktu(String rodzaj_produktu) {
        Rodzaj_produktu = rodzaj_produktu;
    }

    public String getProducent() {
        return Producent;
    }

    public void setProducent(String producent) {
        Producent = producent;
    }

    public int getNr_klubu() {
        return Nr_klubu;
    }

    public void setNr_klubu(int nr_klubu) {
        Nr_klubu = nr_klubu;
    }

    public int getNr_producenta() {
        return Nr_producenta;
    }

    public void setNr_producenta(int nr_producenta) {
        Nr_producenta = nr_producenta;
    }

    @Override
    public String toString() {
        return "Produkty{" +
                "Nr_produktu=" + Nr_produktu +
                ", Nazwa_produktu='" + Nazwa_produktu + '\'' +
                ", Cena=" + Cena +
                ", Rodzaj_produktu='" + Rodzaj_produktu + '\'' +
                ", Producent='" + Producent + '\'' +
                ", Nr_klubu=" + Nr_klubu +
                ", Nr_producenta=" + Nr_producenta +
                '}';
    }
}
