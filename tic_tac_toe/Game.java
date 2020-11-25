package tic_tac_toe;

import java.util.Scanner;

public class Game {

    public static final String EMPTY_SQUARE = " ";

    public static void main(String[] args) {
        // 1. initialize board and welcome user
        // 2. prompt current player for input
        // 3. If current player is human, prompt for input. Otherwise, have program
        // generate move.
        // 4. display board
        // 5. check if we have winner. If so, display winner. Else, go back to step 2.

        System.out.println("Welcome to Tic Tac Toe!");
        gameLoop();
    }

    public static void gameLoop() {
        // Initialize board state.
        String a1 = EMPTY_SQUARE;
        String a2 = EMPTY_SQUARE;
        String a3 = EMPTY_SQUARE;
        String b1 = EMPTY_SQUARE;
        String b2 = EMPTY_SQUARE;
        String b3 = EMPTY_SQUARE;
        String c1 = EMPTY_SQUARE;
        String c2 = EMPTY_SQUARE;
        String c3 = EMPTY_SQUARE;
        Scanner input = new Scanner(System.in);

        boolean isHumanCurrentPlayer = true;

        while (!isGameOver(a1, a2, a3, b1, b2, b3, c1, c2, c3)) {
            String move = "";
            if (isHumanCurrentPlayer) {
                System.out.println("What is your next move?");
                move = input.nextLine();
            } else {
                move = getComputerMove(a1, a2, a3, b1, b2, b3, c1, c2, c3);
                System.out.println("The computer chose " + move);
            }
            if (move.equals("a1")) {
                if (a1.equals(EMPTY_SQUARE)) {
                    a1 = getCurrentPiece(isHumanCurrentPlayer);
                } else {
                    System.out.println("Invalid Move!");
                    continue;
                }
            } else if (move.equals("a2")) {
                if (a2.equals(EMPTY_SQUARE)) {
                    a2 = getCurrentPiece(isHumanCurrentPlayer);
                } else {
                    System.out.println("Invalid Move!");
                    continue;
                }
            } else if (move.equals("a3")) {
                if (a3.equals(EMPTY_SQUARE)) {
                    a3 = getCurrentPiece(isHumanCurrentPlayer);
                } else {
                    System.out.println("Invalid Move!");
                    continue;
                }
            } else if (move.equals("b1")) {
                if (b1.equals(EMPTY_SQUARE)) {
                    b1 = getCurrentPiece(isHumanCurrentPlayer);
                } else {
                    System.out.println("Invalid Move!");
                    continue;
                }
            } else if (move.equals("b2")) {
                if (b2.equals(EMPTY_SQUARE)) {
                    b2 = getCurrentPiece(isHumanCurrentPlayer);
                } else {
                    System.out.println("Invalid Move!");
                    continue;
                }
            } else if (move.equals("b3")) {
                if (b3.equals(EMPTY_SQUARE)) {
                    b3 = getCurrentPiece(isHumanCurrentPlayer);
                } else {
                    System.out.println("Invalid Move!");
                    continue;
                }
            } else if (move.equals("c1")) {
                if (c1.equals(EMPTY_SQUARE)) {
                    c1 = getCurrentPiece(isHumanCurrentPlayer);
                } else {
                    System.out.println("Invalid Move!");
                    continue;
                }
            } else if (move.equals("c2")) {
                if (c2.equals(EMPTY_SQUARE)) {
                    c2 = getCurrentPiece(isHumanCurrentPlayer);
                } else {
                    System.out.println("Invalid Move!");
                    continue;
                }
            } else if (move.equals("c3")) {
                if (c3.equals(EMPTY_SQUARE)) {
                    c3 = getCurrentPiece(isHumanCurrentPlayer);
                } else {
                    System.out.println("Invalid Move!");
                    continue;
                }
            } else {
                System.out.println("Invalid Move!");
            }

            displayBoard(a1, a2, a3, b1, b2, b3, c1, c2, c3);

            isHumanCurrentPlayer = !isHumanCurrentPlayer;
        }
        if (isHumanCurrentPlayer) {
            // Note that the other player won, not the current player!
            System.out.println("The computer won!");
        } else {
            System.out.println("Congrats on winning!");
        }
    }

    public static String getComputerMove(String a1, String a2, String a3, String b1, String b2, String b3, String c1,
            String c2, String c3) {
        // We have a lot of freedom of what we want to do here. I am doing a very simple
        // algorithm, where I pick the first square that is available, prioritizing
        // center
        // and corner squares. You could also have the program choose a random square,
        // or
        // you can have more complex if statement logic for the program to choose an
        // optimal
        // square!
        if (b2.equals(EMPTY_SQUARE)) {
            return "b2";
        } else if (a1.equals(EMPTY_SQUARE)) {
            return "a1";
        } else if (a3.equals(EMPTY_SQUARE)) {
            return "a3";
        } else if (c1.equals(EMPTY_SQUARE)) {
            return "c1";
        } else if (c3.equals(EMPTY_SQUARE)) {
            return "c3";
        } else if (b1.equals(EMPTY_SQUARE)) {
            return "b1";
        } else if (a2.equals(EMPTY_SQUARE)) {
            return "a2";
        } else if (b3.equals(EMPTY_SQUARE)) {
            return "b3";
        } else {
            return "c2";
        }
    }

    public static boolean isGameOver(String a1, String a2, String a3, String b1, String b2, String b3, String c1,
            String c2, String c3) {
        if (!a1.equals(EMPTY_SQUARE)) {
            if (a1.equals(a2) && a2.equals(a3)) {
                return true;
            } else if (a1.equals(b1) && b1.equals(c1)) {
                return true;
            } else if (a1.equals(b2) && b2.equals(c3)) {
                return true;
            }
        }
        if (!a2.equals(EMPTY_SQUARE)) {
            if (a2.equals(b2) && b2.equals(c2)) {
                return true;
            }
        }
        if (!a3.equals(EMPTY_SQUARE)) {
            if (a3.equals(b2) && b2.equals(c1)) {
                return true;
            } else if (a3.equals(b3) && b3.equals(c3)) {
                return true;
            }
        }
        if (!b1.equals(EMPTY_SQUARE)) {
            if (b1.equals(b2) && b2.equals(b3)) {
                return true;
            }
        }
        if (!c1.equals(EMPTY_SQUARE)) {
            if (c1.equals(c2) && c2.equals(c3)) {
                return true;
            }
        }
        return false;
    }

    public static String getCurrentPiece(boolean isHumanCurrentPlayer) {
        if (isHumanCurrentPlayer) {
            return "X";
        } else {
            return "O";
        }
    }

    public static void displayBoard(String a1, String a2, String a3, String b1, String b2, String b3, String c1,
            String c2, String c3) {
        System.out.println("    a   b   c");
        System.out.println("  _____________");
        System.out.println("1 | " + a1 + " | " + b1 + " | " + c1 + " |");
        System.out.println("2 | " + a2 + " | " + b2 + " | " + c2 + " |");
        System.out.println("3 | " + a3 + " | " + b3 + " | " + c3 + " |");
        System.out.println("  _____________");
    }
}