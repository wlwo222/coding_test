package baekjoon.sol_1875;

import java.util.Scanner;

//Problem 1875
public class Main {
    private int[][] board = new int[300][3];
    private int height = 0;
    public static void main(String[] args) {
        Main board = new Main();
        Scanner scanner = new Scanner(System.in);
        int totalRound = scanner.nextInt();

        for (int i = 0; i < totalRound; i++) {
            int block = scanner.nextInt();
            board.placeBlock(block, board.height);
            board.checkHeight(i);
        }
    }

    private void placeBlock(int blockNumber, int height) {
        switch (blockNumber) {
            case 1:
                for (int i : board[height]) {
                    if (i == 0) {
                        board[height][i] = 1;
                        board[height + 1][i] = 1;
                        board[height + 2][i] = 1;
                        board[height + 3][i] = 1;
                        break;
                    }
                }
                break;
            case 2:
                TwoBlock block = new TwoBlock();
                for (int i : board[height]) {
                    if (i == 0) {
                        board[height][i] = 1;
                        board[height + 1][i] = 1;
                        board[height + 2][i] = 1;
                        board[height + 3][i] = 1;
                        break;
                    }
                }
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }
    }

    private void checkHeight(int round) {
        for (int i = 0; i < round + 4; i++) {
            if (board[i] == new int[]{1, 1, 1}) {
                height = i;
            }
        }
    }

    class TwoBlock  {
        int[][] blocks = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 1}};
        
        public void rotate90() {
            blocks = new int[][]{{0, 0, 1}, {1, 1, 1}, {0, 0, 0}, {0, 0, 0}};
        }
        
        public void rotate180() {
            blocks = new int[][]{{0, 1, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 0}};
        }

        public void rotate270() {
            blocks = new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        }
    }

    class ThreeBlock  {
        int[][] blocks = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        
        public void rotate90() {
            blocks = new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        }
        
        public void rotate180() {
            blocks = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 0, 0}, {0, 0, 0}};
        }

        
        public void rotate270() {
            blocks = new int[][]{{0, 1, 0}, {1, 1, 0}, {0, 1, 0}, {0, 0, 0}};
        }
    }

    class FourBlock  {
        int[][] blocks = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}};

        public void rotate90() {
            blocks = new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        }

        public void rotate180() {
            blocks = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 0, 0}, {0, 0, 0}};
        }


        public void rotate270() {
            blocks = new int[][]{{0, 1, 0}, {1, 1, 0}, {0, 1, 0}, {0, 0, 0}};
        }
    }

    class FiveBlock  {
        int[][] blocks = {{1, 1, 0}, {0, 1, 1}, {0, 0, 0}, {0, 0, 0}};

        public void rotate90() {
            blocks = new int[][]{{0, 0, 1}, {0, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        }

        public void rotate180() {
            blocks = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 0, 0}, {0, 0, 0}};
        }
    }

    class SixBlock  {
        int[][] blocks = {{0, 1, 1}, {1, 1, 0}, {0, 0, 0}, {0, 0, 0}};

        public void rotate90() {
            blocks = new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        }

        public void rotate180() {
            blocks = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 0, 0}, {0, 0, 0}};
        }
    }

    class SevenBlock  {
        int[][] blocks = {{1, 1, 0}, {1, 1, 0}, {0, 0, 0}, {0, 0, 0}};
    }
}
