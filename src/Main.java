import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
     * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
     * 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
     * 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
     */
    static  final int SIZE = 5;
    static  final int SIZEWIN = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static char[][] map;
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            System.out.println("Введите первое значение ячеек");
            humanTurn();
            printMap();
            if(checkWin(DOT_X)) {
                System.out.println("Ты победил");
                break;
            }
            if(isFull()) {
                System.out.println("Ничья");
                break;
            }


            aiTurn();
            printMap();
            if(checkWin(DOT_O)) {
                System.out.println("Компьютер победил");
                break;
            }
            if(isFull()) {
                System.out.println("Ничья");
                break;
            }
        }

    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i =0; i < SIZE; i++) {
            for (int j=0; j <SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i <SIZE; i++){
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j ++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void humanTurn() {
        int x,y;
        do {
            System.out.println("Input X, Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCelValid(y,x));
        map[y][x] = DOT_X;
    }

    public static boolean isCelValid(int y, int x) {
        if (x<0 || y<0 || x >=SIZE || y>=SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }
    public static void aiTurn() {
        int x,y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCelValid(y,x));
        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }

        }
        return true;
    }
    public static boolean checkWin(char c) {

        int score = 0;
        for (int i = 0; i < SIZEWIN; i++) {
            if (map[0][i] == c) {
                score += 1;
            }
        }
        if (score == SIZEWIN) {
            return true;
        } else {
            score = 0;
        }

        for (int i = 0; i < SIZEWIN; i++) {
            if (map[1][i] == c) {
                score += 1;
            }
        }
        if (score == SIZEWIN) {
            return true;
        } else {
            score = 0;
        }
        for (int i = 0; i < SIZEWIN; i++) {
            if (map[2][i] == c) {
                score += 1;
            }
        }


        for (int i = 0; i < SIZEWIN; i++) {
            if (map[i][0] == c) {
                score += 1;
            }
        }
        if (score == SIZEWIN) {
            return true;
        } else {
            score = 0;
        }

        for (int i = 0; i < SIZEWIN; i++) {
            if (map[i][1] == c) {
                score += 1;
            }
        }
        if (score == SIZEWIN) {
            return true;
        } else {
            score = 0;
        }
        for (int i = 0; i < SIZEWIN; i++) {
            if (map[i][2]== c) {
                score += 1;
            }
        }
        if (score == SIZEWIN) {
            return true;
        } else {
            score = 0;
        }

        for (int i = 0; i < SIZEWIN; i++) {
            if (map[i][i]== c) {
                score += 1;
            }
        }
        if (score == SIZEWIN) {
            return true;
        } else {
            score = 0;
        }
        for (int i = 0, j = SIZEWIN-1; i < SIZEWIN && j < SIZEWIN; i++, j --) {
            if (map[i][j]== c) {
                score += 1;
            }
        }
        if (score == SIZEWIN) {
            return true;
        } else {
            score = 0;
        }
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {return true;}
        return false;
    }
}
