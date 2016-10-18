
/**
 * Write a description of class TicTacToe here.
 * 
 * @author Jimmy Kajon
 * @version 0.1
 */

import java.util.*;


public class TicTacToe
{
    public static String[] board = new String[9];
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        initBoard();
        System.out.println (drawBoard());
        for (int i = 0; i<9; i++) {
            if (checkWin() != null) {
                System.out.print(checkWin() + " WINS!");
                break;
            } else {
                int posInput = 0;
                System.out.print(getMark(i) + "'s Move:");
                posInput = getInput();
    
                if( Arrays.asList(1,2,3,4,5,6,7,8,9).contains(posInput) ) {
                    try {
                        if( Arrays.asList(1,2,3,4,5,6,7,8,9).contains(Integer.parseInt(board[posInput-1])) ) {
                            board[posInput-1] = getMark(i);
                        } else {
                            i--;
                            System.out.println("input needs to be a number between 1 and 9 inclusive");
                        }
                    } catch (NumberFormatException exception) {
                        i--;
                        System.out.println("can't place in the same place twice");
                    }
                } else {
                    i--;
                    System.out.println("input needs to be a number between 1 and 9 inclusive");
                }
            }
            System.out.println (drawBoard());
            if (i==8) {
                System.out.print("TIE");
            }
        }

    }

    /**
     * updates the board for any changes to the board array
     * @return board as string
     */
    public static String drawBoard() {
        return " " + board[0] + " | " + board[1] + " | " + board[2] + " \n---|---|---\n " + board[3] + " | " + board[4] + " | " + board[5] + " \n---|---|---\n " + board[6] + " | " + board[7] + " | " + board[8] + " ";
    }

    /**
     * sets up the bard with nubers 1-9 inclusive so the 
     * user knows how to chose the place they want to go
     */
    public static void initBoard() {
        for (Integer i = 1; i <= board.length; i++) {
            board[i-1] = i.toString();
        }
    }

    /**
     * returns input from user only if it's an int
     * otherwise, it asks the user for an int
     * @return positon in board array+1 as int
     */

    public static int getInput() {
        int posInput = 0;
        try {
            posInput = input.nextInt();
        }catch(InputMismatchException exception){
            System.out.println("input needs to be a number between 1 and 9 inclusive");
            input.next();
        }
        return posInput;
    }

    /**
     * takes in the number of the turn (starting at 0)
     * and uses it to determin wether X or O goes
     * @return X or O as a string
     */

    public static String getMark(int t) {
        String mark = "X";
        if (t % 2 == 0) {
            mark = "X";
        } else {
            mark = "O";
        }
        return mark;

    }
    
    /**
     * checks if the game has been won
     * @return mark of winner as String, or null
     */
    public static String checkWin() {
        // indexes of board list that need to be the same to win
        int[][] winCombos = new int [][] { { 0, 1, 2 },
                                           { 3, 4, 5 },
                                           { 6, 7, 8 },
                                           { 0, 3, 6 },
                                           { 1, 4, 7 },
                                           { 2, 5, 8 },
                                           { 0, 4, 8 },
                                           { 2, 4, 6 } };
                                           
        // go through each combination of win indexes and check if their values match
        for (int i=0; i < winCombos.length; i++) {
            if (board[ winCombos[i][0] ] == board[ winCombos[i][1] ] && board[ winCombos[i][1] ] == board[ winCombos[i][2] ]) {
                return board[ winCombos[i][0] ];
            }
        }
        return null;
    }
    
    
    

    
    
    
    
    
    
    
}
