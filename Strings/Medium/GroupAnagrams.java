package Strings.Medium;

// leetcode.ques.49 > Group Anagrams = https://leetcode.com/problems/group-anagrams/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    // approach.1 = using sorting, t.c and s.c - o(k logn)
    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> angramGroups = new HashMap<>();
        for(String word: strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWords = new String(chars);
            angramGroups.computeIfAbsent(sortedWords, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(angramGroups.values());
    }

    // approach.2 = t.c and s.c - o(n)
    public List<List<String>> groupAnagrams02(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] freq = new int[26];
            for(char c: s.toCharArray()){
                freq[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int count: freq){
                key.append(count).append('#');
            }

            map.computeIfAbsent(key.toString(), x-> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
