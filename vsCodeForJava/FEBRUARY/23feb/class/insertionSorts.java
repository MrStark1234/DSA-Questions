import java.util.Scanner;

class insertionSorts {
    public void insertionSort(int arr[], int n) {
        // code here
        for (int i = 1; i < n; i++) {
            int curNum = arr[i], j = i - 1;

            while (j >= 0 && arr[j] > curNum) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = curNum;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            insertionSorts sorter = new insertionSorts();

            sorter.insertionSort(arr,n);
           

            System.out.println("Sorted array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
    }
}
