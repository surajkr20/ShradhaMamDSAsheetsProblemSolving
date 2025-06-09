
# leetcode.ques.31. Next Permutation = https://leetcode.com/problems/next-permutation/description/
approachs = optimal >>
    1. Find the Break Point:
    2. Find the Next Greater Element:
    3. Reverse the Suffix:

🧪 Brute-Force Approach:
    1.Generate all permutations of the array.
    2.Sort all permutations.
    3.Find the current permutation, return the next one in the list.
    4.If it is the last permutation, return the first.