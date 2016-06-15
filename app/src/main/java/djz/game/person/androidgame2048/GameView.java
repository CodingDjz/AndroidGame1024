package djz.game.person.androidgame2048;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

/**
 * Created by Djz on 2016/6/15.
 */
public class GameView extends GridLayout {


    public GameView(Context context) {
        super(context);
        initGameView();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGameView();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initGameView();
    }

    /*
        初始化构造方法
         */
    private void initGameView() {
        setOnTouchListener(new View.OnTouchListener() {
                               private float startX, startY, offsetX, offsetY;
                               @Override
                               public boolean onTouch(View v, MotionEvent event) {
                                   //通过手指按下和手指离开判断意图！ 两点位置
                                   switch (event.getAction()) {
                                       case MotionEvent.ACTION_DOWN:
                                           startX = event.getX();
                                           startY = event.getY();
                                           break;
                                       case MotionEvent.ACTION_UP:
                                           offsetX = event.getX() - startX;
                                           offsetY = event.getY() - startY;
                                           //斜着滑判断哪个绝对值大
                                           if (Math.abs(offsetX) > Math.abs(offsetY)) {
                                               if (offsetX < -5) {
                                                   Log.d("GameView","left");
                                               } else if (offsetX > 5) {
                                                   System.out.printf("right");
                                               }
                                           } else {
                                               if (offsetY < -5) {
                                                   System.out.printf("up");
                                               } else if (offsetY > 5) {
                                                   System.out.printf("down");
                                               }
                                           }
                                           break;
                                   }

                                   //返回true，处理事件，不用再传递。
                                   //MOVE和UP有反应
                                   return true;
                               }
                           }

        );
    }
}
