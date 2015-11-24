package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.exceptions.ItemUsed;
import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Forma;


public interface FormaRepository {

    void dodajForme(Forma forma);

    void wezForme(Forma forma) throws NoItemFound;

    void uzyjForme(Forma forma) throws  NoItemFound, ItemUsed;

}
