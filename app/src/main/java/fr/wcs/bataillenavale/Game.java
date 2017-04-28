package fr.wcs.bataillenavale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Game extends AppCompatActivity {

    private ArmadaClass armadaClassPlayer1;
    private ArmadaClass armadaClassPlayer2;
    private LinearLayout boardPlayer1;
    private LinearLayout boardPlayer2;
    private GridGamePlayerOne gridGamePlayerOne;
    private GridGamePlayerTwo gridGamePlayerTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent goPlay = getIntent();
        armadaClassPlayer1 = (ArmadaClass) goPlay.getExtras().get("Player1");
        armadaClassPlayer2 = (ArmadaClass) goPlay.getExtras().get("Player2");


        boardPlayer1 = (LinearLayout) findViewById(R.id.boardGamePlayer1);
        boardPlayer2 = (LinearLayout) findViewById(R.id.boardGamePlayer2);

        gridGamePlayerOne = new GridGamePlayerOne(this);
        gridGamePlayerOne.setTabPlayerTwo(armadaClassPlayer2.getShipTab());
        gridGamePlayerOne.setNumColumns(10);
        gridGamePlayerOne.setNumRows(10);

        gridGamePlayerTwo = new GridGamePlayerTwo(this);
        gridGamePlayerTwo.setTabPlayerOne(armadaClassPlayer1.getShipTab());
        gridGamePlayerTwo.setNumColumns(10);
        gridGamePlayerTwo.setNumRows(10);

        boardPlayer1.addView(gridGamePlayerOne);
        boardPlayer2.addView(gridGamePlayerTwo);

        boardPlayer1.setVisibility(View.INVISIBLE);






    }
}
