package fr.wcs.bataillenavale;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by apprenti on 28/04/17.
 */

public class GridGamePlayerOne extends View {


    private int numColumns, numRows;
    private int cellWidth, cellHeight;
    private Paint blackPaint = new Paint();
    private boolean[][] cellChecked;
    private boolean [][] tabPlayerTwo;
    public static Boolean HASSHOOT = false;
    private int playerTwoLife = 17;


    public GridGamePlayerOne(Context context) {
        this(context, null);
    }



    public GridGamePlayerOne(Context context, AttributeSet attrs) {
        super(context, attrs);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void setTabPlayerTwo(boolean[][] tabPlayerTwo) {
        this.tabPlayerTwo = tabPlayerTwo;
    }


    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
        calculateDimensions();
    }


    public int getNumColumns() {
        return numColumns;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
        calculateDimensions();
    }

    public int getNumRows() {
        return numRows;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions() {
        if (numColumns < 1 || numRows < 1) {
            return;
        }

        cellWidth = getWidth() / numColumns;
        cellHeight = getHeight() / numRows;

        cellChecked = new boolean[numColumns][numRows];



        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        if (numColumns == 0 || numRows == 0) {
            return;
        }

        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                if (cellChecked[i][j]) {

                    canvas.drawRect(i * cellWidth, j * cellHeight,
                            (i + 1) * cellWidth, (j + 1) * cellHeight,
                            blackPaint);
                }
            }
        }

        for (int i = 1; i < numColumns; i++) {
            canvas.drawLine(i * cellWidth, 0, i * cellWidth, height, blackPaint);
        }

        for (int i = 1; i < numRows; i++) {
            canvas.drawLine(0, i * cellHeight, width, i * cellHeight, blackPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if (HASSHOOT == false) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int column = (int) (event.getX() / cellWidth);
                int row = (int) (event.getY() / cellHeight);
                if (tabPlayerTwo[column][row]) {
                    if (cellChecked[column][row] = !cellChecked[column][row]) {
                        cellChecked[column][row] = !cellChecked[column][row];
                    }
                    cellChecked[column][row] = !cellChecked[column][row];
                    playerTwoLife--;
                    invalidate();
                }
                HASSHOOT = true;


            }

            return true;
        }
        return true;
    }




}
