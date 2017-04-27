package fr.wcs.bataillenavale;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by apprenti on 27/04/17.
 *
 * _______________                     ________________
 * |              |                   |               |
 * |              |                   |               |
 * | topLeftCase  |                   | topRightCase  |
 * |              |                   |               |
 * |______________|___________________|_______________|
 * |              |                   |               |
 * |              |                   |               |
 * |              |                   |               |
 * |  leftCase    |     centerCase    |  rightCase    |
 * |              |                   |               |
 * |              |                   |               |
 * |______________|___________________|_______________|
 *
 */

public class FiveCasesShipClass {
    private int mXLeftCase;
    private int mYLeftCase;

    private int mXCenterCase;
    private int mYCenterCase;

    private int mXRightCase;
    private int mYRightCase;

    private int mXTopLeftCase;
    private int mYTopLeftCase;

    private int mXTopRightCase;
    private int mYTopRightCase;

    int durability = 5;

    public FiveCasesShipClass(int xLeftCase, int yLeftCase){
        mXLeftCase = xLeftCase;
        mYLeftCase = yLeftCase;

        mXCenterCase = xLeftCase + 1;
        mYCenterCase = yLeftCase;

        mXRightCase = xLeftCase + 2;
        mYRightCase = yLeftCase;

        mXTopLeftCase = xLeftCase;
        mYTopLeftCase = yLeftCase + 1;

        mXTopRightCase = xLeftCase + 2;
        mYTopRightCase = yLeftCase + 1;
    }

    public int getmXLeftCase() {
        return mXLeftCase;
    }

    public void setmXLeftCase(int mXLeftCase) {
        this.mXLeftCase = mXLeftCase;
    }

    public int getmYLeftCase() {
        return mYLeftCase;
    }

    public void setmYLeftCase(int mYLeftCase) {
        this.mYLeftCase = mYLeftCase;
    }

    public int getmXCenterCase() {
        return mXCenterCase;
    }

    public void setmXCenterCase(int mXCenterCase) {
        this.mXCenterCase = mXCenterCase;
    }

    public int getmYCenterCase() {
        return mYCenterCase;
    }

    public void setmYCenterCase(int mYCenterCase) {
        this.mYCenterCase = mYCenterCase;
    }

    public int getmXRightCase() {
        return mXRightCase;
    }

    public void setmXRightCase(int mXRightCase) {
        this.mXRightCase = mXRightCase;
    }

    public int getmYRightCase() {
        return mYRightCase;
    }

    public void setmYRightCase(int mYRightCase) {
        this.mYRightCase = mYRightCase;
    }

    public int getmXTopLeftCase() {
        return mXTopLeftCase;
    }

    public void setmXTopLeftCase(int mXTopLeftCase) {
        this.mXTopLeftCase = mXTopLeftCase;
    }

    public int getmYTopLeftCase() {
        return mYTopLeftCase;
    }

    public void setmYTopLeftCase(int mYTopLeftCase) {
        this.mYTopLeftCase = mYTopLeftCase;
    }

    public int getmXTopRightCase() {
        return mXTopRightCase;
    }

    public void setmXTopRightCase(int mXTopRightCase) {
        this.mXTopRightCase = mXTopRightCase;
    }

    public int getmYTopRightCase() {
        return mYTopRightCase;
    }

    public void setmYTopRightCase(int mYTopRightCase) {
        this.mYTopRightCase = mYTopRightCase;
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
