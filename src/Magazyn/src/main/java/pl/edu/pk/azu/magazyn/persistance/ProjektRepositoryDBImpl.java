package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;

import java.util.List;

public class ProjektRepositoryDBImpl implements ProjektRepository {

    public ProjektRepositoryDBImpl() {

    }

    @Override
    public void wezProjekt(Projekt projekt) throws NoItemFound {

    }

    @Override
    public void dodajProjekt(Projekt projekt) {

    }

    @Override
    public List<Integer> zwrocProjektyOStanie(Stan stan) {
        return null;
    }
}
