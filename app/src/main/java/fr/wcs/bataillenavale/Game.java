package fr.wcs.bataillenavale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    private ArmadaClass armadaClassPlayer1;
    private ArmadaClass armadaClassPlayer2;
    private LinearLayout boardPlayer1;
    private LinearLayout boardPlayer2;
    private GridGamePlayerOne gridGamePlayerOne;
    private GridGamePlayerTwo gridGamePlayerTwo;
    private TextView textViewMain;
    private Button buttonMain;
    private int JOUEUR1 = 1;
    private int JOUEUR2 = 2;
    private int aQuiLeTour = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent goPlay = getIntent();
        armadaClassPlayer1 = (ArmadaClass) goPlay.getExtras().get("Player1");
        armadaClassPlayer2 = (ArmadaClass) goPlay.getExtras().get("Player2");
        final String player1Name = goPlay.getStringExtra("Pseudo");
        final String player2Name = goPlay.getStringExtra("Pseudo2");


        boardPlayer1 = (LinearLayout) findViewById(R.id.boardGamePlayer1);
        boardPlayer2 = (LinearLayout) findViewById(R.id.boardGamePlayer2);
        textViewMain = (TextView)findViewById(R.id.textViewMain);
        buttonMain = (Button)findViewById(R.id.buttonMain);

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

        boardPlayer2.setVisibility(View.INVISIBLE);

        textViewMain.setText(player1Name+", à toi !");

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aQuiLeTour == JOUEUR1){
                    boardPlayer1.setVisibility(View.INVISIBLE);
                    boardPlayer2.setVisibility(View.VISIBLE);
                    textViewMain.setText(player2Name+", à toi !");
                    aQuiLeTour++;
                    GridGamePlayerTwo.HASSHOOTPTWO = false;
                    return;
                }
                if (aQuiLeTour == JOUEUR2){
                    boardPlayer2.setVisibility(View.INVISIBLE);
                    boardPlayer1.setVisibility(View.VISIBLE);
                    textViewMain.setText(player1Name+" , à toi");
                    aQuiLeTour--;
                    GridGamePlayerOne.HASSHOOT = false;
                }
            }
        });






    }
}
