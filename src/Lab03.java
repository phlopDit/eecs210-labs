import java.util.ArrayList;
import java.util.Scanner;

/**
 * Name: Kevin Reilly
 * KUID: 3195250
 * Lab Session: Wednesday 4:30pm
 * Lab Assignment: Lab 3
 * 
 * Class takes two binary Matrices and mulitplies them
 * Collaborators: None
 */
public class Lab03 {
  private static final Scanner in = new Scanner(System.in);
  
  public static void main(String[] args) {
    printBooleanResult(multiplyMatrices(getMatrixA(), getMatrixB()));

  }
  
  /*
   * Prints resulting Matrix to console.
   */
  public static void printBooleanResult(ArrayList<ArrayList<Integer>> matrix) {
    for(int row = 0; row < matrix.size(); row++) {
      for(int col = 0; col < matrix.get(row).size(); col++) {
        System.out.print(matrix.get(row).get(col) + " ");
      }
    System.out.println();
    }
  }
  
  public static ArrayList<ArrayList<Integer>> getMatrixA(){
    System.out.println("Enter Matrix 1: (Leave last row blank to end Matrix)");
    return buildMatrix();
  }
  
  public static ArrayList<ArrayList<Integer>> getMatrixB(){
    System.out.println("Enter Matrix 2: (Leave last row blank to end Matrix)");
    return buildMatrix();
  }
  
  /*
   * Builds a Matrix from user input.
   */
  public static ArrayList<ArrayList<Integer>> buildMatrix() {
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

    while(in.hasNextLine()) {
      String newLine = in.nextLine();
      if(newLine.isBlank()) {
        break;
      }
      String[] numberChars = newLine.trim().split("\\s+");
      ArrayList<Integer> row = new ArrayList<>();
      for(String s : numberChars) {
        row.add(Integer.parseInt(s));
      }
      matrix.add(row);
    }
    return matrix;
  }

  /*
   * Multiplies two Matrices.
   */
  public static ArrayList<ArrayList<Integer>> multiplyMatrices(
      ArrayList<ArrayList<Integer>> matrixA, 
      ArrayList<ArrayList<Integer>> matrixB){
    
    ArrayList<ArrayList<Integer>> matrixC = new ArrayList<>();
    int rowsA = matrixA.size();
    int colsA = matrixA.get(0).size();
    int rowsB = matrixB.get(0).size();

    for(int i = 0; i < rowsA; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      for(int j = 0; j < rowsB; j++) {
        int product = 0;
          for(int k = 0; k < colsA; k++) {
            product += matrixA.get(i).get(k) * matrixB.get(k).get(j);
          }
        if(product > 1) { //Booleanize
          product = 1;
        }
        row.add(product);
      }
      matrixC.add(row);
    }
    
    return matrixC;
  }
}
