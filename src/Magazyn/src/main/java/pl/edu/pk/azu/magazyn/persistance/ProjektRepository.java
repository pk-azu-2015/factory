package pl.edu.pk.azu.magazyn.persistance;


import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Projekt;

public interface ProjektRepository {
    void wezProjekt(Projekt projekt) throws NoItemFound;
    void dodajProjekt(Projekt projekt);
}
