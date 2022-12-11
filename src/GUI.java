import javax.swing.*;
import java.awt.*;

public class GUI {
    public static JButton gameInputBoard[][] = new JButton[Main.BOARD_SIZE][Main.BOARD_SIZE];
    public static JFrame gameFrame;
    public static JPanel gamePanel;
    public GUI(String name, int width, int height){
        gameFrame = new JFrame(name);
        reset();
        gameFrame.setResizable(false);
        gameFrame.setSize(new Dimension(width, height));
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = setPanel();
        gameFrame.add(gamePanel);
        gameFrame.setVisible(true);
    }
    public static void end(){
        System.out.println("won");
        gamePanel.removeAll();
        JLabel text = new JLabel();
        gamePanel.setLayout(new GridLayout(1,1));
        gamePanel.add(text);
        text.setFont(new Font("font",0,32));
        text.setText(String.valueOf(Main.turnPlayer) + " wins");
        gameFrame.setVisible(true);
    }
    private JPanel setPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(Main.BOARD_SIZE,Main.BOARD_SIZE));
        for(int row = 0; row < Main.BOARD_SIZE; row++){
            for(int col = 0; col < Main.BOARD_SIZE; col++){
                panel.add(gameInputBoard[row][col]);
                gameInputBoard[row][col].addActionListener(new EventHandler());
            }
        }
        return panel;
    }

    private void reset() {
        for(int row = 0; row < Main.BOARD_SIZE; row++){
            for(int col = 0; col < Main.BOARD_SIZE; col++){
                StringBuilder sb = new StringBuilder();
                gameInputBoard[row][col] = new JButton();
                gameInputBoard[row][col].setBackground(Color.orange);
                if(col == 0){
                    sb.append((char) (65 + row));
                }
                if(row == 0){
                    sb.append(col + 1);
                }
                gameInputBoard[row][col].setText(sb.toString());
            }
        }
    }

}
