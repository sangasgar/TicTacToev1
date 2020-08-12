import javax.swing.*;

public class GameWindows extends JFrame {
    static final int WINDOW_POS_X = 400;
    static final int WINDOW_POS_Y = 600;
    static final int WINDOW_HEIGHT= 300;
    static final int WINDOW_WIDTH= 300;
    public GameWindows () {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_HEIGHT, WINDOW_WIDTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setVisible(true);
    }
}

