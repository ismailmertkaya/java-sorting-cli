package com.example.sorting.algorithms;

import java.util.Arrays;



public class SortingAlgorithms {


    public static int[] bubbleSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
        return a;
    }

    
    public static int[] selectionSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) minIdx = j;
            }
            int temp = a[minIdx];
            a[minIdx] = a[i];
            a[i] = temp;
        }
        return a;
    }


    public static int[] insertionSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

   
    public static int[] mergeSort(int[] arr) {
        int[] a = arr.clone();
        mergeSortRec(a, 0, a.length - 1);
        return a;
    }

    private static void mergeSortRec(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSortRec(a, left, mid);
        mergeSortRec(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(a, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(a, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) a[k++] = leftArr[i++];
            else a[k++] = rightArr[j++];
        }
        while (i < leftArr.length) a[k++] = leftArr[i++];
        while (j < rightArr.length) a[k++] = rightArr[j++];
    }

   
    public static int[] quickSort(int[] arr) {
        int[] a = arr.clone();
        quickSortRec(a, 0, a.length - 1);
        return a;
    }

    private static void quickSortRec(int[] a, int low, int high) {
        if (low >= high) return;
        int pivotIdx = partition(a, low, high);
        quickSortRec(a, low, pivotIdx - 1);
        quickSortRec(a, pivotIdx + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[high]; 
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
            }
        }
        int temp = a[i + 1]; a[i + 1] = a[high]; a[high] = temp;
        return i + 1;
    }
}
