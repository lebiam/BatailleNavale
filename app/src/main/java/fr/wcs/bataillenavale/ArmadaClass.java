package fr.wcs.bataillenavale;

/**
 * Created by apprenti on 27/04/17.
 */

public class ArmadaClass {

    /*private FourCasesShipClass mFourCasesShip;
    private ThreeCasesShipClass mThreeCasesShipOne;
    private ThreeCasesShipClass mThreeCasesShipTwo;
    private TwoCasesShipClass mTwoCasesShip;
    private FiveCasesShipClass mFiveCasesShip;*/
    private boolean[][] mShipTab;
    private int armadaDurability = 17;

    public ArmadaClass(boolean[][] shipTab){
        /*mFourCasesShip = fourCasesShip;
        mThreeCasesShipOne = threeCasesShipOne;
        mThreeCasesShipTwo = threeCasesShipTwo;
        mTwoCasesShip = twoCasesShip;
        mFiveCasesShip = fiveCasesShip;*/
        mShipTab = shipTab;
    }

    /*public FourCasesShipClass getFourCasesShip() {
        return mFourCasesShip;
    }

    public void setFourCasesShip(FourCasesShipClass mFourCasesShip) {
        this.mFourCasesShip = mFourCasesShip;
    }

    public ThreeCasesShipClass getThreeCasesShipOne() {
        return mThreeCasesShipOne;
    }

    public void setThreeCasesShipOne(ThreeCasesShipClass mThreeCasesShipOne) {
        this.mThreeCasesShipOne = mThreeCasesShipOne;
    }

    public ThreeCasesShipClass getThreeCasesShipTwo() {
        return mThreeCasesShipTwo;
    }

    public void setThreeCasesShipTwo(ThreeCasesShipClass mThreeCasesShipTwo) {
        this.mThreeCasesShipTwo = mThreeCasesShipTwo;
    }

    public TwoCasesShipClass getTwoCasesShip() {
        return mTwoCasesShip;
    }

    public void setTwoCasesShip(TwoCasesShipClass mTwoCasesShip) {
        this.mTwoCasesShip = mTwoCasesShip;
    }

    public FiveCasesShipClass getFiveCasesShip() {
        return mFiveCasesShip;
    }

    public void setFiveCasesShip(FiveCasesShipClass mFiveCasesShip) {
        this.mFiveCasesShip = mFiveCasesShip;
    }*/

    public boolean[][] getShipTab() {
        return mShipTab;
    }

    public void setShipTab(boolean[][] mShipTab) {
        this.mShipTab = mShipTab;
    }

    public int getArmadaDurability() {
        return armadaDurability;
    }

    public void setArmadaDurability(int armadaDurability) {
        this.armadaDurability = armadaDurability;
    }
    public void armadaHit(){
        armadaDurability--;
    }

}
