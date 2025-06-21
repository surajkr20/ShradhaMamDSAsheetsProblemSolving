
// Given a string s, the task is to identify all characters that appear more than once and print each as a list containing the character and its count. = // https://www.geeksforgeeks.org/dsa/print-all-the-duplicates-in-the-input-string/#approach-1-using-sorting-onlogn-time-and-o1-space-1

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesCharacters {
    // approach.1 = using sorting - t.c o(n*log n) and s.c - o(1)
    public static void printDuplicates(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        // Traverse the sorted string to count duplicates
        for (int i = 0; i < arr.length;) {

            int count = 1;

            // Count occurrences of current character
            while (i + count < arr.length && arr[i] == arr[i + count]) {
                count++;
            }

            // If count > 1, print the character and its count
            if (count > 1) {
                System.out.print("['" + arr[i] + "', " + count + "], ");
            }

            // Move to the next different character
            i += count;
        }
    }

    // approach.2 = using hashing - t.c o(n) and s.c o(k)
    public static void printDuplicates02(String s) {

        // Hash map to store frequency of each character
        HashMap<Character, Integer> freq = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Traverse the map and print characters with count > 1
        for (Map.Entry<Character, Integer> it : freq.entrySet()) {
            if (it.getValue() > 1) {
                System.out.print("['" + it.getKey() + "', " + it.getValue() + "], ");
            }
        }
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        printDuplicates(s);
    }
}
