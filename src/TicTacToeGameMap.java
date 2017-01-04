import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by Raman on 04/01/2017.
 */
public class TicTacToeGameMap extends JPanel {
    private final int CELLS_COUNT = 10;
    private final int SIZE = 500;
    private final int CELL_SIZE = SIZE / CELLS_COUNT;
    private final int DOTS_TO_WIN = 5;

    private Random rand = new Random();
    private int[][] map;
    private int currentPlayer;
    private String gameOver = "";

    public TicTacToeGameMap() {
        setBackground(Color.WHITE);
        map = new int[CELLS_COUNT][CELLS_COUNT];
        currentPlayer = 1;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int x = e.getX() / CELL_SIZE;
                int y = e.getY() / CELL_SIZE;
                if (e.getButton() == MouseEvent.BUTTON1) System.out.println(x + "/" + y);
                if (gameOver.isEmpty() && currentPlayer == 1 && map[x][y] == 0) {
                    map[x][y] = 1;
                    currentPlayer = 2;
                    checkWin(1);
                    if (gameOver.isEmpty()) isFieldFull();
                    repaint();
                }
                repaint();
                if (gameOver.isEmpty() && currentPlayer == 2) {
                    aiTurn();
                    checkWin(2);
                    if (gameOver.isEmpty()) isFieldFull();
                    currentPlayer = 1;
                }
            }
        });
    }

    public boolean isCellEmpty(int x, int y) {
        if (map[x][y] == 0) return true;
        return false;
    }

    public void isFieldFull(){
        for (int i = 0; i < CELLS_COUNT; i++) {
            for (int j = 0; j < CELLS_COUNT; j++) {
                if (map[i][j] == 0) return;
            }
        }
        gameOver = "    DRAW";
    }

    public void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(CELLS_COUNT);
            y = rand.nextInt(CELLS_COUNT);
        } while (!isCellEmpty(x, y));
        map[x][y] = 2;
        repaint();
    }

    public void checkWin(int ox) {
        for (int i = 0; i < CELLS_COUNT; i++) {
            for (int j = 0; j < CELLS_COUNT; j++) {
                if (checkLine(i, j, 1, 0, ox, DOTS_TO_WIN) ||
                        checkLine(i, j, 0, 1, ox, DOTS_TO_WIN) ||
                        checkLine(i, j, 1, 1, ox, DOTS_TO_WIN) ||
                        checkLine(i, j, 1, -1, ox, DOTS_TO_WIN)) {
                    if (ox == 1) gameOver = "Player 1 WON";
                    if (ox == 2) gameOver = "Player 2 WON";
                    return;
                }
            }
        }
    }

    public boolean checkLine(int sx, int sy, int vx, int vy, int ox, int l) {
        if (sx + l * vx > CELLS_COUNT || sy + l * vy > CELLS_COUNT || sy + l * vy < -1) return false;
        for (int i = 0; i < l; i++) {
            if (map[sy + vy * i][sx + vx * i] != ox) return false;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (int i = 0; i < CELLS_COUNT; i++) {
            g.drawLine(0, i * CELL_SIZE, SIZE, i * CELL_SIZE);
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, SIZE);
        }
        g.drawRect(0, 0, SIZE - 1, SIZE - 1);

        for (int i = 0; i < CELLS_COUNT; i++) {
            for (int j = 0; j < CELLS_COUNT; j++) {
                if (map[i][j] > 0) {
                    if (map[i][j] == 1) g.setColor(Color.RED);
                    if (map[i][j] == 2) g.setColor(Color.BLUE);
                    g.fillOval(i * CELL_SIZE + 2, j * CELL_SIZE + 2, CELL_SIZE - 4, CELL_SIZE - 4);

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(Color.BLUE);
                    g2d.setStroke(new BasicStroke(4));
                    g2d.drawLine(i * CELL_SIZE + 6, j * CELL_SIZE + 6, (i + 1) * CELL_SIZE - 6, (j + 1) * CELL_SIZE - 6);
                    g2d.drawLine(i * CELL_SIZE + 6, (j + 1) * CELL_SIZE - 6, (i + 1) * CELL_SIZE - 6, (j) * CELL_SIZE + 6);
                }
            }
        }

        if (!gameOver.isEmpty()) {
            g.setFont(new Font("Helvetica", Font.BOLD, 72));
            g.setColor(Color.black);
            g.drawString(gameOver, 74, 204);
            g.setColor(Color.orange);
            g.drawString(gameOver, 70, 200);
        }
    }
}
