package net.tianzx.gobang;

import android.widget.Toast;

/**
 * Created by tianzx on 2016/3/16.
 */
public class ChessBoard {

    //chessboard number
    public final static int CHESS_NUM = 15;
    //cross position
    public static PointModel[][] crossPoints = new PointModel[CHESS_NUM][CHESS_NUM];

    private int cellWidth = 0;
    private int cellHeight = 0;

    public void initCrossPoints(int width, int height, GobangActivity ctx) {

        //1:according to offset,find left top position
        int offsetX = 21;
        int offsetY = 20;
        int chessNum = ChessBoard.CHESS_NUM;
        //2:according to calc,get a cell width and height
        cellWidth = (width - 2 * offsetX) / (chessNum - 1);
        cellHeight = (height - 2 * offsetY) / (chessNum - 1)-21;

        //3:loop calc each cross position,and set value to crosspoints
        for (int i = 0; i < chessNum; i++) {
            for (int j = 0; j < chessNum; j++) {
                PointModel pm = new PointModel();
                pm.setX(offsetX + i * cellWidth);
                int t= j/6>0?j/3:0;
                pm.setY(offsetY + j * cellHeight - j / 3);
//                Chess.drawChess(pm.getX(), pm.getY(), PointModel.BLACK, ctx);
                crossPoints[i][j] = pm;
            }
        }
    }

    /**
     * according to position,select around position
     * @param x
     * @param y
     * @param ctx
     * @return
     */
    public PointModel getNearCanUsePoint(int x,int y, GobangActivity ctx) {
        PointModel retPm = new PointModel();
        //1:get rang of crosspoints
        int lowX = x -this.cellWidth;
        int highX = x +this.cellWidth;
        int lowY = y-this.cellHeight;
        int highY = y + this.cellHeight;
        //2:judge never used and nearest position
        double lowValue = 0;
        PointModel pm = new PointModel();
        for(int i=0;i<CHESS_NUM;i++) {
            for(int j=0;j<CHESS_NUM;j++) {
                pm = crossPoints[i][j];

                //judge in range
                if(pm.getX()>=lowX&&pm.getX()<=highX&&pm.getY()>=lowX&&pm.getY()<=highY) {
                    double temp = Math.pow(x-pm.getX(),2)+Math.pow(y-pm.getY(),2);
                    if(temp<lowValue||lowValue==0) {
                        //judge is in use
                        if(!pm.isInUse()) {
                            lowValue = temp;
                            retPm.setX(pm.getY());
                            retPm.setX(pm.getX());
                            Business.Instance.useX = i;
                            Business.Instance.useY = j;
                        }else{

                        }

                    }
                }
            }
        }
        if(retPm.getX()==0||retPm.getY()==0){
            Toast.makeText(ctx,"对不起，请不要瞎点",Toast.LENGTH_LONG);
            return null;
        }
        //set chess on chessboard in use
        crossPoints[Business.Instance.useX][Business.Instance.useY].setInUse(true);
        retPm.setInUse(true);
        //set position color
        if(Business.Instance.steps%2 ==0){
            crossPoints[Business.Instance.useX][Business.Instance.useY].setBlackOrWhite(PointModel.WHITE);
            retPm.setBlackOrWhite(PointModel.WHITE);
        }else{
            crossPoints[Business.Instance.useX][Business.Instance.useY].setBlackOrWhite(PointModel.BLACK);
            retPm.setBlackOrWhite(PointModel.BLACK);
        }
        return retPm;
    }
}
