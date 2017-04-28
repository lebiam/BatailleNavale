package fr.wcs.bataillenavale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.INVISIBLE;

public class CreateBoard extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewCheckpoint;
    private Button buttonReady;
    private Button buttonPush;
    private LinearLayout boardPlayer1;
    private LinearLayout boardPlayer2;
    private String player1Name;
    private String player2Name;
    private PixelGridView mPixelGridView;
    private PixelGridViewPlayerTwo mPixelGridViewPlayerTwo;
    private static int CONSTANT_STEP_PLAYER_1 = 0;
    private static int CONSTANT_STEP_PLAYER_2 = 1;
    private int step = 0;
    private Button start;
    private ArmadaClass armadaPlayer1;
    private ArmadaClass armadaPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_board);

        textViewCheckpoint = (TextView) findViewById(R.id.textViewCheckpoint);
        buttonReady = (Button) findViewById(R.id.buttonReady);
        buttonReady.setOnClickListener(this);
        buttonPush = (Button)findViewById(R.id.buttonPush);
        buttonPush.setOnClickListener(this);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);


        boardPlayer1 = (LinearLayout) findViewById(R.id.board);
        boardPlayer2 = (LinearLayout) findViewById(R.id.bordPlayer2);

        Intent choiceName = getIntent();
        player1Name = choiceName.getStringExtra("player1Name");
        player2Name = choiceName.getStringExtra("player2Name");

        textViewCheckpoint.setText(player1Name + "vous allez choisir vos positions.");



        mPixelGridView = new PixelGridView(this);
        mPixelGridView.setNumColumns(10);
        mPixelGridView.setNumRows(10);

        mPixelGridViewPlayerTwo = new PixelGridViewPlayerTwo(this);
        mPixelGridViewPlayerTwo.setNumColumns(10);
        mPixelGridViewPlayerTwo.setNumRows(10);


        boardPlayer1.addView(mPixelGridView);
        boardPlayer2.addView(mPixelGridViewPlayerTwo);
        boardPlayer1.setVisibility(INVISIBLE);
        boardPlayer2.setVisibility(INVISIBLE);
        start.setVisibility(INVISIBLE);
    }


    @Override
    public void onClick(View v) {

        if (v == buttonReady) {
            boardPlayer1.setVisibility(View.VISIBLE);
            buttonReady.setVisibility(INVISIBLE);
            textViewCheckpoint.setVisibility(INVISIBLE);
        }
        if (v == buttonPush){
            if (step == CONSTANT_STEP_PLAYER_1) {
                boardPlayer1.setVisibility(INVISIBLE);
                textViewCheckpoint.setVisibility(View.VISIBLE);
                textViewCheckpoint.setText(player2Name + ", à ton tour !");
                buttonReady.setVisibility(View.VISIBLE);
                armadaPlayer1 = new ArmadaClass(mPixelGridView.getShipTab());
                boardPlayer1.setVisibility(INVISIBLE);
                boardPlayer2.setVisibility(View.VISIBLE);
                buttonReady.setVisibility(INVISIBLE);
                step++;
                return;
            }
            if (step == CONSTANT_STEP_PLAYER_2) {
                armadaPlayer2 = new ArmadaClass(mPixelGridViewPlayerTwo.getShipTabPlayerTwo());
                boardPlayer2.setVisibility(INVISIBLE);
                textViewCheckpoint.setVisibility(View.VISIBLE);
                textViewCheckpoint.setText(player1Name + " " + player2Name + " préparez vous à une partie déjantée !");
                start.setVisibility(View.VISIBLE);
            }
        }

        if (v == start){

            Intent goPlay = new Intent(this, Game.class);
            goPlay.putExtra("Player1", armadaPlayer1);
            goPlay.putExtra("Player2", armadaPlayer2);
            goPlay.putExtra("Pseudo", player1Name);
            goPlay.putExtra("Pseudo", player2Name);
            startActivity(goPlay);
        }

    }



}
