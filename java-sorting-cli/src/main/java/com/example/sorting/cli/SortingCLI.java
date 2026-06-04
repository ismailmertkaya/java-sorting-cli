package com.example.sorting.cli;

import com.example.sorting.algorithms.SortingAlgorithms;
import com.example.sorting.benchmark.SortBenchmark;

import java.util.Arrays;
import java.util.Scanner;


public class SortingCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      Sorting Algorithms Explorer     ║");
        System.out.println("╚══════════════════════════════════════╝");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("  1. Sort a custom array");
            System.out.println("  2. Run benchmark (compare all algorithms)");
            System.out.println("  3. Exit");
            System.out.print("\nYour choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> sortCustomArray(scanner);
                case "2" -> runBenchmark();
                case "3" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void sortCustomArray(Scanner scanner) {
        System.out.print("Enter numbers separated by spaces (e.g. 5 3 8 1 9): ");
        String input = scanner.nextLine().trim();

        try {
            int[] arr = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println("\nAlgorithm:");
            System.out.println("  1. Bubble Sort   O(n²)");
            System.out.println("  2. Selection Sort O(n²)");
            System.out.println("  3. Insertion Sort O(n²)");
            System.out.println("  4. Merge Sort     O(n log n)");
            System.out.println("  5. Quick Sort     O(n log n) avg");
            System.out.print("Pick: ");

            String algoChoice = scanner.nextLine().trim();

            int[] sorted = switch (algoChoice) {
                case "1" -> SortingAlgorithms.bubbleSort(arr);
                case "2" -> SortingAlgorithms.selectionSort(arr);
                case "3" -> SortingAlgorithms.insertionSort(arr);
                case "4" -> SortingAlgorithms.mergeSort(arr);
                case "5" -> SortingAlgorithms.quickSort(arr);
                default -> { System.out.println("Invalid."); yield arr; }
            };

            System.out.println("Original: " + Arrays.toString(arr));
            System.out.println("Sorted:   " + Arrays.toString(sorted));

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid integers.");
        }
    }

    static void runBenchmark() {
        System.out.println("\nRunning benchmarks...");
        SortBenchmark.runAll(1_000, "random");
        SortBenchmark.runAll(5_000, "random");
        SortBenchmark.runAll(1_000, "nearly-sorted");
    }
}
