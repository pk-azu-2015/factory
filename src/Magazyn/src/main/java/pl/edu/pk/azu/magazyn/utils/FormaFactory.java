package pl.edu.pk.azu.magazyn.utils;

import pl.edu.pk.azu.magazyn.model.Forma;
import pl.edu.pk.azu.magazyn.model.IdProjektu;
import pl.edu.pk.azu.magazyn.exceptions.BadParam;

public class FormaFactory {
    public static Forma createForma(int idProjektu) throws BadParam {
        IdProjektu typ = IdProjektu.fromInt(idProjektu);
        if (typ != null) {
            return new Forma(typ);
        } else {
            throw new BadParam(idProjektu, IdProjektu.getMaxId());
        }
    }



}
