package fr.wcs.bataillenavale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateBoard extends AppCompatActivity implements View.OnClickListener {

    TextView textViewCheckpoint;
    Button buttonReady;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_board);

        textViewCheckpoint = (TextView) findViewById(R.id.textViewCheckpoint);
        buttonReady = (Button) findViewById(R.id.buttonReady);
        buttonReady.setOnClickListener(this);

        Intent choiceName = getIntent();
        String player1Name = choiceName.getStringExtra("player1Name");
        String player2Name = choiceName.getStringExtra("player2Name");

        textViewCheckpoint.setText(player1Name + " vous allez choisir vos positions.");

        PixelGrid.PixelGridView pixelGrid = new PixelGrid.PixelGridView(this);
        pixelGrid.setNumColumns(10);
        pixelGrid.setNumRows(10);

        setContentView(pixelGrid);
    }

    @Override
    public void onClick(View v) {

    }

    private void placeBoatsView() {
        setContentView(R.layout.activity_create_board);
        mRetainedFragment.setCurrentView("placeBoatsView");
        /* Define the image objects */
        ImageView vaisseau = (ImageView) findViewById(R.id.vaisseau);
        ImageView battleship = (ImageView) findViewById(R.id.vaisseau2);
        ImageView destroyer = (ImageView) findViewById(R.id.vaisseau3);
        ImageView submarine = (ImageView) findViewById(R.id.vaisseau4);
        ImageView patrol = (ImageView) findViewById(R.id.vaisseau5);
        game.getPlayer1Board().boardView = (BoardView) findViewById(R.id.humanBoardView);
        game.getPlayer1Board().boardView.setBoard(game.getPlayer1Board());

        // This means the user had already placed boats on the grid but decided to go back to this view and perhaps
        // change the boats.
        if (game.getPlayer1Board().grid != null) {
            game.getPlayer1Board().boardView.coordinatesOfPlayer1Ships = game.getPlayer1Board().grid;
            game.getPlayer1Board().boardView.invalidate();
        }

        /* Allow these boat images to be draggable, listen when they are touched */
        aircraft.setOnTouchListener(new MyTouchListener());
        battleship.setOnTouchListener(new MyTouchListener());
        destroyer.setOnTouchListener(new MyTouchListener());
        submarine.setOnTouchListener(new MyTouchListener());
        patrol.setOnTouchListener(new MyTouchListener());

        /* Define the particular location where these boat images are allowed to be dragged onto */
        findViewById(R.id.humanBoardPlacer).setOnDragListener(new MyDragListener());
        ;
        Button next = (Button) findViewById(R.id.next); // Advance to the next view
        Button random = (Button) findViewById(R.id.random); // Place boats at random
        changeFont(next);
        changeFont(random);
        next.setVisibility(View.VISIBLE);


    }

}
