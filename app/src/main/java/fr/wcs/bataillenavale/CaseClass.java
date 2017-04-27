package fr.wcs.bataillenavale;

/**
 * Created by apprenti on 27/04/17.
 */

public class CaseClass {

    private int mX;
    private int mY;

    public CaseClass (int x, int y){
        mX = x;
        mY = y;
    }

    public int getX() {
        return mX;
    }

    public void setX(int mX) {
        this.mX = mX;
    }

    public int getY() {
        return mY;
    }

    public void setY(int mY) {
        this.mY = mY;
    }
}
