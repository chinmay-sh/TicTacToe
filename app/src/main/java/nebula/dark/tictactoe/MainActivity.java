package nebula.dark.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int currentPlayer,counter;
    String choiceP1,choiceP2;
    TextView p1CT,p2CT,currentPlayerText;
    Button b00,b01,b02,b10,b11,b12,b20,b21,b22;

    String[][] boardArray;

    boolean winStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1CT = findViewById(R.id.p1ChoiceText);
        p2CT = findViewById(R.id.p2ChoiceText);
        currentPlayerText = findViewById(R.id.textView3);

        b00 = findViewById(R.id.button);
        b01 = findViewById(R.id.button2);
        b02 = findViewById(R.id.button3);
        b10 = findViewById(R.id.button4);
        b11 = findViewById(R.id.button5);
        b12 = findViewById(R.id.button6);
        b20 = findViewById(R.id.button8);
        b21 = findViewById(R.id.button9);
        b22 = findViewById(R.id.button10);

        counter = 8;

        winStatus = false;

        boardArray = new String[3][3];

        AlertDialog.Builder diag = new AlertDialog.Builder(this);
        diag.setTitle("Player 1:");
        diag.setMessage("Select Option: ");
        diag.setPositiveButton("X", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choiceP1 = "X";
                choiceP2 = "O";
                p1CT.setText("Player 1: " + choiceP1);
                p2CT.setText("Player 2: " + choiceP2);
                ChoiceToast(1);
                currentPlayer = 1;
                playerSetter(currentPlayer);
            }
        }).setNeutralButton("O", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choiceP1 = "O";
                choiceP2 = "X";
                p1CT.setText("Player 1: " + choiceP1);
                p2CT.setText("Player 2: " + choiceP2);
                ChoiceToast(1);
                currentPlayer = 1;
                playerSetter(currentPlayer);
            }
        }).show();

        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b00.setText(PlayerChoiceTextOutput());
                boardArray[0][0]=PlayerChoiceTextOutput();
                checkWinner(0,0);
                PlayerChanger();
                b00.setEnabled(false);
                counterDec();
            }
        });
        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b01.setText(PlayerChoiceTextOutput());
                boardArray[0][1]=PlayerChoiceTextOutput();
                checkWinner(0,1);
                PlayerChanger();
                b01.setEnabled(false);
                counterDec();
            }
        });
        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b02.setText(PlayerChoiceTextOutput());
                boardArray[0][2]=PlayerChoiceTextOutput();
                checkWinner(0,2);
                PlayerChanger();
                b02.setEnabled(false);
                counterDec();
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b10.setText(PlayerChoiceTextOutput());
                boardArray[1][0]=PlayerChoiceTextOutput();
                checkWinner(1,0);
                PlayerChanger();
                b10.setEnabled(false);
                counterDec();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b11.setText(PlayerChoiceTextOutput());
                boardArray[1][1]=PlayerChoiceTextOutput();
                checkWinner(1,1);
                PlayerChanger();
                b11.setEnabled(false);
                counterDec();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b12.setText(PlayerChoiceTextOutput());
                boardArray[1][2]=PlayerChoiceTextOutput();
                checkWinner(1,2);
                PlayerChanger();
                b12.setEnabled(false);
                counterDec();
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b20.setText(PlayerChoiceTextOutput());
                boardArray[2][0]=PlayerChoiceTextOutput();
                checkWinner(2,0);
                PlayerChanger();
                b20.setEnabled(false);
                counterDec();
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b21.setText(PlayerChoiceTextOutput());
                boardArray[2][1]=PlayerChoiceTextOutput();
                checkWinner(2,1);
                PlayerChanger();
                b21.setEnabled(false);
                counterDec();
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b22.setText(PlayerChoiceTextOutput());
                boardArray[2][2]=PlayerChoiceTextOutput();
                checkWinner(2,2);
                PlayerChanger();
                b22.setEnabled(false);
                counterDec();
            }
        });
    }

    protected void checkWinner(int row, int column){
       if((boardArray[row][0] + boardArray[row][1] + boardArray[row][2]).equals("XXX")){
           Log.d("tictactoe","Winner 1 Found in row!");
           declareWinner(1);
       }
       else if((boardArray[row][0] + boardArray[row][1] + boardArray[row][2]).equals("OOO")){
           Log.d("tictactoe","Winner 2 Found in row!");
           declareWinner(2);
       }
       else if((boardArray[0][column] + boardArray[1][column] + boardArray[2][column]).equals("XXX")){
           Log.d("tictactoe","Winner 1 Found in column!");
           declareWinner(1);
       }
       else if((boardArray[0][column] + boardArray[1][column] + boardArray[2][column]).equals("OOO")){
           Log.d("tictactoe","Winner 2 Found in column!");
           declareWinner(2);
       }
       else if((boardArray[0][0] + boardArray[1][1] + boardArray[2][2]).equals("XXX") || (boardArray[0][2] + boardArray[1][1] + boardArray[2][0]).equals("XXX")){
           Log.d("tictactoe","Winner 1 Found in diagonal!");
           declareWinner(1);
       }
       else if((boardArray[0][0] + boardArray[1][1] + boardArray[2][2]).equals("OOO") || (boardArray[0][2] + boardArray[1][1] + boardArray[2][0]).equals("OOO")){
           Log.d("tictactoe","Winner 2 Found in diagonal!");
           declareWinner(2);
       }

    }

    protected void counterDec(){
        Log.d("tictactoe","Counter: " + counter);
        if(!winStatus){
            if(counter >= 1){
                counter--;
            }
            else{
                AlertDialog.Builder diag = new AlertDialog.Builder(this);
                diag.setTitle("Game Over").setMessage("No Winner !!!\nPlay Again or Close App ?").setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("RESET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                }).show();
            }
        }
    }

    protected void ChoiceToast(int player){
        Toast.makeText(this,"Player " + player + " Turn",Toast.LENGTH_SHORT).show();
    }

    protected void PlayerChanger(){
        if(currentPlayer == 1){
            currentPlayer = 2;
        }
        else{
            currentPlayer = 1;
        }
        playerSetter(currentPlayer);
        ChoiceToast(currentPlayer);
    }

    protected void playerSetter(int player){
        currentPlayerText.setText("Current Player: " + player);
    }

    protected String PlayerChoiceTextOutput(){
        if(currentPlayer == 1){
            return choiceP1;
        }
        else {
            return choiceP2;
        }
    }

    protected void declareWinner(int winner){
        winStatus=true;
        AlertDialog.Builder diag = new AlertDialog.Builder(this);
        diag.setTitle("Player "+ winner + " Wins !!!").setMessage("Play Again or Close App ?").setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton("RESET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        }).show();
    }
}
