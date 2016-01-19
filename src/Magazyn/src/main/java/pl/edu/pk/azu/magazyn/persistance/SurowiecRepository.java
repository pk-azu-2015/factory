package pl.edu.pk.azu.magazyn.persistance;

public interface SurowiecRepository {
    public static final int CRITICAL_LEVEL = 10;

    void dodajSurowiec(int ilosc);
    void pobierzSurowiec(int ilosc);
    int aktualnyStan();
}
