
/**
 * Write a description of class TicTacToe here.
 * 
 * @author Jimmy Kajon
 * @version 2.0
 */

import java.util.*;

//worked on standardization: had drawBoard already, converted to getMark, want to see others getInput and main before changing getInput, checkMove is part of getInput and can only be detached messily.
// TODO breaks if input is: 1 2 3 4 5 6 7 8 9. by excluding it or including it

public class TicTacToe2
{
    static String[] board = new String[9];
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        initBoard();
        System.out.println (drawBoard());
        String mark = "O"; // set to opposit of starting player
        
        while (!boardFilled() && !checkWin()) {
            mark = getMark(mark);

            //System.out.print(Arrays.toString(board));
            System.out.println (mark + "'s turn");
            getInput(mark);
            System.out.println(drawBoard());
            
        }
        
        if (checkWin()) {
            System.out.println(mark + " WINS!");
        } else {
            System.out.println("TIE :(");
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

    public static void getInput(String mark) {
        int posInput = 0;
        try {
            posInput = input.nextInt();
        }catch(InputMismatchException exception){
            System.out.println("choose a postion on the board with the corresponding numbers (1 through 9 inclusive)");
            input.next();
            getInput(mark);
        }
        
        if( Arrays.asList(1,2,3,4,5,6,7,8,9).contains(posInput) ) {
            try {
                if( Arrays.asList(1,2,3,4,5,6,7,8,9).contains(Integer.parseInt(board[posInput-1])) ) {
                    board[posInput-1] = mark;
                } else {
                    System.out.println("input needs to be a number between 1 and 9 inclusive // when does this happen? TELL ME!"); // I think this try is useless.  I think it is the same as the try before it.
                    getInput(mark);
                }
            } catch (NumberFormatException exception) {
                System.out.println("can't place in the same place twice");
                getInput(mark);
            }
        } else {
            System.out.println("input needs to be a number between 1 and 9 inclusive");
            getInput(mark);
        }
        
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
    public static boolean checkWin() {
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
                return true;
            }
        }
        return false;
    }
    
    /**
     * checks each item in the board array to see if they are filled with "X" or "O"
     * @return if the board is filled, true
     */
    
    public static boolean boardFilled() {
        int spacesFilled = 0;
        for (int i=0; i<board.length; i++) {
            if (board[i] == "X" || board[i] == "O") {
                spacesFilled++;
            }
        }
        if (spacesFilled == 9) {
            return true;
        }
        return false;
    }
    
    
    
    /**
     * gets the mark of the current player based on the pervious turns mark as a string
     * @return opposit of input "X" or "O"
     */
    public static String getMark(String curentMark) {
        String mark = curentMark;
        if (curentMark == "X") {
            mark =  "O";
        } else if (curentMark == "O") {
            mark =  "X";
        }
        return mark;
    }
    
    
}
