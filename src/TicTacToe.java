import java.util.Random;
import java.util.Scanner;

/**
 * Created by Raman on 26/12/2016.
 */
public class TicTacToe {
    public static char[][] map;
    public static Scanner sc;
    public static Random rand;
    public static final int FIELD_SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        rand = new Random();
        initMap();
        showMap();

        while (true) {
            humanTurn();
            showMap();
            if (checkWin('x')) {
                System.out.println("Human WON");
                break;
            }
            if (isMapFull()) break;

//            aiTurn();
            aiHardTurn();
            showMap();
            if (checkWin('o')) {
                System.out.println("AI WON");
                break;
            }
            if (isMapFull()) break;
        }
        System.out.println("Game Over");
    }

    public static boolean checkWin(char ox) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (checkLine(i, j, 1, 0, ox, DOTS_TO_WIN)) return true;
                if (checkLine(i, j, 0, 1, ox, DOTS_TO_WIN)) return true;
                if (checkLine(i, j, 1, 1, ox, DOTS_TO_WIN)) return true;
                if (checkLine(i, j, 1, -1, ox, DOTS_TO_WIN)) return true;
            }
        }
        return false;
    }

    public static boolean checkLine(int sx, int sy, int vx, int vy, char ox, int l) {
        if (sx + l * vx > FIELD_SIZE || sy + l * vy > FIELD_SIZE || sy + l * vy < -1) return false;
        for (int i = 0; i < l; i++) {
            if (map[sy + vy * i][sx + vx * i] != ox) return false;
        }
        return true;
    }

    /*public static boolean checkWin(char ox) {
        if (map[0][0] == ox && map[1][0] == ox && map[2][0] == ox) return true;
        if (map[0][1] == ox && map[1][1] == ox && map[2][1] == ox) return true;
        if (map[0][2] == ox && map[1][2] == ox && map[2][2] == ox) return true;

        if (map[0][0] == ox && map[0][1] == ox && map[0][2] == ox) return true;
        if (map[1][0] == ox && map[1][1] == ox && map[1][2] == ox) return true;
        if (map[2][0] == ox && map[2][1] == ox && map[2][2] == ox) return true;

        if (map[0][0] == ox && map[1][1] == ox && map[2][2] == ox) return true;
        if (map[2][0] == ox && map[1][1] == ox && map[0][2] == ox) return true;

        return false;
    }*/

    public static boolean isMapFull() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (map[i][j] == '•') return false;
            }
        }
        return true;
    }

    public static void initMap() {
        map = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                map[i][j] = '•';
            }
        }
    }

    public static void showMap() {
        for (int i = 0; i <= FIELD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isCellEmpty(int x, int y) {
        if (x < 0 || x > FIELD_SIZE - 1 || y < 0 || y > FIELD_SIZE - 1) return false;
        return map[x][y] == '•';
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter coordinates x y:");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(y, x));
        map[y][x] = 'x';
    }

    //AI easy
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(FIELD_SIZE);
            y = rand.nextInt(FIELD_SIZE);
        } while (!isCellEmpty(y, x));
        map[y][x] = 'o';
    }

    //AI hard
    public static void aiHardTurn() {
        int x = -1, y = -1;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (isCellEmpty(i, j)) {
                    map[i][j] = 'o';
                    if (checkWin('o')) {
                        x = j;
                        y = i;
                    }
                    map[i][j] = '•';
                }
            }
        }
        if (x == -1 && y == -1) {
            for (int i = 0; i < FIELD_SIZE; i++) {
                for (int j = 0; j < FIELD_SIZE; j++) {
                    if (isCellEmpty(i, j)) {
                        map[i][j] = 'x';
                        if (checkWin('x')) {
                            x = j;
                            y = i;
                        }
                        map[i][j] = '•';
                    }
                }
            }
        }
        if (x == -1 && y == -1) {
            do {
                x = rand.nextInt(FIELD_SIZE);
                y = rand.nextInt(FIELD_SIZE);
            } while (!isCellEmpty(y, x));
        }
        map[y][x] = 'o';
    }
}