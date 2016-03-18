package net.tianzx.gobang;

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
                pm.setY(offsetY + j * cellHeight-j/3);
                Chess.drawChess(pm.getX(), pm.getY(), PointModel.BLACK, ctx);
                crossPoints[i][j] = pm;
            }
        }
    }
}
