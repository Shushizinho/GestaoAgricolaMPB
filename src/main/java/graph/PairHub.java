package graph;

public class PairHub<T, T1> {

    private String T;
    private Boolean T1;

    public PairHub(String t, Boolean t1) {
        T = t;
        T1 = t1;
    }

    public String getT() {
        return T;
    }

    public Boolean getT1() {
        return T1;
    }

    @Override
    public String toString() {
        String s = " Localidade: " + T;
        if (T1) s += " Hub ";
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PairHub that = (PairHub) obj;
        return T1 == that.T1 && T.equals(that.T);
    }
}
