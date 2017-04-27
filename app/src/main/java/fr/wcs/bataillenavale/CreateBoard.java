package fr.wcs.bataillenavale;

import android.app.FragmentManager;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.graphics.Typeface;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CreateBoard extends AppCompatActivity implements View.OnClickListener {

    TextView textViewCheckpoint;
    Button buttonReady;
    LinearLayout board;
    ImageView vaisseau,vaisseau2, vaisseau3, vaisseau4, vaisseau5;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_board);

        //views to drag
        vaisseau = (ImageView) findViewById(R.id.vaisseau);
        vaisseau2 = (ImageView) findViewById(R.id.vaisseau2);
        vaisseau3 = (ImageView) findViewById(R.id.vaisseau3);
        vaisseau4 = (ImageView) findViewById(R.id.vaisseau4);
        vaisseau5 = (ImageView) findViewById(R.id.vaisseau5);

        // view to drop
        board = (LinearLayout) findViewById(R.id.board);



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

        board.addView(pixelGrid);
        board.setVisibility(View.INVISIBLE);

        //set touch listeners
        vaisseau.setOnTouchListener(new ChoiceTouchListener());
        vaisseau2.setOnTouchListener(new ChoiceTouchListener());
        vaisseau3.setOnTouchListener(new ChoiceTouchListener());
        vaisseau4.setOnTouchListener(new ChoiceTouchListener());
        vaisseau5.setOnTouchListener(new ChoiceTouchListener());

        //set drag listeners
        board.setOnDragListener(new ChoiceDragListener());


    }
    private final class ChoiceTouchListener implements OnTouchListener {

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                //setup drag

                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);

                return true;
            }
            else {
                return false;
            }

        }

    }
    private class ChoiceDragListener implements OnDragListener {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            //handle drag events

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:
                    //handle the dragged view being dropped over a drop view

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
                default:
                    break;
            }



            return true;
        }

    }

    @Override
    public void onClick(View v) {

        if (v == buttonReady) {
            board.setVisibility(View.VISIBLE);
            buttonReady.setVisibility(View.INVISIBLE);
        }

    }








    }


