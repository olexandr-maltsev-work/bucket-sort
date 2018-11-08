package academy.softserve.bucketsort;

import java.util.ArrayList;
import java.util.Arrays;

class Sorter {

    void bucketSort(int[] input) {
        if (input.length == 0 || input.length == 1) {
            return;
        }

        int max = input[0];
        int min = input[0];
        for (int i = 1; i < input.length; i++) {
            if (max < input[i]) {
                max = input[i];
            } else if (min > input[i]) {
                min = input[i];
            }
        }

        Bucket[] buckets = new Bucket[input.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int number : input) {
            int bucketIndex = (int) ((number - min) / (max - min + 1.0) * buckets.length);
            buckets[bucketIndex].bucket.add(number);
        }

        for (Bucket bucket : buckets) {
            if (bucket.bucket.size() > 1) {
                bucket.bucket = sortBucket(bucket.bucket);
            }
        }

        int[] result = new int[input.length];
        int resultIndex = 0;
        for (Bucket bucket : buckets) {
            if (bucket.bucket.size() > 0) {
                for (Integer i : bucket.bucket) {
                    result[resultIndex] = i;
                    resultIndex++;
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }

    private ArrayList<Integer> sortBucket(ArrayList<Integer> bucket) {

        for (int i = 1; i < bucket.size(); i++) {
            if (bucket.get(i) < bucket.get(i - 1)) {
                for (int j = i; j > 0; j--) {
                    if (bucket.get(j) < bucket.get(j - 1)) {
                        int temp = bucket.get(j);
                        bucket.set(j, bucket.get(j - 1));
                        bucket.set(j - 1, temp);
                    }
                }
            }
        }
        return bucket;
    }
}
