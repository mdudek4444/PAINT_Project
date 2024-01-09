package bdbt_project.SpringApplication.Kibice;

public class Kibice {

    private int Nr_kibica;
    private String Imie;
    private String Nazwisko;
    private int PESEL;
    private String Email;
    private int Telefon;
    private String Data_urodzenia;
    private String Data_zatrudnienia;
    private int Nr_klubu;
    private int Nr_adresu;

    public Kibice(int nr_kibica, String imie, String nazwisko, int PESEL, String email,
                  int telefon, String data_urodzenia, String data_zatrudnienia, int nr_klubu, int nr_adresu) {
        this.Nr_kibica = nr_kibica;
        this.Imie = imie;
        this.Nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.Email = email;
        this.Telefon = telefon;
        this.Data_urodzenia = data_urodzenia;
        this.Data_zatrudnienia = data_zatrudnienia;
        this.Nr_klubu = nr_klubu;
        this.Nr_adresu = nr_adresu;
    }

    public Kibice(){

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

    public String getData_zatrudnienia() {
        return Data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        Data_zatrudnienia = data_zatrudnienia;
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
                ", Data_zatrudnienia='" + Data_zatrudnienia + '\'' +
                ", Nr_klubu=" + Nr_klubu +
                ", Nr_adresu=" + Nr_adresu +
                '}';
    }
}
