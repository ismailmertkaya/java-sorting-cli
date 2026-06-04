package com.example.sorting.benchmark;

import com.example.sorting.algorithms.SortingAlgorithms;

import java.util.Random;
import java.util.function.Function;

/**
 * Benchmarks sorting algorithms by measuring their execution time.
 */
public class SortBenchmark {

    public record BenchmarkResult(String algorithm, int arraySize, long microseconds) {
        @Override
        public String toString() {
            return String.format("%-18s | size=%-6d | %,6d µs", algorithm, arraySize, microseconds);
        }
    }

    /** Generate a random int array of given size */
    public static int[] randomArray(int size) {
        Random rnd = new Random(42); // fixed seed for reproducible results
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rnd.nextInt(10_000);
        return arr;
    }

    /** Generate a nearly-sorted array (best case for insertion sort) */
    public static int[] nearlySortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        // Swap a few random pairs
        Random rnd = new Random(42);
        for (int i = 0; i < size / 20; i++) {
            int a = rnd.nextInt(size);
            int b = rnd.nextInt(size);
            int tmp = arr[a]; arr[a] = arr[b]; arr[b] = tmp;
        }
        return arr;
    }

    /** Measure execution time of a sorting function in microseconds */
    public static BenchmarkResult measure(String name, Function<int[], int[]> sortFn, int[] arr) {
        long start = System.nanoTime();
        sortFn.apply(arr);
        long end = System.nanoTime();
        long micros = (end - start) / 1_000;
        return new BenchmarkResult(name, arr.length, micros);
    }

    /** Run all algorithms on the same dataset and print comparison */
    public static void runAll(int size, String dataType) {
        int[] data = dataType.equals("nearly-sorted") ? nearlySortedArray(size) : randomArray(size);

        System.out.printf("%n📊 Benchmark [%s array, size=%,d]%n", dataType, size);
        System.out.println("─".repeat(52));

        measure("Bubble Sort",    SortingAlgorithms::bubbleSort,    data.clone()).toString().lines().forEach(System.out::println);
        measure("Selection Sort", SortingAlgorithms::selectionSort, data.clone()).toString().lines().forEach(System.out::println);
        measure("Insertion Sort", SortingAlgorithms::insertionSort, data.clone()).toString().lines().forEach(System.out::println);
        measure("Merge Sort",     SortingAlgorithms::mergeSort,     data.clone()).toString().lines().forEach(System.out::println);
        measure("Quick Sort",     SortingAlgorithms::quickSort,     data.clone()).toString().lines().forEach(System.out::println);
    }
}
