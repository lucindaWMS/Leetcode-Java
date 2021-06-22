//L.1275 Find Winner On a Tic Tac Toe Game
//O(n) time O(1) space
class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = 'X';
            } else {
                board[moves[i][0]][moves[i][1]] = 'O';
            }
        }
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    count += 1;
                } else if (board[i][j] == 'O') {
                    count -= 1;
                }
            }
            if (count == 3) {
                return "A"; 
            }
            if (count == -3) {
                return "B";
            }
            count = 0;
        }
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if (board[i][j] == 'X') {
                    count += 1;
                } else if (board[i][j] == 'O') {
                    count -= 1;
                }
            }
            if (count == 3) {
                return "A";
            }
            if (count == -3) {
                return "B";
            }
            count = 0;
        }
        if (board[1][1] == board[0][0] && board[1][1] == board[2][2] || board[1][1] == board[0][2] && board[1][1] == board[2][0]) {
            if (board[1][1] == 'X') {
                return "A";
            }
            if (board[1][1] == 'O') {
                return "B";
            }
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }
}