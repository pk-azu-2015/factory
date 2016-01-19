package pl.edu.pk.azu.magazyn.persistance;


import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.IdProjektu;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;

import java.util.List;

public interface ProjektRepository {
    void wezProjekt(Projekt projekt) throws NoItemFound;

    void dodajProjekt(Projekt projekt);

    /**
     * Zwraca wszystkie  IdProjektu o zadanym stanie, czyli
     * pytając o Stan = Stan.ZEPSUTY możemy otrzymać
     * listę = {0 ,0 ,1 , 1 ,2}, którą można prztłumaczyć na
     * {IdProjektu.KOLO, IdProjektu.KOLO, IdProjektu.SILNIK, IdProjektu.SILNIK, IdProjektu.KAROSERIA}
     */
    List<Integer> zwrocProjektyOStanie(Stan stan);

    int count(Stan stan, IdProjektu idProjektu);

}
