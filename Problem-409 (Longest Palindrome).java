// 409. Longest Palindrome

// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
// This is case sensitive, for example "Aa" is not considered a palindrome here.

// Note:
// Assume the length of given string will not exceed 1,010.

// Example:
// Input:
// "abccccdd"

// Output:
// 7

// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.

// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        boolean oddFound = false;
        int result = 0;
        
        for(char c: s.toCharArray()){
            counts.put(c, counts.getOrDefault(c,0)+1);
        }
        
        for(int c: counts.values()){
            if(c%2==0)
                result+=c;
            else{
                oddFound=true;
                result+=c-1;
            }
        }
        if(oddFound==true)
            result = result+1;
        return result;
    }
}