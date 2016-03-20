package net.tianzx.gobang;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class GobangActivity extends AppCompatActivity {

    private ChessBoard board = new ChessBoard();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gobang);
        init();
    }

    private void init() {
        ImageView qp = (ImageView)this.findViewById(R.id.backgroundimg);
        qp.setOnTouchListener(new OnTouchQpExecute());
        //init this ele
        ImageButton reStart = (ImageButton)this.findViewById(R.id.btn_restart);
        reStart.setOnTouchListener(new MyButtonlistener());

        ImageButton resStep = (ImageButton)this.findViewById(R.id.btn_restep);
        resStep.setOnTouchListener(new MyButtonlistener());

        ImageButton exit = (ImageButton) this.findViewById(R.id.btn_exit);
        exit.setOnTouchListener(new MyButtonlistener());
        //init the chessboard
        board.initCrossPoints(this.getWindowManager().getDefaultDisplay().getWidth(), this.getWindowManager().getDefaultDisplay().getHeight(), this);
    }

    private class OnTouchQpExecute implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_UP) {

                //get position where can be draw
                PointModel nearPm = board.getNearCanUsePoint((int)event.getX(),(int)event.getY(),GobangActivity.this);
                //draw
                if(nearPm !=null) {
                    Business.Instance.steps++;
                    Chess.drawChess(nearPm.getX(),nearPm.getY(),Business.Instance.getNowBlackOrWhite(),GobangActivity.this);
                }
            }
            return true;
        }
    }
    /**
     *   implements listenr ,change the img gravity
     *
     */
    class MyButtonlistener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_DOWN) {
                ((ImageButton)v).getDrawable().setAlpha(150);
            }else{
                ((ImageButton)v).getDrawable().setAlpha(255);
            }
            v.invalidate();
            return true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(1, 1, 1, "set parameter ");
        menu.add(1, 2, 2, "save grades");
        menu.add(1, 3, 3, "grades rank");
        return true;
        // Inflate the menu; this adds items to the action bar if it is present.
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()){
            case 1:
                //param
                Toast.makeText(this, "tianzx", Toast.LENGTH_LONG).show();
                break;
            case 2:
                //save grades
                break;
            case 3:
                //grades rank
                break;
        }
        return true;
    }

}
