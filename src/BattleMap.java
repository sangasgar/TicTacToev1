import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindows gameWindow;
    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;
    private PopupStatus popupStatus;



    public BattleMap(GameWindows gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.ORANGE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickBattleField(e);
            }
        });

    }


    private void clickBattleField(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (SettingWindow.mode == 0) {
            if(!Logic.isFinished){
                Logic.humanTurn(cellX, cellY);
            } else {
                popupStatus = new PopupStatus(this);
                popupStatus.setVisible(true);
            }
            repaint();
        } else if(SettingWindow.mode == 1){

                if(!Logic.isFinished){
                    Logic.humanTurnUser(cellX, cellY);
                } else {
                    popupStatus = new PopupStatus(this);
                    popupStatus.setVisible(true);
                }
                repaint();

        }

    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSize;
        cellWidth = panelWidth / fieldSize;

        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }



        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }




    }

    private void drawX(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(cellWidth *  (x + 1), cellHeight * y, cellWidth * x, cellHeight * (y + 1));
        g.drawLine(cellWidth * x, cellHeight * y, cellWidth * (x + 1), cellHeight * (y + 1));
    }

    private void drawO(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        g.drawOval(cellWidth * x, cellHeight * y, cellWidth, cellHeight);
    }
}
