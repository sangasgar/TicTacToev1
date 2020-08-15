import javax.swing.*;
import java.awt.*;

public class GameWindows extends JFrame {
    static final int WINDOW_POS_X = 600;
    static final int WINDOW_POS_Y = 300;
    static final int WINDOW_HEIGHT= 600;
    static final int WINDOW_WIDTH= 600;
    private SettingWindow settingWindow;
    private BattleMap battleMap;


    public GameWindows () {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_HEIGHT, WINDOW_WIDTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Крестики-Нолики от Гарегина Папяна (с.Мовсес) !!!!");

        settingWindow = new SettingWindow(this);
        battleMap = new BattleMap(this);


        add(battleMap,BorderLayout.CENTER);
        JPanel pane1 = new JPanel(new GridLayout(1,2));

        JButton buttonOk = new JButton("Начать новую игру");
        pane1.add(buttonOk);
        JButton buttonExit = new JButton("Выйти");

        pane1.add(buttonExit);
        add(pane1, BorderLayout.SOUTH);


        buttonExit.addActionListener(e -> {
            System.exit(0);
        });
        buttonOk.addActionListener(e -> {
            settingWindow.setVisible(true);

        });

        setVisible(true);


    }
    public void startNewGame(int mode, int fieldSize, int winningLength) {
       battleMap.startNewGame(mode, fieldSize, winningLength);
    }
}

