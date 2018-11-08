package academy.softserve.bucketsort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SorterTest {

    private Sorter sorter;

    @Before
    public void setUp() {
        sorter = new Sorter();
    }


    @Test
    public void one_number_array() {
        int[] expected = new int[] {1};

        int[] actual = sorter.bucketSort(new int[]{1});

        assertArrayEquals(expected, actual);
    }

    @Test
    public void two_different_numbers_array() {
        int[] expected = new int[] {1, 3};

        int[] actual = sorter.bucketSort(new int[]{3, 1});

        assertArrayEquals(expected, actual);
    }

    @Test
    public void array_with_positive_numbers() {
        int[] expected = new int[] {1, 3, 5, 9, 11, 11, 15, 17};

        int[] actual = sorter.bucketSort(new int[]{15, 3, 9, 11, 1, 5, 17, 11});

        assertArrayEquals(expected, actual);
    }

    @Test
    public void array_with_negative_numbers() {
        int[] expected = new int[] { -17, -15, -11, -11,  -9, -5, -3, -1};

        int[] actual = sorter.bucketSort(new int[]{-15, -3, -9, -11, -1, -5, -17, -11});

        assertArrayEquals(expected, actual);
    }


    @Test
    public void array_with_positive_and_negative_numbers() {
        int[] expected = new int[] {-100, -10, 0, 50, 200};

        int[] actual = sorter.bucketSort(new int[]{200, 0, 50, -10, -100});

        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void array_is_null() {
        int[] actual = sorter.bucketSort(null);
    }

}