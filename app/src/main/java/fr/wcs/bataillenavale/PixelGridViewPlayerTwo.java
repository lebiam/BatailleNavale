package fr.wcs.bataillenavale;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by apprenti on 28/04/17.
 */

public class PixelGridViewPlayerTwo extends View {
    private int numColumns, numRows;
    private int cellWidth, cellHeight;
    private Paint blackPaint = new Paint();
    private boolean[][] cellChecked;
    boolean[][] mShipTabPlayerTwo = new boolean[10][10];


    private static int CONSTANT_SHIP_FOUR = 0;
    private static int CONSTANT_SHIP_THREE = 1;
    private static int CONSTANT_SHIP_THREE_PRIME = 2;
    private static int CONSTANT_SHIP_TWO = 3;
    private static int CONSTANT_SHIP_FIVE = 4;
    private int step = 0;


    public PixelGridViewPlayerTwo(Context context) {
        this(context, null);
    }

    public PixelGridViewPlayerTwo(Context context, AttributeSet attrs) {
        super(context, attrs);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public boolean[][] getShipTabPlayerTwo() {
        return mShipTabPlayerTwo;
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


        if (step == CONSTANT_SHIP_FOUR) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int column = (int) (event.getX() / cellWidth);
                int row = (int) (event.getY() / cellHeight);

                if (column >= 8 || row < 1) {

                    return false;

                } else {
                    mShipTabPlayerTwo[column][row] = true;
                    mShipTabPlayerTwo[column + 1][row] = true;
                    mShipTabPlayerTwo[column + 2][row] = true;
                    mShipTabPlayerTwo[column][row - 1] = true;
                    cellChecked[column][row] = !cellChecked[column][row];
                    cellChecked[column + 1][row] = !cellChecked[column + 1][row];
                    cellChecked[column + 2][row] = !cellChecked[column + 2][row];
                    cellChecked[column][row - 1] = !cellChecked[column][row - 1];
                    step++;
                    invalidate();
                }

            }
            return true;
        }

        if (step == CONSTANT_SHIP_THREE) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int column = (int) (event.getX() / cellWidth);
                int row = (int) (event.getY() / cellHeight);

                if (column >= 8 || mShipTabPlayerTwo[column][row] || mShipTabPlayerTwo[column + 1][row] || mShipTabPlayerTwo[column + 2][row]) {

                    return false;

                } else {
                    mShipTabPlayerTwo[column][row] = true;
                    mShipTabPlayerTwo[column + 1][row] = true;
                    mShipTabPlayerTwo[column + 2][row] = true;
                    cellChecked[column][row] = !cellChecked[column][row];
                    cellChecked[column + 1][row] = !cellChecked[column + 1][row];
                    cellChecked[column + 2][row] = !cellChecked[column + 2][row];
                    step++;
                    invalidate();
                }

            }
            return true;
        }
        if (step == CONSTANT_SHIP_THREE_PRIME) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int column = (int) (event.getX() / cellWidth);
                int row = (int) (event.getY() / cellHeight);

                if (column >= 8 || mShipTabPlayerTwo[column][row] || mShipTabPlayerTwo[column + 1][row] || mShipTabPlayerTwo[column + 2][row]) {

                    return false;

                } else {
                    mShipTabPlayerTwo[column][row] = true;
                    mShipTabPlayerTwo[column + 1][row] = true;
                    mShipTabPlayerTwo[column + 2][row] = true;
                    cellChecked[column][row] = !cellChecked[column][row];
                    cellChecked[column + 1][row] = !cellChecked[column + 1][row];
                    cellChecked[column + 2][row] = !cellChecked[column + 2][row];
                    step++;
                    invalidate();
                }

            }
            return true;
        }
        if (step == CONSTANT_SHIP_TWO) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int column = (int) (event.getX() / cellWidth);
                int row = (int) (event.getY() / cellHeight);

                if (column >= 9 || mShipTabPlayerTwo[column][row] || mShipTabPlayerTwo[column + 1][row]) {
                    return false;
                } else {
                    mShipTabPlayerTwo[column][row] = true;
                    mShipTabPlayerTwo[column + 1][row] = true;
                    cellChecked[column][row] = !cellChecked[column][row];
                    cellChecked[column + 1][row] = !cellChecked[column + 1][row];
                    step++;
                    invalidate();
                }

            }
            return true;
        }
        if (step == CONSTANT_SHIP_FIVE) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int column = (int) (event.getX() / cellWidth);
                int row = (int) (event.getY() / cellHeight);

                if (column >= 8 || row < 1 || mShipTabPlayerTwo[column][row] || mShipTabPlayerTwo[column + 1][row] || mShipTabPlayerTwo[column + 2][row] || mShipTabPlayerTwo[column + 2][row + 1] || mShipTabPlayerTwo[column][row - 1]) {
                    return false;
                } else {
                    mShipTabPlayerTwo[column][row] = true;
                    mShipTabPlayerTwo[column + 1][row] = true;
                    mShipTabPlayerTwo[column + 2][row] = true;
                    mShipTabPlayerTwo[column + 2][row + 1] = true;
                    mShipTabPlayerTwo[column][row - 1] = true;

                    cellChecked[column][row] = !cellChecked[column][row];
                    cellChecked[column + 1][row] = !cellChecked[column + 1][row];
                    cellChecked[column + 2][row] = !cellChecked[column + 2][row];
                    cellChecked[column + 2][row - 1] = !cellChecked[column + 2][row - 1];
                    cellChecked[column][row - 1] = !cellChecked[column][row - 1];
                    step++;
                    invalidate();
                }


            }
            return true;
        }

        return true;
    }
}

