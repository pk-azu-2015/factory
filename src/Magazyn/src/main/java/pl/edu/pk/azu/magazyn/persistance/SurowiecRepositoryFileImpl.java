package pl.edu.pk.azu.magazyn.persistance;

import java.util.concurrent.atomic.AtomicInteger;

public class SurowiecRepositoryFileImpl implements SurowiecRepository {
    private AtomicInteger atomicInteger;

    private static SurowiecRepositoryFileImpl instance;

    public static SurowiecRepositoryFileImpl getInstance() {
        if(instance == null) {
            instance = new SurowiecRepositoryFileImpl();
        }
        return instance;
    }

    private SurowiecRepositoryFileImpl() {
        atomicInteger = new AtomicInteger();
    }

    @Override
    public void dodajSurowiec(int ilosc) {
        atomicInteger.addAndGet(ilosc);
    }

    @Override
    public void pobierzSurowiec(int ilosc) {
        for (int i = 0; i < ilosc; i++) {
            atomicInteger.decrementAndGet();
        }
    }

}
