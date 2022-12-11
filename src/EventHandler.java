import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        outerLoop:
        for(int row = 0; row < Main.BOARD_SIZE; row++){
            for(int col = 0; col < Main.BOARD_SIZE; col++){
                if(GUI.gameInputBoard[row][col] == e.getSource() && Logic.board[row][col] == 0){
                    if(Main.turnPlayer == 1){
                        GUI.gameInputBoard[row][col].setBackground(Color.white);
                        Logic.board[row][col] = 1;
                    }
                    else{
                        GUI.gameInputBoard[row][col].setBackground(Color.black);
                        Logic.board[row][col] = -1;
                    }
                    if(Logic.inWinningPosition(row,col)){
                        GUI.end();
                    }
                    Main.turnPlayer *= -1;
                    break outerLoop;
                }
            }
        }
    }
}
