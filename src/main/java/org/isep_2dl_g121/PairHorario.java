package org.isep_2dl_g121;

import java.util.Objects;

public class PairHorario extends Pair<PairTime,PairTime> {
    private PairTime left;
    private PairTime right;

    public PairHorario(PairTime left, PairTime right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Abertura= " + left.getLeft() + ":" + left.getRight() +
                ", Fecho= " + right.getLeft() + ":" + right.getRight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    public boolean periodContains(PairTime c) {
        return (left.compareTime(c)<0 && right.compareTime(c)>0);
    }
}
