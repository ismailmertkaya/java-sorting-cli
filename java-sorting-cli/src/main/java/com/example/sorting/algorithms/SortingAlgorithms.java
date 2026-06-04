package com.example.sorting.algorithms;

import java.util.Arrays;

/**
 * Collection of classic sorting algorithms.
 *
 * Each method takes an int[] array and sorts it in-place (ascending).
 * The original array is NOT modified — a copy is returned.
 */
public class SortingAlgorithms {

    // ─── Bubble Sort ──────────────────────────────────────────────
    // Compares adjacent elements and swaps them if needed.
    // After each pass, the largest element "bubbles up" to the end.
    // Time: O(n²) | Space: O(1)
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
            if (!swapped) break; // already sorted
        }
        return a;
    }

    // ─── Selection Sort ───────────────────────────────────────────
    // Finds the minimum element and places it at the beginning.
    // Repeats for the remaining unsorted portion.
    // Time: O(n²) | Space: O(1)
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

    // ─── Insertion Sort ───────────────────────────────────────────
    // Builds sorted array one element at a time.
    // Like sorting playing cards in your hand.
    // Time: O(n²) avg, O(n) best | Space: O(1)
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

    // ─── Merge Sort ───────────────────────────────────────────────
    // Divide and conquer: split array in half, sort each, merge.
    // Guaranteed O(n log n) always.
    // Time: O(n log n) | Space: O(n)
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

    // ─── Quick Sort ───────────────────────────────────────────────
    // Picks a pivot, partitions array around it, recursively sorts.
    // Fastest in practice for average cases.
    // Time: O(n log n) avg, O(n²) worst | Space: O(log n)
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
        int pivot = a[high]; // Use last element as pivot
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
