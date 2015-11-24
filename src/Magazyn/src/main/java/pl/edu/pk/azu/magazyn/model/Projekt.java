package pl.edu.pk.azu.magazyn.model;

public class Projekt {
    private IdProjektu typ;
    private Stan stan;

    public Projekt() {
    }

    public Projekt(IdProjektu typ, Stan stan) {
        this.typ = typ;
        this.stan = stan;
    }

    public IdProjektu getTyp() {
        return typ;
    }

    public void setTyp(IdProjektu typ) {
        this.typ = typ;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Projekt projekt = (Projekt) o;

        if (typ != projekt.typ) return false;
        return stan == projekt.stan;

    }

    @Override
    public int hashCode() {
        int result = typ.ordinal()*10;
        result += stan.ordinal();
        return result;
    }

    @Override
    public String toString() {
        return "Projekt{" +
                "typ=" + typ +
                ", stan=" + stan +
                '}';
    }
}

