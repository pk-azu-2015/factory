package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.exceptions.ItemUsed;
import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Forma;
import pl.edu.pk.azu.magazyn.model.IdProjektu;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class FormaRepositoryFileImpl implements FormaRepository {
    private static final int MAX_USAGE = 10;
    private HashMap<Forma,AtomicInteger> formaCounter;
    private HashMap<Forma,AtomicInteger> formaUsageCounter;

    public FormaRepositoryFileImpl() {
        formaCounter = new HashMap<>();
        formaUsageCounter = new HashMap<>();
    }

    @Override
    public void dodajForme(Forma forma) {
        AtomicInteger counter = formaCounter.get(forma);
        if(!isExist(counter)) {
            counter = addCounterToMap(forma);
        }
        counter.addAndGet(1);
    }

    private AtomicInteger addCounterToMap(Forma forma) {
        AtomicInteger counter = new AtomicInteger();
        formaCounter.put(forma, counter);
        addFormToUsageCounter(forma);
        return counter;
    }

    private void addFormToUsageCounter(Forma forma) {
        AtomicInteger usageCounter = formaUsageCounter.get(forma);
        if(usageCounter == null) {
            usageCounter = new AtomicInteger(0);
            formaUsageCounter.put(forma, usageCounter);
        }
    }
/*
    @Override
    public void wezForme(Forma forma) throws NoItemFound {
        AtomicInteger counterOfForm = formaCounter.get(forma);

        if(!isExist(counterOfForm)) {
            throw new NoItemFound(forma.toString() );
        }

        int amountOfFormsAfterDecrementation = takeForm(counterOfForm);
        if (lessThanZero(amountOfFormsAfterDecrementation)) {
            throw new NoItemFound(forma.toString());
        }
    }
*/
    @Override
    public void uzyjForme(Forma forma) throws NoItemFound, ItemUsed {
        AtomicInteger formaUsage = formaUsageCounter.get(forma);
//TODO: AM Przemyśleć jak resetować counter użyć
        if(isExist(formaUsage)) {
            if(isUsageOfFormLessThanMaxUsage(formaUsage)) {
                useForm(formaUsage);
            } else {
               throw new ItemUsed(forma.toString());
            }
        } else {
            throw new NoItemFound(forma.toString());
        }
    }

    @Override
    public int count(IdProjektu idProjektu) {
        return 0;
    }

    private boolean isExist(AtomicInteger formaUsage) {
        return formaUsage != null;
    }

    private boolean isUsageOfFormLessThanMaxUsage(AtomicInteger formaUsage) {
        return formaUsage.intValue() < MAX_USAGE;
    }

    private int useForm(AtomicInteger formaUsage) {
        return formaUsage.incrementAndGet();
    }

    private int takeForm(AtomicInteger counterOfForm) {
        return counterOfForm.decrementAndGet();
    }

    private boolean lessThanZero(int amountOfFormsAfterDecrementation) {
        return amountOfFormsAfterDecrementation < 0;
    }
}
