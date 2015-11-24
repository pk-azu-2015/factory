package pl.edu.pk.azu.magazyn.utils;

import pl.edu.pk.azu.magazyn.model.IdProjektu;
import pl.edu.pk.azu.magazyn.model.Stan;

public class EnumUtils {
    public static IdProjektu intToIdProjektu(int idAsInt) {
        return IdProjektu.values()[idAsInt];
    }

    public static Stan intToStan(int stanAsInt) {
        return Stan.values()[stanAsInt];
    }
}
