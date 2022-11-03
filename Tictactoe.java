package tictactoe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tictactoe {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Integer> PLAYER1POSITIONS = new ArrayList<>();
    public static ArrayList<Integer> PLAYER2POSITIONS = new ArrayList<>();
   
    
    public static void main(String[] args) {
        
      System.out.print("WELCOME TO GUILE TIC TAC TOE GAME\n\n");
        char [][] gameBoard = {{'1', '|', '2', '|', '3'},
                               {'-', '+', '-', '+', '-'},
                               {'4', '|', '5', '|', '6'},
                               {'-', '+', '-', '+', '-'},
                               {'7', '|', '8', '|', '9'}};
       
       
        printGameBoard(gameBoard);
       
       
        while(true)
        {
           
            System.out.print("\nPLAYER 1 ENTER YOUR PLACEMENT (1-9):");
            int PLAYER1 = input.nextInt();
            System.out.print("\n\n");
            while(PLAYER1POSITIONS.contains(PLAYER1) || PLAYER2POSITIONS.contains(PLAYER1))
            {
                System.out.println("POSITION TAKEN!!! \nENTER CORRECT POSITION PLAYER 1!\n\n");
                PLAYER1 = input.nextInt();
            }    
           
            placePiece(gameBoard, PLAYER1, "PLAYER 1");
           
            printGameBoard(gameBoard);
           
            String result = CHECKWINNER();
            if(result.length() > 0)
            {
               System.out.print(result);
               break;
            }

            System.out.print("\nPLAYER 2 ENTER YOUR PLACEMENT (1-9):");
            int PLAYER2 = input.nextInt();
            System.out.print("\n\n");
            while(PLAYER1POSITIONS.contains(PLAYER2) || PLAYER2POSITIONS.contains(PLAYER2))
            {
                System.out.println("POSITION TAKEN!!! \nENTER CORRECT POSITION PLAYER 2!!\n\n");
                PLAYER2 = input.nextInt();
            }
           
            placePiece(gameBoard, PLAYER2, "PLAYER 2");

            printGameBoard(gameBoard);
           
               result = CHECKWINNER();
            if(result.length() > 0)
            {
               System.out.print(result);
               break;
            }
           
        }
    }
   
    public static void printGameBoard(char[][] gameBoard)
    {
        for(char[] row : gameBoard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiece(char [][] gameBoard,int pos,String user)
    {
        char symbol = ' ';
       
        if(user.equals("PLAYER 1"))
        {
            symbol = 'X';
            PLAYER1POSITIONS.add(pos);
        }
        else if(user.equals("PLAYER 2"))
        {
            symbol = 'O';
            PLAYER2POSITIONS.add(pos);
        }
       
            switch(pos)
            {
                case 1:
                    gameBoard[0][0] = symbol;
                    break;
                case 2:
                    gameBoard[0][2] = symbol;
                    break;
                case 3:
                    gameBoard[0][4] = symbol;
                    break;
                case 4:
                    gameBoard[2][0] = symbol;
                    break;
                case 5:
                    gameBoard[2][2] = symbol;
                    break;
                case 6:
                    gameBoard[2][4] = symbol;
                    break;
                case 7:
                    gameBoard[4][0] = symbol;
                    break;
                case 8:
                    gameBoard[4][2] = symbol;
                    break;
                case 9:
                    gameBoard[4][4] = symbol;
                    break;
                default:
                    break;
            }
    }
   
    public static String CHECKWINNER()
    {
       
        List TOPROW = Arrays.asList(1, 2, 3);
        List MIDROW = Arrays.asList(4, 5, 6);
        List BOTROW = Arrays.asList(7, 8, 9);
       
        List LEFCOL = Arrays.asList(1, 4, 7);
        List MIDCOL = Arrays.asList(2, 5, 8);
        List RIGCOL = Arrays.asList(3, 6, 9);
       
        List CROSS1 = Arrays.asList(1, 5, 9);
        List CROSS2 = Arrays.asList(7, 5, 3);
       
        List<List> winning = new ArrayList<>();
       
        winning.add(TOPROW); //top row
        winning.add(MIDROW); //middle row
        winning.add(BOTROW); //bottom row
       
        winning.add(LEFCOL); //left collumn
        winning.add(MIDCOL); //middle collumn
        winning.add(RIGCOL); //right collumn
       
        winning.add(CROSS1); //cross 1 O
        winning.add(CROSS2); //cross 2 x
       
        for(List l : winning)
        {
            if(PLAYER1POSITIONS.containsAll(l))
            {
                return "\n\n ( -----> !! PLAYER 1 WIN !! <----- ) \n\n";
                
            
            }
        }      
        {
