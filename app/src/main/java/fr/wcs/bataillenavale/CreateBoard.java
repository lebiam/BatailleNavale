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
    private LinearLayout board;
    private String player1Name;
    private String player2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_board);

        textViewCheckpoint = (TextView) findViewById(R.id.textViewCheckpoint);
        buttonReady = (Button) findViewById(R.id.buttonReady);
        buttonReady.setOnClickListener(this);
        buttonPush = (Button)findViewById(R.id.buttonPush);
        buttonPush.setOnClickListener(this);


        board = (LinearLayout) findViewById(R.id.board);

        Intent choiceName = getIntent();
        player1Name = choiceName.getStringExtra("player1Name");
        player2Name = choiceName.getStringExtra("player2Name");

        textViewCheckpoint.setText(player1Name + "vous allez choisir vos positions.");



        PixelGridView pixelGrid = new PixelGridView(this);
        pixelGrid.setNumColumns(10);
        pixelGrid.setNumRows(10);

        board.addView(pixelGrid);
        board.setVisibility(INVISIBLE);
    }


    @Override
    public void onClick(View v) {

        if (v == buttonReady) {
            board.setVisibility(View.VISIBLE);
            buttonReady.setVisibility(INVISIBLE);
        }
        if (v == buttonPush){
            board.setVisibility(INVISIBLE);
            textViewCheckpoint.setVisibility(View.VISIBLE);
            textViewCheckpoint.setText(player2Name+", à ton tour !");
            buttonReady.setVisibility(View.VISIBLE);
        }

    }



}
