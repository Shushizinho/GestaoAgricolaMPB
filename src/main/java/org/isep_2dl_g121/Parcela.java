package org.isep_2dl_g121;

import java.util.List;
import java.util.Objects;


/**
 * The type Charger.
 */
public class Parcela {
    private final String parcela;
    private final int minutos;
    private final PairTime horaInicial;
    private final PairTime horaFinal;



    public Parcela(String parcela, int minutos, PairTime horaInicial, PairTime horaFinal) {
        this.parcela = parcela;
        this.minutos = minutos;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    @Override
    public String toString() {
        return parcela + "," + minutos + "," + horaInicial + "," + horaFinal;
    }

    public String getParcela() {
        return parcela;
    }

    public int getMinutos() {
        return minutos;
    }

    public PairTime getHoraInicial() {
        return horaInicial;
    }

    public PairTime getHoraFinal() {
        return horaFinal;
    }


}
