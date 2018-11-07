package academy.softserve.bucketsort;

public class Main {

    public static void main(String[] args) {
        int[] input = new int[]{15, 3, 9, 11, 1, 5, 17, 11};
        Sorter sorter = new Sorter();
        sorter.bucketSort(input);
    }
}
