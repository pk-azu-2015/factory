package pl.edu.pk.azu.magazyn.persistance;


public class RepositoryFactory {

    private static FormaRepository formaRepository = null;
    private static ProjektRepository projektRepository = null;
    private static SurowiecRepository surowiecRepository = null;


    public static FormaRepository newInstanceFormRepository() {
        if(formaRepository == null) {
//           formaRepository = new FormaRepositoryDBImpl();
            formaRepository = new FormaRepositoryFileImpl();
        }
        return formaRepository;
    }


    public static ProjektRepository newInstanceProjektRepository() {
        if (projektRepository == null) {
//            projektRepository = new ProjektRepositoryDBImpl();
            projektRepository = new ProjektRepositoryFileImpl();
        }
        return projektRepository;
    }

    public static SurowiecRepository newInstanceSurowiecRepository() {
        if(surowiecRepository == null) {
//            surowiecRepository = new SurowiecRepositoryDBImpl();
            surowiecRepository = new SurowiecRepositoryFileImpl();
        }
        return surowiecRepository;
    }

}
