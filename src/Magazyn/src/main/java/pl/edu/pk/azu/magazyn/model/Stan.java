package pl.edu.pk.azu.magazyn.model;

import java.util.Arrays;

public enum Stan {
    ODLANY(0),
    OSZLIFOWANY(1),
    POMALOWANY(2),
    DO_KONTROLI(3),
    GOTOWY(4),
    ZEPSUTY(5),
    DO_RECYKLINGU(6);

    private int id;
    private static int maxId;

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

    public static int getMaxId() {
        Stan[] values = values();
        Arrays.sort(values, new IdComparator());
        int maxId = values[0].getId();

        return maxId;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Stan{" +
                id + " : " + name() +
                '}';
    }

    private static class IdComparator implements java.util.Comparator<Stan> {
        @Override
        public int compare(Stan o1, Stan o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    }
}
