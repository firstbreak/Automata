package com.example.android.automata;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class Node {

    public static class MyView extends View implements Serializable
    {
        Paint paint = null;
        int x, y;
        int size, noofstates, nooftransitions;
        String states[] = {"q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9"};
        ArrayList<String> initialStates = new ArrayList<>(), symbols = new ArrayList<>(), finalStates = new ArrayList<>();        Boolean [] isPresent = {false, false, false, false, false, false, false, false, false, false};

        public MyView(Context context, Bundle bundle)
        {
            super(context);
            paint = new Paint();
            size = bundle.getInt(ConstantsClass.Size);
            noofstates = bundle.getInt(ConstantsClass.NofStates);
            initialStates = bundle.getStringArrayList(ConstantsClass.InitialStates);
            symbols = bundle.getStringArrayList(ConstantsClass.Symbols);
            finalStates = bundle.getStringArrayList(ConstantsClass.FinalStates);
            nooftransitions = initialStates.size();
            for (int i=0;i<initialStates.size();++i){
                for (int j=0;j<10;++j){
                    if (states[j].equals(initialStates.get(i))){
                        isPresent[j] = true;
                    }
                }
            }
            for (int i=0;i<finalStates.size();++i){
                for (int j=0;j<10;++j){
                    if (states[j].equals(finalStates.get(i))){
                        isPresent[j] = true;
                    }
                }
            }


        }


        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            int radius;
            radius = 50;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            paint.setFlags(Paint.ANTI_ALIAS_FLAG);
            canvas.drawPaint(paint);
            // Use Color.parseColor to define HTML colors
            paint.setColor(Color.parseColor("#CD5C5C"));

             x = getWidth();
             y = getHeight();

//            canvas.drawCircle(x / 2, y / 2, radius, paint);
            int unitx = x/11, unity = y/4;
            int xcoor[] = {2*unitx, 4*unitx, 6*unitx, 8*unitx, unitx, 10*unitx, 3*unitx, 5*unitx, 7*unitx, 9*unitx};
            int ycoor[] = {unity, unity, unity, unity, 2*unity, 2*unity, 3*unity, 3*unity, 3*unity, 3*unity};

            for (int i=0;i<10;++i){
                if (isPresent[i]){
                    paint.setColor(Color.parseColor("#CD5C5C"));
                    canvas.drawCircle(xcoor[i],ycoor[i],radius,paint);
                    paint.setColor(Color.BLACK);
                    paint.setTextSize(50);
                    canvas.drawText(states[i],xcoor[i]-radius/2,ycoor[i]-3*radius/2,paint);
                }
            }
        }
    }


}
