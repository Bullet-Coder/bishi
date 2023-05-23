package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        int counter = 0;
        public TreeNode createTree(TreeNode root, int[] a, int i){
            if(i < a.length){
                if(a[i] == 0)   root = null;
                else{
                    TreeNode left = new TreeNode();
                    TreeNode right = new TreeNode();
                    root.val = a[i];
                    root.left = createTree(left, a, ++counter);
                    root.right = createTree(right, a, ++counter);
                }
            }
            return root;
        }
    }

    static int counter =0;
    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serial(root);
        return ans;
    }

    public String serial(TreeNode treeNode){
        if(treeNode == null) return "#";
        String serialString = treeNode.val + "," + serial(treeNode.left) + ","
                + serial(treeNode.right);
        map.put(serialString, map.getOrDefault(serialString, 0) + 1);
        if(map.get(serialString) == 2){
            ans.add(treeNode);
        }
        return serialString;
    }

    public static void main(String[] args) {
        FindDuplicateSubtrees fd = new FindDuplicateSubtrees();
        TreeNode root = new TreeNode();
        int[] a = {1,2,4,0,0,0,3,2,4,0,0,0,4,0,0};

        root = root.createTree(root, a, counter);
        fd.findDuplicateSubtrees(root);
    }

}
