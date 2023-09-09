package ds.tree;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/7
 * @Version V1.0
 **/
public class AVLTree {

    static class TreeNode {
        public int data;
        public TreeNode left, right;
        int height;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode() {
        }
    }
}
