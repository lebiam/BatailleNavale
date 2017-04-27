package fr.wcs.bataillenavale;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by apprenti on 27/04/17.
 *
 * ____________________________________
 * |                 |                  |
 * |                 |                  |
 * |   leftCase      |   rightCase      |
 * |                 |                  |
 * |_________________|__________________|
 */

public class TwoCasesShipClass {
    private int mXLeftCase;
    private int mYLeftCase;

    private int mXRightCase;
    private int mYRightCase;

    int durability = 2;

    public TwoCasesShipClass(int xLeftCase, int yLeftCase){
        mXLeftCase = xLeftCase;
        mYLeftCase = yLeftCase;

        mXRightCase = xLeftCase + 1;
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
