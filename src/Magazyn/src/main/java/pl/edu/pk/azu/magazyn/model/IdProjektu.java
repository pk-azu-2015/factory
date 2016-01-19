package pl.edu.pk.azu.magazyn.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public enum IdProjektu {
    KOLO(0),
    SILNIK(1),
    KAROSERIA(2),
    PILOT(3),
    AUTO(4);

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

    public static int getMaxId() {

        IdProjektu[] values = values();
        Arrays.sort(values, new IdComparator());
        int maxId = values[0].getId();

        return maxId;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "IdProjektu{" +
                id + " : " + name() +
                '}';
    }

    private static class IdComparator implements Comparator<IdProjektu> {
        @Override
        public int compare(IdProjektu o1, IdProjektu o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    }

}
