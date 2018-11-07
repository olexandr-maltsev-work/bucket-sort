package academy.softserve.bucketsort;

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

        for (int number: input) {
            int bucketIndex = (int) ((number - min ) / (max - min + 1.0) * buckets.length);
            buckets[bucketIndex].bucket.add(number);
        }

        for (Bucket bucket: buckets) {
            System.out.println(bucket);
        }
    }
}
