package org.isep_2dl_g121;

import java.util.Objects;

public class PairCoord extends Pair<Double,Double> {
    private double left;
    private double right;

    /**
     * Instantiates a new Pair.
     *
     * @param left  the left
     * @param right the right
     */
    public PairCoord(double left, double right){
        this.left = left;
        this.right = right;
    }


    /**
     * Gets left.
     *
     * @return the left
     */
    public Double getLeft() {
        return left;
    }

    /**
     * Sets left.
     *
     * @param left the left
     */
    public void setLeft(double left) {
        this.left = left;
    }

    /**
     * Gets right.
     *
     * @return the right
     */
    public Double getRight() {
        return right;
    }

    /**
     * Sets right.
     *
     * @param right the right
     */
    public void setRight(double right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return left + ":" + right;
    }

    @Override
    public PairCoord clone() {
        return new PairCoord(this.left, this.right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PairCoord pair)) return false;
        return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}
