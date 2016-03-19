package net.tianzx.gobang;

/**
 * Created by tianzx on 2016/3/16.
 */
public enum Business {

    Instance;
    //record crossPoints position now
    public int useX = 0;
    public int useY = 0;

    //record current step
    public int steps = 0;

    public int getNowBlackOrWhite() {
        if(steps %2 ==0){
            return PointModel.WHITE;
        }else {
            return PointModel.BLACK;
        }
    };
}
