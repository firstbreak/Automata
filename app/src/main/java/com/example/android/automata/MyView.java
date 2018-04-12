package com.example.android.automata;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;

public class MyView extends View {

    private final Paint p;
    private final Path path;
    private final Point point1;
    private final Point point2;

    public MyView(Context context) {
        super(context);

        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStrokeWidth(10);
        path = new Path();

        point1 = new Point(200, 300);
        point2 = new Point(700, 800);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // draw first vertex
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.GREEN);
        canvas.drawCircle(point1.x, point1.y, 15, p);

        // draw the edge
        path.reset();
        path.moveTo(point1.x, point1.y);
        path.lineTo(point2.x, point2.y);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.CYAN);
        canvas.drawPath(path, p);

        // draw second vertex
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLUE);
        canvas.drawCircle(point2.x, point2.y, 15, p);
    }
}