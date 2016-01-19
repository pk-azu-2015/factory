package pl.edu.pk.azu.magazyn.persistance;

import java.util.concurrent.atomic.AtomicInteger;

public class SurowiecRepositoryFileImpl implements SurowiecRepository {
    private AtomicInteger atomicInteger;


    public SurowiecRepositoryFileImpl() {
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

    @Override
    public int aktualnyStan() {
        return atomicInteger.get();
    }

}
