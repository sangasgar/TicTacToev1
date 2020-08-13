import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame {
    private GameWindows gameWindows;
    private static final int WINDOW_POS_X = GameWindows.WINDOW_POS_X + 50;
    private static final int WINDOW_POS_Y =  GameWindows.WINDOW_POS_Y + 50;
    private static final int WINDOW_HEIGHT =  GameWindows.WINDOW_HEIGHT - 100;
    private static final int WINDOW_WIDTH = GameWindows.WINDOW_WIDTH - 100;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    static final int GAME_MODE_H_VS_A = 0;
    static final int GAME_MODE_H_VS_H = 1;

    private JRadioButton jrbHumanVsAi;
    private JRadioButton jrbHumanVsHuman;
    private ButtonGroup bgGameMode;

    private JSlider jsFieldSize;
    private JSlider jsWinningLenght;

    public SettingWindow (GameWindows gameWindows) {
        this.gameWindows = gameWindows;
       setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_HEIGHT, WINDOW_WIDTH);

        setTitle("Настройки");
        setLayout(new GridLayout(8,1));
        add(new JLabel("Выберите режим игры:"));

        jrbHumanVsAi = new JRadioButton("Человек Vs Компьютера",true);
        jrbHumanVsHuman = new JRadioButton("Человек Vs Человека");
        add(jrbHumanVsAi);
        add(jrbHumanVsHuman);
        bgGameMode = new ButtonGroup();
        bgGameMode.add(jrbHumanVsAi);
        bgGameMode.add(jrbHumanVsHuman);
        add(new JLabel("Выберите размер поля:"));
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE );
        jsFieldSize.setMajorTickSpacing(1);
        jsFieldSize.setPaintTicks(true);
        jsFieldSize.setPaintLabels(true);
        add(jsFieldSize);

        add(new JLabel("Выберите длину победной линии:"));
        jsWinningLenght = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE );
        jsWinningLenght.setMajorTickSpacing(1);
        jsWinningLenght.setPaintTicks(true);
        jsWinningLenght.setPaintLabels(true);
        add(jsWinningLenght);

        jsFieldSize.addChangeListener(e -> {
            jsWinningLenght.setMaximum(jsFieldSize.getValue());
        });
        JButton buttonStartGame = new JButton("Начать игру");
        add(buttonStartGame);
        buttonStartGame.addActionListener(e -> {
            int mode;
           if(jrbHumanVsAi.isSelected()) {
               mode = GAME_MODE_H_VS_A; }
           else {
               mode = GAME_MODE_H_VS_H;
           }
           int fieldSize = jsFieldSize.getValue();
           int winningLength = jsWinningLenght.getValue();
           Logic.SIZE = fieldSize;
           Logic.SIZEWIN = winningLength;
           Logic.initMap();
           Logic.isFinished = false;

           gameWindows.startNewGame(mode, fieldSize, winningLength);
           setVisible(false);
        });
        setVisible(false);
    }
}
