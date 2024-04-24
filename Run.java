package Tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ans;
        do {
            System.out.println("Welcome to Tic-Tac-Toe");
            System.out.println();
            System.out.println("--------------------------");
            System.out.println();
            Board.printBoard();
            System.out.println("You'll fill up the number in the table with X and O, now let's jump into the game👌👌");
            System.out.println();
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            System.out.println("Hi " + name + ", choose X or O:");
            String type = scanner.next().toUpperCase();
            while (!type.equals("X") && !type.equals("O")) {
                System.out.println("Invalid input, please enter X or O:");
                type = scanner.next().toUpperCase();
            }

            Player player = new Player(type, name);
            Player computer = new Player(type.equals("X") ? "O" : "X");
            Player current = player;

            while (true) {
                System.out.println(current.getName() + "'s turn:");
                // User's turn
                if (current == player) {
                    try {
                        System.out.println("Enter a position:");
                        int position = scanner.nextInt();
                        if (!checkValid(position)) {
                            continue;
                        }
                        if (!Board.updateBoard(type, position)) {
                            continue;
                        }
                        Board.printBoard();
                        if (Board.checkWinner()) {
                            System.out.println("Congratulations, You won!!");
                            break;
                        }
                        if (Board.checkDraw()) {
                            System.out.println("DRAW");
                            break;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, enter again!");
                        scanner.next();
                        continue;
                    }
                }
                // Computer's turn
                else {
                    int computerMove;
                    do {
                        computerMove = getComputerMove();
                    } while (!Board.updateBoard(current.getType(), computerMove));
                    Board.printBoard();
                    System.out.println("Computer has chosen position " + computerMove);
                    if (Board.checkWinner()) {
                        System.out.println("Sorry, you lose!!");
                        break;
                    }
                    if (Board.checkDraw()) {
                        System.out.println("DRAW");
                        break;
                    }
                }

                if (current == player) {
                    current = computer;
                } else {
                    current = player;
                }
            }

            System.out.println("Do you want to play again (Y/N):");
            ans = scanner.next();

        } while (ans.equalsIgnoreCase("Y"));

        scanner.close();
    }

    static private int getComputerMove() {
        return 1 + (int) (Math.random() * 9);
    }

    static private boolean checkValid(int position) {
        if (position < 1 || position > 9) {
            System.out.println("Invalid input, enter again!");
            return false;
        }
        return true;
    }
}
