package practiseother;

public class Quicksort {
    public void quicksortH(Integer[] nuts, int low, int high,Integer[] bolts) {

        if (low < high) {
            int pivot = H_Partition(nuts, low, high,bolts[high]);
            H_Partition(bolts, low, high, nuts[pivot]);
            quicksortH(nuts, low, pivot-1,bolts);
            quicksortH(nuts, pivot + 1, high,bolts);

        }
    }

    private int H_Partition(Integer[] arr, int low, int high,int pivot) {
        int i = low;
        Integer temp1;
        Integer temp2;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot){
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
            } else if(arr[j] == pivot){
                temp1 = arr[j];
                arr[j] = arr[high];
                arr[high] = temp1;
                j--;
            }
        }
        temp2 = arr[i];
        arr[i] = arr[high];
        arr[high] = temp2;

        // Return the partition index of an array based on the pivot
        // element of other array.
        return i;
    }


    private int L_Partition(Integer[] arr, int low, int high) {

        Integer pivot = arr[high];
        int i = low;

        for (int j = low; j <= high; j++) {
            if (arr[j]<pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    public void quicksortL(Integer[] arr, int low, int high) {

        if (low < high) {
            int partition = L_Partition(arr, low, high);
            quicksortL(arr, low, partition - 1);
            quicksortL(arr, partition + 1, high);

        }
    }

    private void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


}
