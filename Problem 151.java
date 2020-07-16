// 151. Reverse Words in a String

// Given an input string, reverse the string word by word.

// Example 1:
// Input: "the sky is blue"
// Output: "blue is sky the"

// Example 2:
// Input: "  hello world!  "
// Output: "world! hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.

// Example 3:
// Input: "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 
// Note:
// A word is defined as a sequence of non-space characters.
// Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
// You need to reduce multiple spaces between two words to a single space in the reversed string.

// BRUTE FORCE
class Solution {
	public String reverseWords(String s) {
		int n = s.length();
		int i = 0;
		String res = new String();

		while (i < n) {
			while (i < n && s.charAt(i) == ' ')
				i++;
			if (i >= n)
				break;

			int j = i + 1;
			while (j < n && s.charAt(j) != ' ')
				j++;

			String sub = s.substring(i, j);
			if (res.length() == 0)
				res = res + sub;
			else
				res = sub + " " + res;

			i = j + 1;
		}
		return res;
	}
}


// IN-BUILT METHODS
class Solution {
    public String reverseWords(String s) {
		// trim leading and trailing spaces
        s = s.trim();
		// split string into list of words by 1-space or spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
		// reverse the list
        Collections.reverse(wordList);
		// Join List elements by single space and return
        return String.join(" ",wordList);
    }
}


// Using ARRAY-DEQUE
class Solution {
    public String reverseWords(String s) {
        int left = 0, right =s.length()-1;
        while(left<=right && s.charAt(left)== ' ')++left;
        while(left<=right && s.charAt(right)==' ')--right;
        
        Deque<String> d = new ArrayDeque();
        StringBuilder word = new StringBuilder();
        
        while(left<=right){
            char c = s.charAt(left);
            if(word.length()!=0 && c == ' '){
                d.offerFirst(word.toString());
                word.setLength(0);
            }
            else if(c != ' ')
                    word.append(c);
            left++;
        }
        d.offerFirst(word.toString());
        
        return String.join(" ",d);
    }
}