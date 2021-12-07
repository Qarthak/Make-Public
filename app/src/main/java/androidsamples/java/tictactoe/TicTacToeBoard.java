package androidsamples.java.tictactoe;

import android.util.Log;
import android.widget.Button;

public class TicTacToeBoard {
    private static final String TAG = "TicTacToeBoard";
    private int mNumberOfMoves;
    private final int[][] boardState;
//    private String[] players = {"Player1","None","Player2"};
    private final Button[] mListOfButtons;
    private int gameMode;


    public TicTacToeBoard(Button[] listOfButtons){
        mNumberOfMoves=0;
        mListOfButtons=listOfButtons;
        boardState=new int[3][3];
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                boardState[i][j] = 0;
            }
        }
    }

    public int getNumberOfMoves(){
        return mNumberOfMoves;
    }

    public int[][] getBoardState() {
        return boardState.clone();
    }

    public int whoWon(){
        for(int i=0; i<3; i++){
            if(boardState[i][0]==boardState[i][1] && boardState[i][1]==boardState[i][2]){
                if(boardState[i][0]!=0)
                    return boardState[i][0];
            }
        }
        for(int i=0; i<3; i++){
            if(boardState[0][i]==boardState[1][i] && boardState[1][i]==boardState[2][i]){
                if(boardState[0][i]!=0){
                    return boardState[0][i];
                }
            }
        }

        if(boardState[0][0]==boardState[1][1] && boardState[1][1]==boardState[2][2]){
            if(boardState[1][1]!=0){
                return boardState[1][1];
            }
        }
        if(boardState[2][0]==boardState[1][1] && boardState[1][1]==boardState[0][2]){
            if(boardState[1][1]!=0){
                return boardState[1][1];
            }
        }
        return 0;
    }

    public Boolean isGameOver(){
        if(whoWon()!=0){
            return Boolean.TRUE;
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(boardState[i][j]==0){
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    public int gameResult(){
        if(whoWon()!=0){
            return whoWon();
        }
        //Draw or in progress
        if(isGameOver()==Boolean.TRUE){
            return 0; //Draw
        }
        return -2; //In progress
    }

    public int buttonPressed(int position){
        if(isGameOver()==Boolean.TRUE){
            return -2;
        }

        int row=position/3;
        int column=position%3;
        if(boardState[row][column]!=0){
            return -2;
        }
        boardState[row][column]=1;
        mNumberOfMoves+=1;
        mListOfButtons[position].setText("X");

        if(isGameOver()==Boolean.FALSE){
             int AIMovePosition = MCTSGameEngine();
             mNumberOfMoves+=1;
             if(AIMovePosition==-1){
                 Log.d(TAG, "How did this even happen?!");
             }
             else{
                 mListOfButtons[AIMovePosition].setText("O");
             }
            if(isGameOver()==Boolean.TRUE){
                return gameResult();
            }
        }
        return gameResult();
    }

//    public

    private int MCTSGameEngine(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(boardState[i][j]==0){
                    boardState[i][j]=-1;
                    return 3*i+j;  //This will give the button's position
                }
            }
        }
        return -1;
    }
}
