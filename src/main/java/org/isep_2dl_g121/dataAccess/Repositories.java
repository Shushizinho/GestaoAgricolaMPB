package org.isep_2dl_g121.dataAccess;

public class Repositories {

    private static final Repositories instance = new Repositories();
    private CulturaRepository culturaRepository = null;

    private OperacaoAgricolaRepository operacaoAgricolaRepository = null;

    private Repositories() {
        operacaoAgricolaRepository = new OperacaoAgricolaRepository();
        culturaRepository = new CulturaRepository();
    }

    public static Repositories getInstance() {
        return instance;
    }

    public OperacaoAgricolaRepository getOperacaoAgricolaRepository() {
        return operacaoAgricolaRepository;
    }

    public CulturaRepository getCulturaRepository() { return culturaRepository;    }


}
