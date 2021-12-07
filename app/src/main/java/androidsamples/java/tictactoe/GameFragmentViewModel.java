package androidsamples.java.tictactoe;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class GameFragmentViewModel extends ViewModel {
    private TicTacToeBoard mTicTacToeBoard=null;

    public void attachButtons(Button[] listOfButtons){
        mTicTacToeBoard=new TicTacToeBoard(listOfButtons);
    }

    public int[][] getBoardState() {
        return mTicTacToeBoard.getBoardState();
    }

    public void setBoard(TicTacToeBoard ticTacToeBoard){
        mTicTacToeBoard=ticTacToeBoard;
    }

    public int getNumberOfMoves(){
        return mTicTacToeBoard.getNumberOfMoves();
    }

    public TicTacToeBoard getBoard(){
        return mTicTacToeBoard;
    }

    public int buttonPressed(int position){
        return mTicTacToeBoard.buttonPressed(position);
    }
}