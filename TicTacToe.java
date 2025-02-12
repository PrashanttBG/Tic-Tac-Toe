import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };
        char currentPlayer = 'X';
        boolean gameWon = false;
        Scanner scanner = new Scanner(System.in);
        int steps = 0;

        while (!gameWon) {
            if (steps > 9) {
                System.out.println("The Board is Full! -> No one is Winner");
                printBoard(board);
                return;
            }
            steps++;
            printBoard(board);
            System.out.println("Player " + currentPlayer + ", enter row and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                if (checkWin(board, currentPlayer)) {
                    gameWon = true;
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("This spot is already taken.");
            }
        }
        scanner.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + "|" + board[i][1] + "|" + board[i][2]);
            if (i < 2)
                System.out.println("-----");
        }
        System.out.println();
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }
}
