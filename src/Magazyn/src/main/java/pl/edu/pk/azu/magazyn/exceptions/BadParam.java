package pl.edu.pk.azu.magazyn.exceptions;

import pl.edu.pk.azu.magazyn.model.IdProjektu;

public class BadParam extends Exception{

    int idProjektu;
    int maxId;

    public BadParam(int idProjektu, int maxId) {
        super("Podano id: " + idProjektu + " maksymalne id to " + maxId);
        this.idProjektu = idProjektu;
        this.maxId = maxId;
    }
}
