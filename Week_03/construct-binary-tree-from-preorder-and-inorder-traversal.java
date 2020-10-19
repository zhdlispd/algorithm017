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

 //too slow o(n^2)
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
        
//         if(preorder.length==0 || inorder.length==0)
//             return null;
        
//         TreeNode root = new TreeNode(preorder[0]);
        
//         for(int i=0; i<preorder.length; i++){
            
//             if(preorder[0]==inorder[i]) {
// 				//将前序数组分成左右两半，再将中序数组分成左右两半
// 				//之后递归的处理前序数组的左边部分和中序数组的左边部分
// 				//递归处理前序数组右边部分和中序数组右边部分
// 				int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
// 				int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
// 				int[] in_left = Arrays.copyOfRange(inorder,0,i);
// 				int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);
// 				root.left = buildTree(pre_left,in_left);
// 				root.right = buildTree(pre_right,in_right);
// 			}
                        
//         }
        
//         return root;
//     }
// }

class Solution {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    
}

