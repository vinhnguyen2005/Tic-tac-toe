package Tictactoe;


/*print out the Board
|---|---|---|
| 1 | 2 | 3 |
|-----------|
| 4 | 5 | 6 |
|-----------|
| 7 | 8 | 9 |
|-----------|
*/

public class Board {
    private static int count = 0;
    private static String[] board = new String[9];

    static {
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
    }

    public static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|-----------|");
    }

    public static boolean updateBoard(String type, int position) {
        	if (!board[position - 1].equals(String.valueOf(position))) {
                System.out.println("This position is already filled, please choose another position!");
                return false;
            }
   
        board[position - 1] = type;
        count++;
        return true;
    }
    

    public static boolean checkDraw() {
        return count == 9;
    }

    public static boolean checkWinner() {
        String line;
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
                default:
                    line = "";
                    break;
            }
            if (line.equals("XXX") || line.equals("OOO")) {
                return true;
            }
        }
        return false;
    }
}
