package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.exceptions.ItemUsed;
import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Forma;
import pl.edu.pk.azu.magazyn.model.IdProjektu;

import java.util.List;


public interface FormaRepository {

    void dodajForme(Forma forma);

    void uzyjForme(Forma forma) throws NoItemFound, ItemUsed;

    List<Forma> getAll();

    int count(IdProjektu idProjektu);



}
