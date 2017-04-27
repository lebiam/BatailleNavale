package fr.wcs.bataillenavale;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by apprenti on 27/04/17.
 *
 * _________
 * |       |
 * | top   |
 * | Case  |
 * |_______|_____________________________________
 * |                                             |
 * |   leftCase   |    centerCase  |  rightCase  |
 * |_____________________________________________|
 */

public class FourCasesShipClass {
    private int mXLeftCase;
    private int mYLeftCase;

    private int mXCenterCase;
    private int mYCenterCase;

    private int mXRightCase;
    private int mYRightCase;

    private int mXTopCase;
    private int mYTopcase;

    int durability = 4;




    public FourCasesShipClass(int XLeftCase, int YLeftCase) {
        mXLeftCase = XLeftCase;
        mYLeftCase = YLeftCase;

        mXCenterCase = XLeftCase + 1;
        mYCenterCase = YLeftCase;

        mXRightCase = XLeftCase + 2;
        mYRightCase = YLeftCase;

        mXTopCase = XLeftCase;
        mYTopcase = YLeftCase + 1;

    }

    public int getXLeftCase() {
        return mXLeftCase;
    }

    public void setXLeftCase(int mXLeftCase) {
        this.mXLeftCase = mXLeftCase;
    }

    public int getYLeftCase() {
        return mYLeftCase;
    }

    public void setYLeftCase(int mYLeftCase) {
        this.mYLeftCase = mYLeftCase;
    }

    public int getXCenterCase() {
        return mXCenterCase;
    }

    public void setXCenterCase(int mXCenterCase) {
        this.mXCenterCase = mXCenterCase;
    }

    public int getYCenterCase() {
        return mYCenterCase;
    }

    public void setYCenterCase(int mYCenterCase) {
        this.mYCenterCase = mYCenterCase;
    }

    public int getXRightCase() {
        return mXRightCase;
    }

    public void setXRightCase(int mXRightCase) {
        this.mXRightCase = mXRightCase;
    }

    public int getYRightCase() {
        return mYRightCase;
    }

    public void setYRightCase(int mYRightCase) {
        this.mYRightCase = mYRightCase;
    }

    public int getXTopCase() {
        return mXTopCase;
    }

    public void setXTopCase(int mXTopCase) {
        this.mXTopCase = mXTopCase;
    }

    public int getYTopcase() {
        return mYTopcase;
    }

    public void setYTopcase(int mYTopcase) {
        this.mYTopcase = mYTopcase;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void hit(Context context){
        durability--;
        Toast.makeText(context, "Touché !", Toast.LENGTH_LONG).show();
    }
    public void isDestroy(Context context){
        Toast.makeText(context, "Coulé !", Toast.LENGTH_LONG).show();
    }
}
