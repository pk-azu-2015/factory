package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.exceptions.NoItemFoundExceptionBean;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;
import pl.edu.pk.azu.magazyn.utils.EnumUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
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
                throw new NoItemFound(projekt.toString(),new NoItemFoundExceptionBean(projekt.toString()));
            }
        } else {
            throw new NoItemFound(projekt.toString(),new NoItemFoundExceptionBean(projekt.toString()));
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

    @Override
    public List<Integer> zwrocProjektyOStanie(Stan stan) {
        List<Integer> projectIdList = new ArrayList<>();
        Set<Projekt> projekty = projektyCounter.keySet();
        for (Projekt projekt : projekty) {
            if(isProjektInSearchedStan(projekt, stan)) {
                addProjectToList(projekt, projectIdList);
            }
        }
        return projectIdList;
    }

    private void addProjectToList(Projekt projekt, final List<Integer> projectIdList) {
        int counter =  projektyCounter.get(projekt).intValue();
        for (int i = 0; i < counter; i++) {
            int idProjektAsInt = EnumUtils.idProjektuToInt(projekt.getTyp());
            projectIdList.add(new Integer(idProjektAsInt));
        }
    }

    private boolean isProjektInSearchedStan(Projekt projekt, Stan stan) {
        return projekt.getStan() == stan;
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
