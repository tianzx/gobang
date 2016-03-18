package net.tianzx.gobang;

import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by tianzx on 2016/3/16.
 */
public class Chess {
    private static final int CHESS_WIDTH = 30;

    private static final int CHESS_HEIGHT = 30;

    /**
     * draw the chess itself
     * we ourselt dont konw  how to draw a chess ,so we need client offer our coordinate and color and Context
     * @param x
     * @param y
     * @param blackOrWhite
     * @param ctx
     * @return
     */
    public static ImageView drawChess(int x,int y,int blackOrWhite,GobangActivity ctx) {
        ImageView iv = new ImageView(ctx);
        //IV attr
        iv.setX(x-CHESS_WIDTH/2);
        iv.setY(y - CHESS_HEIGHT / 2);
        iv.setImageResource(blackOrWhite == PointModel.BLACK ? R.drawable.hei : R.drawable.bai);
        //set layout
        iv.setLayoutParams(new FrameLayout.LayoutParams(CHESS_WIDTH,CHESS_HEIGHT));
        //add Frame
        FrameLayout f = (FrameLayout) ctx.findViewById(R.id.mainlayout);

        f.addView(iv);
        return iv;
    }
}
