package fr.wcs.bataillenavale;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by apprenti on 27/04/17.
 *
 *
 * _______________________________________
 * |            |            |            |
 * |            |            |            |
 * | leftCase   | centerCase |rightCase   |
 * |            |            |            |
 * |____________|____________|____________|
 *
 */

public class ThreeCasesShipClass {
    private int mXLeftCase;
    private int mYLeftCase;

    private int mXCenterCase;
    private int mYCenterCase;

    private int mXRightCase;
    private int mYRightCase;

    int durability = 3;

    public ThreeCasesShipClass(int xLeftCase, int yLeftCase){
        mXLeftCase = xLeftCase;
        mYLeftCase = yLeftCase;

        mXCenterCase = xLeftCase + 1;
        mYCenterCase = yLeftCase;

        mXRightCase = xLeftCase + 2;
        mYRightCase = yLeftCase;
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
