package DailyChallanges.Easy;

// leetcode.ques.3442. Maximum Difference Between Even and Odd Frequency I = https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MaxDiffEvenOddFreqI {
    public static int maxDifference(String s) {
      HashMap<Character, Integer> freqMap = new HashMap<>();
      for(char ch : s.toCharArray()){
        freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
      }

      List<Integer> oddFreqs = new ArrayList<>();
      List<Integer> evenFreqs = new ArrayList<>();

      for(int val: freqMap.values()){
        if(val % 2 == 0){
            evenFreqs.add(val);
        }else{
            oddFreqs.add(val);
        }
      }

      if(oddFreqs.isEmpty() || evenFreqs.isEmpty()){
        return 0;
      }

      int MaxFreq = Collections.max(oddFreqs);
      int minFreq = Collections.min(evenFreqs);

       return MaxFreq - minFreq;
    }
    public static void main(String[] args) {
        String s = "aaaaabbc";
        System.out.println(maxDifference(s));
    }
}
