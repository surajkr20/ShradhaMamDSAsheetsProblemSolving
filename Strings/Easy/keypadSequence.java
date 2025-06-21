
// Convert a sentence into its equivalent mobile numeric keypad sequence = https://www.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1

public class keypadSequence {
    public static String printSequence(String S) {
        // code here
        String[] arr = {"2",    "22",  "222", "3",   "33", "333",
                "4",    "44",  "444", "5",   "55", "555",
                "6",    "66",  "666", "7",   "77", "777",
                "7777", "8",   "88",  "888", "9",  "99",
                "999",  "9999"};
        String result = "";
        int n = S.length();
        for(int i=0; i<n; i++){
            if(S.charAt(i) == ' '){
                result = result + "0";
            }else{
                int position = S.charAt(i) - 'A';
                result = result + arr[position];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "GFG";
        System.out.println(printSequence(str));
    }
}
