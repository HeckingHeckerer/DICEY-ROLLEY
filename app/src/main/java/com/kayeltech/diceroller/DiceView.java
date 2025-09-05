package com.kayeltech.diceroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class DiceView extends View {
    private int diceValue = 1;
    private final Paint paintSquare;
    private final Paint paintDot;
    private final Random random = new Random();

    public DiceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paintSquare = new Paint();
        paintSquare.setColor(0xFFFFFFFF); // White square

        paintDot = new Paint();
        paintDot.setColor(0xFF000000); // Black dots
        paintDot.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        // size of dice square (keep it centered)
        int size = Math.min(width, height) - 50;
        int left = (width - size) / 2;
        int top = (height - size) / 2;

        // draw dice square
        RectF rect = new RectF(left, top, left + size, top + size);
        canvas.drawRect(rect, paintSquare);

        // draw dots
        float dotRadius = size / 12f;
        float cx = left + size / 2f;
        float cy = top + size / 2f;

        float offset = size / 4f;

        switch (diceValue) {
            case 1:
                drawDot(canvas, cx, cy, dotRadius);
                break;
            case 2:
                drawDot(canvas, cx - offset, cy - offset, dotRadius);
                drawDot(canvas, cx + offset, cy + offset, dotRadius);
                break;
            case 3:
                drawDot(canvas, cx, cy, dotRadius);
                drawDot(canvas, cx - offset, cy - offset, dotRadius);
                drawDot(canvas, cx + offset, cy + offset, dotRadius);
                break;
            case 4:
                drawDot(canvas, cx - offset, cy - offset, dotRadius);
                drawDot(canvas, cx + offset, cy - offset, dotRadius);
                drawDot(canvas, cx - offset, cy + offset, dotRadius);
                drawDot(canvas, cx + offset, cy + offset, dotRadius);
                break;
            case 5:
                drawDot(canvas, cx, cy, dotRadius);
                drawDot(canvas, cx - offset, cy - offset, dotRadius);
                drawDot(canvas, cx + offset, cy - offset, dotRadius);
                drawDot(canvas, cx - offset, cy + offset, dotRadius);
                drawDot(canvas, cx + offset, cy + offset, dotRadius);
                break;
            case 6:
                drawDot(canvas, cx - offset, cy - offset, dotRadius);
                drawDot(canvas, cx + offset, cy - offset, dotRadius);
                drawDot(canvas, cx - offset, cy, dotRadius);
                drawDot(canvas, cx + offset, cy, dotRadius);
                drawDot(canvas, cx - offset, cy + offset, dotRadius);
                drawDot(canvas, cx + offset, cy + offset, dotRadius);
                break;
        }
    }

    private void drawDot(Canvas canvas, float x, float y, float radius) {
        canvas.drawCircle(x, y, radius, paintDot);
    }

    public void rollDice() {
        diceValue = random.nextInt(6) + 1; // 1–6
        invalidate(); // redraw
    }
}
