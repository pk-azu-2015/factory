package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.exceptions.ItemUsed;
import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Forma;

public class FormaRepositoryDBImpl implements FormaRepository{


    public FormaRepositoryDBImpl() {
    }

    @Override
    public void dodajForme(Forma forma) {

    }

    @Override
    public void wezForme(Forma forma) throws NoItemFound {

    }

    @Override
    public void uzyjForme(Forma forma) throws NoItemFound, ItemUsed {

    }
}
