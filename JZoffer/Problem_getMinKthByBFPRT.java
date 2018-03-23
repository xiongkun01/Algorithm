
import java.util.Random;

public class Problem_getMinKthByBFPRT {

    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);
        printArray(arr);
        int[] kthArr = getMinKNumsByHeap(arr, 5);
        printArray(kthArr);
    }

    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = random.nextInt(100) + 5;
        }
        return res;
    }

    public static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //**************************使用大根堆**********************
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k > arr.length) {
            return arr;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            kHeap[i] = arr[i];
        }
        buildHeap(kHeap);
        for (int j = k; j < arr.length; j++) {
            if (arr[j] < kHeap[0]) {
                kHeap[0] = arr[j];
                adjustHeap(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    public static void buildHeap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, n);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }



    //BFPRT算法----从无序数组中找出第k小的数，时间复杂度为O(N)
    public static int getMinKthByBFPRT(int[] arr, int k) {
        int[] copyArr = new int[arr.length];
        System.arraycopy(arr, 0, copyArr, 0, arr.length);
        return select(copyArr, 0, copyArr.length - 1, k - 1);
    }

    public static int select(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end);
        int[] privotRange = partition(arr, begin, end, pivot);
        if (i >= privotRange[0] && i <= privotRange[1]) {
            return arr[i];
        } else if (i < privotRange[0]) {
            return select(arr, begin, privotRange[0] - 1, i);
        } else {
            return select(arr, privotRange[1] + 1, end, i);
        }
    }

    public static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return select(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    public static int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }

    public static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i < end + 1; i++) {
            int temp = arr[i];
            for (int j = i - 1; j > begin; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        while (begin < end) {
            while (begin < end && arr[end] >= pivotValue) {
                end--;
            }
            arr[begin] = arr[end];
            while (begin < end && arr[begin] <= pivotValue) {
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = pivotValue;
        int[] range = new int[2];
        range[0] = begin - 1;
        range[1] = begin + 1;
        return range;
    }

}