package com.hadisj.crackinginterview.arraysandstrings;

/**
 * Created by admin on 9/26/17.
 */

public class TicTacToe {

   public static final String O_WINS = "O_WINS";
    public static final String X_WINS = "X_WINS";
    public static final String INCOMPLETE = "INCOMPLETE";
    public static final String DRAW = "DRAW";

    private int[][] board;

    public void setupBoard(int width) {
        board = new int[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = -1;
            }
        }
    }

//    public String evaluateBoard() {
//        String result = TicTacToe.DRAW;
//
//        boolean xHorizLine = false;
//        boolean oHorizLine = false;
//        boolean xVertLine = false;
//        boolean oVertLine = false;
//        boolean xNWline = false;
//        boolean xSEline = false;
//        boolean oNWline = false;
//        boolean oSEline = false;
//
//        int lastValHoriz = -2;
//        int lastValVert = -2;
//        int lastValNW = -2;
//        int lastValSE = -2;
//        int lastVal = -2;
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                //check horizontal
//                if (i > 0) {
//                    if (lastValHoriz != -2 && i == board.length - 1 &&
//                            board[i][j] == board[i-1][j]) {
//                        if (board[i][j] == 0)
//                            result = TicTacToe.X_WINS;
//                        else
//                            result = TicTacToe.O_WINS;
//                        break;
//                    } else if (board[i][j] == board[i-1][j]) {
//                        lastValHoriz = board[i][j];
//                    } else {
//                        lastValHoriz = -2;
//                        break;
//                    }
//                } else {
//                    lastValHoriz = board[i][j];
//                }
//
//                if (j > 0) {
//                    if (lastValVert != -2 && j == board.length - 1 &&
//                            board[i][j] == board[i][j-1]) {
//                        if (board[i][j] == 0)
//                            result = TicTacToe.X_WINS;
//                        else
//                            result = TicTacToe.O_WINS;
//                        break;
//                    } else if (board[i][j] == board[i-1][j]) {
//                        lastValHoriz = board[i][j];
//                    }
//                } else {
//                    lastValHoriz = board[i][j];
//                }
//
//                //check vertical
//            }
//        }
//    }
//
//    public String evaluateBoard2() {
//        String result = TicTacToe.INCOMPLETE;
//        int lastValHoriz = -2;
//        int lastValVert = -2;
//        boolean isDrawPossible = true;
//
//
//        for (int i = 0; i < board.length; i++) {
//            lastValVert = -1;
//            for (int j = 0; j < board.length; j++) {
//                //break loop if a X or O isn't found
//                if (board[i][j] == -1) {
//                    //if at least one square is neither an X or O, then you can't have a draw
//                    isDrawPossible = false;
//                    break;
//                }
//
//                if (j == 0) {
//                    lastValVert = board[i][j];
//                } else {
//                    if (board[i][j] != lastValVert)
//                        break;
//                    else if (board[i][j] != lastValVert && j != board.length - 1)
//                        lastValVert = board[i][j];
//                    else {
//                        //found winning vertical line
//                        if (board[i][j] == '0') {
//                            result = TicTacToe.X_WINS;
//                            break;
//                        } else {
//                            result = TicTacToe.O_WINS;
//                            break;
//                        }
//
//                    }
//                }
//
//                lastValHoriz = -1;
//                //break loop if a X or O isn't found
//                if (board[j][i] == -1) {
//                    //if at least one square is neither an X or O, then you can't have a draw
//                    isDrawPossible = false;
//                    break;
//                }
//
//                if (i == 0) {
//                    lastValHoriz = board[j][i];
//                } else {
//                    if (board[j][i] != lastValHoriz)
//                        break;
//                    else if (board[j][i] != lastValHoriz && j != board.length - 1)
//                        lastValHoriz = board[j][i];
//                    else {
//                        //found winning vertical line
//                        if (board[j][i] == '0') {
//                            result = TicTacToe.X_WINS;
//                            break;
//                        } else {
//                            result = TicTacToe.O_WINS;
//                            break;
//                        }
//                    }
//                }
//            }
//
//
//            // check diagonals
//            int lastValSE = -1;
//            int lastValNE = -1;
//            for (int k = board.length - 1; k >= 0; k--) {
//                //break loop if a X or O isn't found
//                if (board[i][k] == -1) {
//                    //if at least one square is neither an X or O, then you can't have a draw
//                    isDrawPossible = false;
//                    break;
//                }
//
//                if (i == 0) {
//                    lastValNE = board[i][k];
//                } else {
//                    if (board[i][k] != lastValNE)
//                        break;
//                    else if (board[i][k] != lastValSE && k != board.length - 1)
//                        lastValNE = board[i][k];
//                    else {
//                        //found winning vertical line
//                        if (board[i][k] == '0') {
//                            result = TicTacToe.X_WINS;
//                            break;
//                        } else {
//                            result = TicTacToe.O_WINS;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//
//        return result;
//    }
}
