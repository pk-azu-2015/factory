package pl.edu.pk.azu.magazyn.utils;

import pl.edu.pk.azu.magazyn.model.Forma;

public class FormaFactory {
    public static Forma createForma(int idProjektu) {
        return new Forma(EnumUtils.intToIdProjektu(idProjektu));
    }
}
