# 🔢 Sorting Algorithms Explorer — Java CLI

An interactive command-line tool that implements and benchmarks **5 classic sorting algorithms** from scratch.

## 🧮 Algorithms Implemented

| Algorithm | Best | Average | Worst | Space | Notes |
|-----------|------|---------|-------|-------|-------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Simple, slow |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | Few swaps |
| Insertion Sort | **O(n)** | O(n²) | O(n²) | O(1) | Great for small/nearly-sorted |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Stable, consistent |
| Quick Sort | O(n log n) | **O(n log n)** | O(n²) | O(log n) | Fastest in practice |

## ▶️ How to Run

```bash
git clone https://github.com/YOUR_USERNAME/java-sorting-cli.git
cd java-sorting-cli

# Compile all files
javac -d out src/main/java/com/example/sorting/**/*.java

# Run the interactive CLI
java -cp out com.example.sorting.cli.SortingCLI
```

## 🎮 Demo
```
╔══════════════════════════════════════╗
║      Sorting Algorithms Explorer     ║
╚══════════════════════════════════════╝

Choose an option:
  1. Sort a custom array
  2. Run benchmark (compare all algorithms)
  3. Exit

📊 Benchmark [random array, size=5,000]
────────────────────────────────────────────────────
Bubble Sort        | size=5000   |  82,341 µs
Selection Sort     | size=5000   |  45,123 µs
Insertion Sort     | size=5000   |  18,209 µs
Merge Sort         | size=5000   |   1,203 µs
Quick Sort         | size=5000   |     891 µs
```

## 📚 What I Learned
- Divide and conquer (merge sort, quick sort)
- In-place vs auxiliary space trade-offs
- Why O(n log n) is so much faster than O(n²) for large inputs
- Benchmarking with `System.nanoTime()`
