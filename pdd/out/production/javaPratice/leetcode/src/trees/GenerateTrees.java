package trees;

import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new LinkedList<>();
        if(start > end) {
            allTrees.add(null);
            return allTrees;
        }
        //枚举可行根节点
        for(int i = start; i <= end; i++){
            //枚举可行的左子树几何
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            //枚举可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            //从左子树集合选出一颗左子树，右子树几何选出一颗右子树，拼接到根节点上
            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        GenerateTrees gt = new GenerateTrees();
        gt.generateTrees(3);
    }
}
