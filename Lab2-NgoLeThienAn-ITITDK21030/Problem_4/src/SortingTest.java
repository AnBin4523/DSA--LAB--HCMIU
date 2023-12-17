import java.util.Random;

public class SortingTest {
    // random array
    public static int[] generateRandomArr(int size) {
        int[] arr = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

    // bubble sort
    public static long bubbleSort(int[] arr) {
        int n = arr.length;
        long comparisonCount = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisonCount++; // Increment comparisons
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return comparisonCount;
    }

    // select sort
    public static long selectionSort(int[] arr) {
        int n = arr.length;
        long comparisonCount = 0;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisonCount++; // Increment comparisons
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return comparisonCount;
    }

    // insert sort
    public static long insertionSort(int[] arr) {
        int n = arr.length;
        long comparisonCount = 0;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparisonCount++; // Increment comparisons
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return comparisonCount;
    }
    public static void main(String[] args) throws Exception {
        int[] arrSize = {
            10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000
        };

        System.out.println("\t\t\tCOPIES/COMPARISONS/SWAPS\n");
        System.out.println("Size\t\tBubble Sort\t\tSelection Sort\t\tInsertionSort");

        for (int size : arrSize) {
            int[] arr = generateRandomArr(size);
            int[] bubbleSortArr = arr.clone();
            int[] selectSortArr = arr.clone();
            int[] insertSortArr = arr.clone();

            long bubbleSortComparison = bubbleSort(bubbleSortArr);
            long selectSortComparison = selectionSort(selectSortArr);
            long insertSortComparison = insertionSort(insertSortArr);

            System.out.println("\n" + size + "\t\t" + bubbleSortComparison + "\t\t" + selectSortComparison + "\t\t" + insertSortComparison);
        }
    }
}
