package pl.edu.pk.azu.magazyn.utils;


import pl.edu.pk.azu.magazyn.exceptions.BadParam;
import pl.edu.pk.azu.magazyn.model.IdProjektu;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;

public class ProjektFactory {
    public static Projekt createProject(int idProjektu, int idStan) throws BadParam {
        IdProjektu idProjektuEnum = IdProjektu.fromInt(idProjektu);
        if (idProjektuEnum == null) {
            throw new BadParam(idProjektu, IdProjektu.getMaxId());
        }
        Stan stanEnum = Stan.fromInt(idStan);
        if (stanEnum == null) {
            throw new BadParam(idStan, Stan.getMaxId());
        }

        Projekt projekt = new Projekt(idProjektuEnum, stanEnum);
        return projekt;
    }
}
