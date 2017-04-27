package fr.wcs.bataillenavale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CreateBoard extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewCheckpoint;
    private Button buttonReady;
    private LinearLayout board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_board);

        textViewCheckpoint = (TextView)findViewById(R.id.textViewCheckpoint);
        buttonReady = (Button)findViewById(R.id.buttonReady);
        buttonReady.setOnClickListener(this);

        board = (LinearLayout) findViewById(R.id.board);

        Intent choiceName = getIntent();
        String player1Name = choiceName.getStringExtra("player1Name");
        String player2Name = choiceName.getStringExtra("player2Name");

        textViewCheckpoint.setText(player1Name+" vous allez choisir vos positions.");



        PixelGrid.PixelGridView pixelGrid = new PixelGrid.PixelGridView(this);
        pixelGrid.setNumColumns(10);
        pixelGrid.setNumRows(10);

        board.addView(pixelGrid);
        board.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {

        if (v == buttonReady) {
            board.setVisibility(View.VISIBLE);
            buttonReady.setVisibility(View.INVISIBLE);
        }

    }
}
