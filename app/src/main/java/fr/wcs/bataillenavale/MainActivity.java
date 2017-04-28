package fr.wcs.bataillenavale;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSimpleGame;
    Button buttonOkSimpleGame;
    EditText editTextPlayer1;
    EditText editTextPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonSimpleGame = (Button)findViewById(R.id.buttonSimpleGame);
        buttonOkSimpleGame = (Button)findViewById(R.id.buttonOkSimpleGame);
        editTextPlayer1 = (EditText)findViewById(R.id.editTextPlayer1);
        editTextPlayer2 = (EditText)findViewById(R.id.editTextPlayer2);

        editTextPlayer1.setVisibility(View.INVISIBLE);
        editTextPlayer2.setVisibility(View.INVISIBLE);
        buttonOkSimpleGame.setVisibility(View.INVISIBLE);

        buttonSimpleGame.setOnClickListener(this);
        buttonOkSimpleGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonSimpleGame){
            buttonSimpleGame.setVisibility(View.INVISIBLE);
            editTextPlayer1.setVisibility(View.VISIBLE);
            editTextPlayer2.setVisibility(View.VISIBLE);
            buttonOkSimpleGame.setVisibility(View.VISIBLE);
        }

        if (v == buttonOkSimpleGame){
            if (editTextPlayer1.length() != 0 && editTextPlayer2.length() != 0){
                String player1Name = editTextPlayer1.getText().toString().trim();
                String player2Name = editTextPlayer2.getText().toString().trim();
                Intent choiceName = new Intent(this, CreateBoard.class);
                choiceName.putExtra("player1Name", player1Name);
                choiceName.putExtra("player2Name", player2Name);
                startActivity(choiceName);
            }
            else{
                Toast.makeText(MainActivity.this, "Chaque joueur doit avoir un pseudo.",Toast.LENGTH_LONG).show();
            }
        }
    }
}
