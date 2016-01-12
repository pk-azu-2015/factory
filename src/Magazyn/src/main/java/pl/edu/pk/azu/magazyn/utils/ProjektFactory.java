package pl.edu.pk.azu.magazyn.utils;


import pl.edu.pk.azu.magazyn.model.IdProjektu;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;

public class ProjektFactory {
    public static Projekt createProject(int idProjektu, int idStan) {
        IdProjektu idProjektuEnum = IdProjektu.fromInt(idProjektu);
        Stan stanEnum = Stan.fromInt(idStan);

        Projekt projekt = new Projekt(idProjektuEnum, stanEnum);
        return projekt;
    }
}
