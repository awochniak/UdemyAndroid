package com.example.arkadiuszwochniak.udemyandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

class DrawView extends View implements View.OnTouchListener{

    // OnTouchListener - obsługa dotyku przy rysowaniu

    private Paint paint = new Paint();
    // Point point = new Point(); - problem z jednym punktem
    private  List<Point> points = new ArrayList<>();

    public DrawView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this); // ustawienie onTouch listenera na bieżącą metodą
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(Point point : points) {
            canvas.drawCircle(point.x, point.y, 30, paint); // rysuje tylko jeden punkt i za każdym razem w miejscu, należy przekazać listę punktów do listy

        }
        }

    // najważniejsza metoda w draw

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Point point = new Point();
        point.x = (int) event.getX(); // właściwości o ruchu użytkownika, informacja o współrzędnych palca
        point.y = (int) event.getY();
        points.add(point);
        invalidate();
        return true;
    }
}
