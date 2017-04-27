package fr.wcs.bataillenavale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateBoard extends AppCompatActivity implements View.OnClickListener {

    TextView textViewCheckpoint;
    Button buttonReady;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_board);

        textViewCheckpoint = (TextView)findViewById(R.id.textViewCheckpoint);
        buttonReady = (Button)findViewById(R.id.buttonReady);
        buttonReady.setOnClickListener(this);

        Intent choiceName = getIntent();
        String player1Name = choiceName.getStringExtra("player1Name");
        String player2Name = choiceName.getStringExtra("player2Name");

        textViewCheckpoint.setText(player1Name+" vous allez choisir vos positions.");

        PixelGrid.PixelGridView pixelGrid = new PixelGrid.PixelGridView(this);
        pixelGrid.setNumColumns(10);
        pixelGrid.setNumRows(10);

        setContentView(pixelGrid);
    }

    @Override
    public void onClick(View v) {

    }
}
