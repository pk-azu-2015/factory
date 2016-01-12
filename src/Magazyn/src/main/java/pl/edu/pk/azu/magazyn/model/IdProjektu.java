package pl.edu.pk.azu.magazyn.model;

public enum IdProjektu {
    KOLO(1),
    SILNIK(2),
    KAROSERIA(3),
    PILOT(4),
    AUTO(5);

    private int id;

    IdProjektu(int id) {
        this.id = id;
    }

    public static IdProjektu fromInt(int val) {
        for (IdProjektu idProjektu : values()) {
            if (idProjektu.getId() == val) {
                return idProjektu;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }
}
