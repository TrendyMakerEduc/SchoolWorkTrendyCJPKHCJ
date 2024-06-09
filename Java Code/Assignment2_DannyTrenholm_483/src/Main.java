import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int matrixSize = 5;  // Adjust the size if needed
        int[][] matrix1 = new int[matrixSize][matrixSize];
        int[][] matrix2 = new int[matrixSize][matrixSize];
        int[][] result = new int[matrixSize][matrixSize];

        // Initialize matrix1 and matrix2 using Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter values for matrix1 (type 'next' for next matrix):");
        boolean stopInput = false;
        boolean extraStop = false;
        //Start with matrix 1
        if (!stopInput) {
            for (int i = 0; i < matrixSize && !stopInput; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    //Checks for integer value
                    if (scanner.hasNextInt()) {
                        matrix1[i][j] = Integer.parseInt(scanner.next());
                        continue;
                    }
                    //Handles any other input
                    String input = scanner.next();
                    if (input.equalsIgnoreCase("next")) {
                        stopInput = true;
                        break;
                    }else {
                        System.out.println("ERROR, please continue by either choosing 'next' for next matrix or a number for current matrix");
                    }

                }
            }
        }
        //If StopInput is true, initialize matrix 2
        if (stopInput) {
            System.out.println("Enter values for matrix2 (type 'confirm' to stop):");
            for (int i = 0; i < matrixSize && stopInput; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    //Checks for an interger value
                    if (scanner.hasNextInt()) {
                        matrix2[i][j] = Integer.parseInt(scanner.next());
                        continue;
                    }
                    //Handles any other input
                    String input = scanner.next();
                    if (input.equalsIgnoreCase("confirm")) {
                        stopInput = false;
                        extraStop = true;
                        break;
                    } else{
                        System.out.println("Error! Either choose 'confirm' for confirming addition of matrices, or a number for current matrix");
                    }

                }
            }
        }

        if (extraStop) {
            int midRow = matrixSize / 2;
            //Executor service used for adding concurrently
            ExecutorService executor = Executors.newFixedThreadPool(2);

            // Create two threads to add the matrices
            executor.execute(new MatrixAddition(matrix1, matrix2, result, 0, midRow));
            executor.execute(new MatrixAddition(matrix1, matrix2, result, midRow, matrixSize));

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            // The 'result' matrix now contains the sum of the two matrices
            System.out.println("Resultant Matrix:");
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }

        }

        scanner.close();
    }
}

