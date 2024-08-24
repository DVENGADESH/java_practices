// This is an example program of 2d array. getting an input from the user.

import java.util.Scanner;

class HelloWorld {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int arr[][]= new int[4][4];
        
        //input
        
        for(int row=0; row<arr.length; row++){

            for(int col=0; col<arr[row].length; col++){
                System.out.print("Enter rows and coloumns:");
                arr[row][col]= sc.nextInt();
            }
        }

        //output

         for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[row].length; col++){
               System.out.print(arr[row][col]+" ");
            }System.out.println("");
        }
    }
}