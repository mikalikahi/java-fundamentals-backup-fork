package labs_examples.arrays.labs;

/**
 *  2D Array
 *
 *      Creat and populate a 5x5 2D array with multiples of 3, starting with 3. Once populated, print out the results.
 *
 *      The output should look something like this:
 *
 *      3 6 9 12 15
 *      18 21 24 27 30
 *      ...
 *      ...
 *      ...
 *
 */

public class Exercise_03 {

    public static void main(String[] args) {
        int[][] TwoDArray = new int[5][5];
        System.out.println(TwoDArray.length);

        System.out.println("------------------------------------------------------");
        System.out.println("This is a matrix with multiples of 3, starting with 3:");
        System.out.println("------------------------------------------------------");
        int multOfThree = 1;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                TwoDArray[i -1][j -1] = multOfThree * 3;
                System.out.print(TwoDArray[i -1][j -1] + " |");
                multOfThree++;
            }

            System.out.println("");
        }
        System.out.println("----------------------------------------------------");
    }
}
