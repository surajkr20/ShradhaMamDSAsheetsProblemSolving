package Array.Easy;

import java.util.Arrays;

public class RepeatMissingNumArr {
    // brute force approach - t.c - o(n*n)
    public static int[] repeatedNumber(final int[] A){
        int n = A.length;
        int repeted = -1;
        int missing = -1;
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(A[j] == i) count++;
            }
            if(count == 2) repeted = i;
            else if(count == 0) missing = i;

            if(missing != -1 && repeted !=-1) break;
        }

        return new int[]{repeted, missing};
    }

    // better approch = t.c - o(n) and space. c - o(1)
    public static int[] repeatedNumber02(final int[] A) {
        int n = A.length;
        int[] hash = new int[n+1];
        
        for(int i=0; i<n; i++){
            hash[A[i]]++;
        }
        
        int repeted = -1;
        int missing = -1;
        
        for(int i=1; i<=n; i++){
            if(hash[i] == 2) repeted = i;
            if(hash[i] == 0) missing = i;
            if(repeted != -1 && missing != -1) break;
        }

        return new int[]{repeted, missing};
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5,3};
        System.out.println(Arrays.toString(repeatedNumber(arr)));
    }
}
