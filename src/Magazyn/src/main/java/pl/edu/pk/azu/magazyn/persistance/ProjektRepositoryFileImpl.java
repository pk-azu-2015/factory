package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Projekt;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class ProjektRepositoryFileImpl implements ProjektRepository {
    private HashMap<Projekt, AtomicInteger> projektyCounter;

    private static ProjektRepositoryFileImpl instance;

    public static ProjektRepositoryFileImpl getInstance() {
        if (instance == null) {
            instance = new ProjektRepositoryFileImpl();
        }
        return instance;
    }

    private ProjektRepositoryFileImpl() {
        projektyCounter = new HashMap<>();
    }


    @Override
    public void wezProjekt(Projekt projekt) throws NoItemFound {
        AtomicInteger counter = projektyCounter.get(projekt);
        if (counterExists(counter)) {
            int projectCounterAfterDecrementation = takeProject(counter);
            if (lessThanZero(projectCounterAfterDecrementation)) {
                throw new NoItemFound(projekt.toString());
            }
        } else {
            throw new NoItemFound(projekt.toString());
        }
    }

    @Override
    public void dodajProjekt(Projekt projekt) {
        AtomicInteger counter = projektyCounter.get(projekt);
        if (!counterExists(counter)) {
            counter = new AtomicInteger();
            projektyCounter.put(projekt, counter);
        }

        counter.incrementAndGet();
    }

    private boolean counterExists(AtomicInteger counter) {
        return counter != null;
    }

    private int takeProject(AtomicInteger counter) {
        return counter.decrementAndGet();
    }

    private boolean lessThanZero(int projectCounterAfterDecrementation) {
        return projectCounterAfterDecrementation < 0;
    }
}
