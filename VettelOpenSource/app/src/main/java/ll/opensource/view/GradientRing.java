package ll.opensource.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import ll.opensource.R;

//颜色渐变ProgressBar,中间的图标可以自定义，用于加载自定义进度条
public class GradientRing
        extends View {
    private int animation_progress = 1;
    private int circle_progress = 0;
    private Bitmap mBp;
    private Context mContext;
    private int mHeight;
    private Paint mPaint;
    private int mRingWidth = 10;
    private int mWidth;
    private int max_alpha = 255;
    private float max_degree = 360.0F;

    public GradientRing(Context paramContext) {
        this(paramContext, null);
    }

    public GradientRing(Context paramContext, @Nullable AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public GradientRing(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        mContext = paramContext;
    }

    private Bitmap getBitmap() {
        Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        float f2 = mWidth;
        float f1 = mHeight;
        f2 = f2 * 0.6F / i;
        f1 = f1 * 0.6F / j;
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(f2, f1);
        return Bitmap.createBitmap(localBitmap, 0, 0, i, j, localMatrix, true);
    }

    private void resetPaint(int paramInt) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(20.0F);
        mPaint.setAlpha(paramInt);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        paramCanvas.drawBitmap(mBp, mWidth * 0.2F, mHeight * 0.2F, mPaint);
        if (animation_progress > 360) {
            animation_progress /= 360;
        }
        resetPaint(255);
        RectF localRectF = new RectF(mRingWidth, mRingWidth, mWidth - mRingWidth, mHeight - mRingWidth);
        for (circle_progress = 0; circle_progress < 360; circle_progress += 3) {
            resetPaint((int) (circle_progress / max_degree * max_alpha));
            paramCanvas.drawArc(localRectF, circle_progress + animation_progress, 3.0F, false, mPaint);
        }
        animation_progress += 8;
        invalidate();
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        mWidth = getWidth();
        mHeight = getHeight();
        mBp = getBitmap();
    }
}
