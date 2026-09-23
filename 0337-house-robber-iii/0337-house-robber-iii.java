/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();
        return help(root, dp);
    }

    private int help(TreeNode curr, HashMap<TreeNode, Integer> dp){
       if(curr == null) return 0;

       if(dp.containsKey(curr) == true){
        return dp.get(curr);
       }

       int take = curr.val;

       if(curr.left != null){
        take += help(curr.left.left, dp) + help(curr.left.right, dp);
       }

       if(curr.right != null){
        take += help(curr.right.left,dp) + help(curr.right.right,dp);
       }

       int notTake = help(curr.left,dp) + help(curr.right,dp);

       int ans =  Math.max(take, notTake);
       dp.put(curr, ans);

       return ans;
    }

}