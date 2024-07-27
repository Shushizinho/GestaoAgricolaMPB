package org.isep_2dl_g121;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PairTime extends Pair<Integer,Integer> {
    private Integer left;
    private Integer right;

    /**
     * Instantiates a new Pair.
     *
     * @param left  the left
     * @param right the right
     */
    public PairTime(Integer left, Integer right){
        this.left = left;
        this.right = right;
    }

    public PairTime() {
        LocalDateTime now = LocalDateTime.now();
        this.left = now.getHour();
        this.right = now.getMinute();
    }
    public PairTime(LocalDateTime time){
        this.left = time.getHour();
        this.right = time.getMinute();
    }


    /**
     * Gets left.
     *
     * @return the left
     */
    public Integer getLeft() {
        return left;
    }

    /**
     * Sets left.
     *
     * @param left the left
     */
    public void setLeft(Integer left) {
        this.left = left;
    }

    /**
     * Gets right.
     *
     * @return the right
     */
    public Integer getRight() {
        return right;
    }

    /**
     * Sets right.
     *
     * @param right the right
     */
    public void setRight(Integer right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("%02d",left) + ":" + String.format("%02d",right);
    }

    @Override
    public PairTime clone() {
        return new PairTime(this.left, this.right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PairTime pair)) return false;
        return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    public void incrementar(int minutos) {

//        this.right += minutos;
//        if(this.right>=60){
//            this.right -=60;
//            this.left += 1;
//        }
        this.left = (this.left +(this.right+minutos)/60)%24;
        this.right = (this.right+minutos)%60;

    }
    public Integer getInMinutes(){
        return left*60+right;
    }

    public Integer compareTime(PairTime c) {
        return this.getInMinutes()-c.getInMinutes();
    }
}
