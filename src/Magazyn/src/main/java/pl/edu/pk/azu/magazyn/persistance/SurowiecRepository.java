package pl.edu.pk.azu.magazyn.persistance;

public interface SurowiecRepository {
    void dodajSurowiec(int ilosc);
    void pobierzSurowiec(int ilosc);
}
