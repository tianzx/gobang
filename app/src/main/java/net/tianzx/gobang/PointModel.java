package net.tianzx.gobang;

/**
 * Created by tianzx on 2016/3/18.
 */
public class PointModel {

    public static final int BLACK = 1;
    public static final int WHITE = 2;
    private int x=0;
    private int y=0;

    //judge if has chess
    private boolean inUse = false;

    //descripe chess color
    private int blackOrWhite = 0;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    @Override
    public String toString() {
        return "PointModel{" +
                "x=" + x +
                ", y=" + y +
                ", inUse=" + inUse +
                ", blackOrWhite=" + blackOrWhite +
                '}';
    }

    public int getBlackOrWhite() {
        return blackOrWhite;
    }

    public void setBlackOrWhite(int blackOrWhite) {
        this.blackOrWhite = blackOrWhite;
    }
}
