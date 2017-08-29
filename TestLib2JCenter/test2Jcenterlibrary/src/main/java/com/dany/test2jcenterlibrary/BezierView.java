package com.dany.test2jcenterlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dan.y on 2017/8/28.
 */

public class BezierView extends View {
    private final static Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Point mControlPoint = new Point(200,200);

    public BezierView(Context context) {
        super(context);
    }

    public BezierView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);

        Path path = new Path();
        path.moveTo(100,500);
        path.quadTo(mControlPoint.x,mControlPoint.y,700,500);
        canvas.drawPath(path,mPaint);
        canvas.drawPoint(mControlPoint.x,mControlPoint.y,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                mControlPoint.x = (int) event.getX();
                mControlPoint.y = (int) event.getY();
                invalidate();
                break;
        }

        return true;
    }
}
