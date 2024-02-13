public class Assignment10 {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        long startTime = System.nanoTime();
        BubbleSort.bubbleSort(arr.clone());
        long endTime = System.nanoTime();
        System.out.println("Time taken by BubbleSort: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        MergeSort.mergeSort(arr.clone(), 0, arr.length-1);
        endTime = System.nanoTime();
        System.out.println("Time taken by MergeSort: " + (endTime - startTime) + " ns");
    }

    static class BubbleSort {
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
        }
    }

    static class MergeSort {
        public static void mergeSort(int[] arr, int l, int r) {
            if (l < r) {
                int m = (l+r)/2;
                mergeSort(arr, l, m);
                mergeSort(arr , m+1, r);
                merge(arr, l, m, r);
            }
        }

        public static void merge(int arr[], int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;

            int L[] = new int [n1];
            int R[] = new int [n2];

            for (int i=0; i<n1; ++i)
                L[i] = arr[l + i];
            for (int j=0; j<n2; ++j)
                R[j] = arr[m + 1+ j];

            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                }
                else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
    }
}