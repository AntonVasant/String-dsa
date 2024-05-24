package game.sudoku;

import java.util.Scanner;




public class Main {
    static int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}

    };
    static final int SIZE  = board.length;
     public static  void main(String a[]){

         Scanner scanner = new Scanner(System.in);
         while(true){
             print();
             System.out.println("Enter the move in the form of row col number");
             String str = scanner.next();
             if (str.equalsIgnoreCase("q"))
                 break;
             if(str.length() != 3){
                 System.out.println("Enter a valid form of move");
             }
             else {
                 int row = Character.getNumericValue(str.charAt(0)-1);
                 int col =  Character.getNumericValue(str.charAt(1)-1);
                 int num =  Character.getNumericValue(str.charAt(2));
                 if(validate(board,row,col,num)){
                     board[row][col] = num;
                 }else System.out.println("enter a valid move");
             }
         }
     }
     private static boolean validate(int[][] board, int row, int col, int num){
         if(row > SIZE || col > SIZE || num > 9 || num <1)
             return false;
         if (board[row][col] != 0)
             return false;
         for (int i =0;i<SIZE;i++){
             if (board[row][i] == num || board[i][col] == num)
                 return false;

         }
       return true;
     }
     private static void print(){
         for (int row=0;row<SIZE;row++){
             if (row != 0 && row%3 == 0)
                 System.out.println("--------------------------");
             for (int col =0;col<SIZE;col++){
                 if (col != 0 && col%3 ==0)
                     System.out.print("|");
                 System.out.print(" "+board[row][col]+" ");
             }
             System.out.println();
         }
     }
}
