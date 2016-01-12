package pl.edu.pk.azu.magazyn.utils;

import pl.edu.pk.azu.magazyn.model.Forma;
import pl.edu.pk.azu.magazyn.model.IdProjektu;

public class FormaFactory {
    public static Forma createForma(int idProjektu) {
        return new Forma(IdProjektu.fromInt(idProjektu));
    }
}
