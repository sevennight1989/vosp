package ll.opensource.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import ll.opensource.R;

/**
 * Created by ZhangPeng on 9-22-0022.
 */

@SuppressLint("AppCompatCustomView")
//自定义TextView显示任意边框
public class BorderTextView extends TextView {

    private boolean leftBorder;
    private boolean topBorder;
    private boolean rightBorder;
    private boolean bottomBorder;

    public BorderTextView(Context context) {
        this(context, null);
    }

    public BorderTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BorderTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.view_border, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.view_border_left_border:
                    leftBorder = a.getBoolean(attr, false);
                    break;
                case R.styleable.view_border_top_border:
                    topBorder = a.getBoolean(attr, false);
                    break;
                case R.styleable.view_border_right_border:
                    rightBorder = a.getBoolean(attr, false);
                    break;
                case R.styleable.view_border_bottom_border:
                    bottomBorder = a.getBoolean(attr, false);
                    break;

            }
        }
        a.recycle();
    }

    private int sroke_width = 1;

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        //  将边框设为黑色
        paint.setColor(android.graphics.Color.BLACK);
        //  画TextView的4个边
        //上边
        if (topBorder) {
            canvas.drawLine(0, 0, this.getWidth() - sroke_width, 0, paint);
        }
        //左边
        if (leftBorder) {
            canvas.drawLine(0, 0, 0, this.getHeight() - sroke_width, paint);
        }
        //右边
        if (rightBorder) {
            canvas.drawLine(this.getWidth() - sroke_width, 0, this.getWidth() - sroke_width, this.getHeight() - sroke_width, paint);
        }
        //下边
        if (bottomBorder) {
            canvas.drawLine(0, this.getHeight() - sroke_width, this.getWidth() - sroke_width, this.getHeight() - sroke_width, paint);
        }
        super.onDraw(canvas);
    }
}
