package com.havefun.xdx.customview.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.havefun.xdx.customview.R;

public class DrawViewOne extends View {

    Paint paint = new Paint();

    public DrawViewOne(Context context) {
        super(context);
    }

    public DrawViewOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawViewOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStrokeWidth(12);
        paint.setAntiAlias(true);
        canvas.drawColor(Color.parseColor("#60BDE2")); // 设置画布颜色
        canvas.drawCircle(200,200,100,paint);
    }
}
