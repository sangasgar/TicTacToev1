import javax.swing.*;
import java.awt.*;

public class PopupStatus extends JFrame {
    private static final int WINDOW_POS_X = GameWindows.WINDOW_POS_X + 200;
    private static final int WINDOW_POS_Y =  GameWindows.WINDOW_POS_Y + 100;
    private static final int WINDOW_HEIGHT =  GameWindows.WINDOW_HEIGHT - 400;
    private static final int WINDOW_WIDTH = GameWindows.WINDOW_WIDTH - 400;
    private GameWindows gameWindows;
    private BattleMap battleMap;

    public PopupStatus (BattleMap battleMap) {
        this.gameWindows = gameWindows;
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_HEIGHT, WINDOW_WIDTH);

        setLayout(new GridLayout(2,1));
        JButton buttonOk = new JButton("Хорошо");

        if (Logic.STATUSAI == 1) {
            add(new JLabel("Победил игрок!"));
        } else if (Logic.STATUSAI == 2) {
            add(new JLabel("Победил компьютер!"));
        } else if (Logic.STATUSAI == 3) {
            add(new JLabel("Ничья!"));
        } else if (Logic.STATUSAI == 4) {
            add(new JLabel("Победил игрок №2!"));
        }
        add(buttonOk);
        buttonOk.addActionListener(e -> {
            setVisible(false);
        });


        setVisible(false);

    }
}
