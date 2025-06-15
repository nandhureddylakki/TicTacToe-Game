import java.util.Scanner;

public class TicTacToe {

    static char[] board = new char[9];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    static void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = '-';
        }
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("-------------");
        }
    }

    static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int move;
        boolean gameWon = false;
        boolean boardFull = false;

        while (!gameWon && !boardFull) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (1-9):");
            move = scanner.nextInt() - 1;

            if (move >= 0 && move < 9 && board[move] == '-') {
                board[move] = currentPlayer;
                gameWon = checkWin();
                if (!gameWon) {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
                boardFull = checkBoardFull();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        printBoard();
        if (gameWon) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
        scanner.close();
    }

    static boolean checkWin() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (board[i] != '-' && board[i] == board[i + 1] && board[i] == board[i + 2]) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[i] != '-' && board[i] == board[i + 3] && board[i] == board[i + 6]) {
                return true;
            }
        }
        // Check diagonals
        if (board[0] != '-' && board[0] == board[4] && board[0] == board[8]) {
            return true;
        }
        if (board[2] != '-' && board[2] == board[4] && board[2] == board[6]) {
            return true;
        }
        return false;
    }

    static boolean checkBoardFull() {
        for (char c : board) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }
}