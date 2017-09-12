package searchProblems;

import java.util.ArrayList;

/**
 * Given a digit string excluded 01, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters is given just like on the telephone buttons.
 * 
 * Example
 * Given "23"
 * Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */

public class LetterCombinationsOfAPhoneNumber {
	
	ArrayList<String> ans = new ArrayList<>();
	
	public ArrayList<String> letterCombinations(String digits) {
		String phone[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		if (digits.length() == 0) {
			return ans;
		}
		
		dfs(0, digits.length(), "", digits, phone);
		
		return ans;
	}
	
	private void dfs(int x, int l, String str, String digits, String phone[]) {
		if (x == l) {
			ans.add(str);
			return;
		}
		
		int d = digits.charAt(x) - '0';
		for (char c : phone[d].toCharArray()) {
			dfs(x + 1, l, str + c, digits, phone);
		}
	}
}
