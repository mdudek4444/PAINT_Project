package bdbt_project.SpringApplication.Bilety;

public class Bilety {
    private int Nr_biletu;
    private String Rodzaj_biletu;
    private float Cena;
    private String Data;
    private int Nr_klubu;
    private int Nr_kibica;
    private int Nr_meczu;

    public Bilety(int Nr_biletu, String Rodzaj_biletu, float Cena, String Data, int Nr_klubu, int Nr_kibica, int Nr_meczu) {
        this.Nr_biletu = Nr_biletu;
        this.Rodzaj_biletu = Rodzaj_biletu;
        this.Cena = Cena;
        this.Data = Data;
        this.Nr_klubu = Nr_klubu;
        this.Nr_kibica = Nr_kibica;
        this.Nr_meczu = Nr_meczu;
    }

    public Bilety() {
        // Konstruktor domyślny bez argumentów
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
