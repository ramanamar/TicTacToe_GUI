import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by Raman on 04/01/2017.
 */
public class TicTacToeGameMap extends JPanel {
    private int cells_count = 10;
    private final int SIZE = 500;
    private int cell_size = SIZE / cells_count;
    private int dots_to_win = 5;

    private Random rand = new Random();
    private int[][] map;
    private int currentPlayer;
    private String gameOver;
    private String opponents = "H-AI"; //H-AI, H-H

    public void setOpponents(String opponents) {
        this.opponents = opponents;
    }

    public void setConditions(int size, int dotsToWin) {
        cells_count = size;
        dots_to_win = dotsToWin;
        cell_size = SIZE / cells_count;
    }

    public void startGame() {
        currentPlayer = 1;
        gameOver = "";
        map = new int[cells_count][cells_count];
        repaint();
    }

    public TicTacToeGameMap() {
        setBackground(Color.WHITE);
        currentPlayer = 1;
        gameOver = "NOTHING";
        map = new int[cells_count][cells_count];
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int x = e.getX() / cell_size;
                int y = e.getY() / cell_size;
                if (e.getButton() == MouseEvent.BUTTON1) System.out.println(x + "/" + y);
                if (gameOver.isEmpty() && currentPlayer == 1 && map[x][y] == 0) {
                    map[x][y] = 1;
                    currentPlayer = 2;
                    checkWin(1);
                    if (gameOver.isEmpty()) isFieldFull();
                    repaint();
                    return;
                }

                if (gameOver.isEmpty() && currentPlayer == 2) {
                    if (opponents.equals("H-AI")) {
                        aiTurn();
                        checkWin(2);
                        if (gameOver.isEmpty()) isFieldFull();
                        currentPlayer = 1;
                    } else {
                        if (map[x][y] == 0) {
                            map[x][y] = 2;
                            currentPlayer = 1;
                            checkWin(2);
                            if (gameOver.isEmpty()) isFieldFull();
                            repaint();
                        }
                    }
                }
            }
        });
    }

    public boolean isCellEmpty(int x, int y) {
        if (map[x][y] == 0) return true;
        return false;
    }

    public void isFieldFull() {
        for (int i = 0; i < cells_count; i++) {
            for (int j = 0; j < cells_count; j++) {
                if (map[i][j] == 0) return;
            }
        }
        gameOver = "    DRAW";
    }

    public void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(cells_count);
            y = rand.nextInt(cells_count);
        } while (!isCellEmpty(x, y));
        map[x][y] = 2;
        repaint();
    }

    public void checkWin(int ox) {
        for (int i = 0; i < cells_count; i++) {
            for (int j = 0; j < cells_count; j++) {
                if (checkLine(i, j, 1, 0, ox, dots_to_win) ||
                        checkLine(i, j, 0, 1, ox, dots_to_win) ||
                        checkLine(i, j, 1, 1, ox, dots_to_win) ||
                        checkLine(i, j, 1, -1, ox, dots_to_win)) {
                    if (ox == 1) gameOver = "Player 1 WON";
                    if (ox == 2) gameOver = "Player 2 WON";
                    return;
                }
            }
        }
    }

    public boolean checkLine(int sx, int sy, int vx, int vy, int ox, int l) {
        if (sx + l * vx > cells_count || sy + l * vy > cells_count || sy + l * vy < -1) return false;
        for (int i = 0; i < l; i++) {
            if (map[sy + vy * i][sx + vx * i] != ox) return false;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver.equals("NOTHING")) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, 500, 500);
            return;
        }
        g.setColor(Color.BLACK);
        for (int i = 0; i < cells_count; i++) {
            g.drawLine(0, i * cell_size, SIZE, i * cell_size);
            g.drawLine(i * cell_size, 0, i * cell_size, SIZE);
        }
        g.drawRect(0, 0, SIZE - 1, SIZE - 1);

        for (int i = 0; i < cells_count; i++) {
            for (int j = 0; j < cells_count; j++) {
                if (map[i][j] > 0) {
                    if (map[i][j] == 1) {
                        Graphics2D g2d = (Graphics2D) g;
                        g2d.setColor(Color.BLUE);
                        g2d.setStroke(new BasicStroke(4));
                        g2d.drawLine(i * cell_size + 6, j * cell_size + 6, (i + 1) * cell_size - 6, (j + 1) * cell_size - 6);
                        g2d.drawLine(i * cell_size + 6, (j + 1) * cell_size - 6, (i + 1) * cell_size - 6, (j) * cell_size + 6);
                    }
                    if (map[i][j] == 2) {
                        g.setColor(Color.RED);
                        g.fillOval(i * cell_size + 2, j * cell_size + 2, cell_size - 4, cell_size - 4);
                    }
                }
            }
        }

        if (!gameOver.isEmpty()) {
            g.setFont(new Font("Helvetica", Font.BOLD, 52));
            g.setColor(Color.black);
            g.drawString(gameOver, 74, 204);
            g.setColor(Color.orange);
            g.drawString(gameOver, 70, 200);
        }
    }
}
