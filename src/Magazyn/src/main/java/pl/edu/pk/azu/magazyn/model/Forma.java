package pl.edu.pk.azu.magazyn.model;

public class Forma {

    private  IdProjektu typ;

    public Forma() {
    }

    public Forma(IdProjektu typ) {
        this.typ = typ;
    }

    public IdProjektu getTyp() {
        return typ;
    }

    public void setTyp(IdProjektu typ) {
        this.typ = typ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forma forma = (Forma) o;

        return typ == forma.typ;

    }

    @Override
    public int hashCode() {
        return typ != null ? typ.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Forma{" +
                "typ=" + typ +
                '}';
    }
}
