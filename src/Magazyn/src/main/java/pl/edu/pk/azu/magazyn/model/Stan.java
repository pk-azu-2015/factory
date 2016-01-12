package pl.edu.pk.azu.magazyn.model;

public enum Stan {
    ODLANY(1),
    OSZLIFOWANY(2),
    POMALOWANY(3),
    DO_KONTROLI(4),
    GOTOWY(5),
    ZEPSUTY(6),
    DO_RECYKLINGU(7);

    private int id;

    Stan(int id) {
        this.id = id;
    }

    public static Stan fromInt(int val) {
        for (Stan stan : values()) {
            if (stan.getId() == val) {
                return stan;
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }
}
