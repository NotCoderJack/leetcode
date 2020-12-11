//Given a non-negative integer c, decide whether there're two integers a and b s
//uch that a2 + b2 = c. 
//
// 
// Example 1: 
//
// 
//Input: c = 5
//Output: true
//Explanation: 1 * 1 + 2 * 2 = 5
// 
//
// Example 2: 
//
// 
//Input: c = 3
//Output: false
// 
//
// Example 3: 
//
// 
//Input: c = 4
//Output: true
// 
//
// Example 4: 
//
// 
//Input: c = 2
//Output: true
// 
//
// Example 5: 
//
// 
//Input: c = 1
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 157 👎 0

package leetcode.editor.cn;
//Java：Sum of Square Numbers
public class P633SumOfSquareNumbers{
    public static void main(String[] args) {
        Solution solution = new P633SumOfSquareNumbers().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            }
            if (sum > c) {
                right --;
            } else {
                left ++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}