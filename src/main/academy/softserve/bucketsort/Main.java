package academy.softserve.bucketsort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bucket sorting demonstration.");
        System.out.println("Please, enter the integers.");
        System.out.println("Separate them with spaces: ");

        int[] numbers = new int[]{};

        boolean inputIsCorrect = false;
        Scanner scanner = new Scanner(System.in);
        while (!inputIsCorrect) {
            String inputString = scanner.nextLine();
            String[] stringsWithNumbers = inputString.split(" ");
            numbers = new int[stringsWithNumbers.length];
            for (int i = 0; i < stringsWithNumbers.length; i++) {
                try{
                    numbers[i] = Integer.parseInt(stringsWithNumbers[i]);
                    if (i == stringsWithNumbers.length - 1)
                    inputIsCorrect = true;
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect array, please try again");
                }
            }
        }
        scanner.close();

        Sorter sorter = new Sorter();
        int[] result = sorter.bucketSort(numbers);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(result));
    }
}
