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
    static int ans = 0;
    static int count=0;
    static int Sum(TreeNode root){
        if(root==null) return 0;
        count++;
        int left = Sum(root.left);
        int right = Sum(root.right);
        return root.val + left +right;  
    }
    static void helper(TreeNode root){
        if(root==null) return;
        count=0;
        int sum = Sum(root);
        int avg = sum/count;
        if(avg==root.val) ans++;
        helper(root.left);
        helper(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        ans=0;
        helper(root);
        return ans ;
    }
}