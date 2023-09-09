package ds.tree;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/3
 * @Version V1.0
 **/
public class BinarySearchTree {
    static class TreeNode {
        public int data;
        public TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode() {
        }
    }


    /**
     * 二叉搜索树的查找
     */
    private TreeNode searchTree(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        if (key < root.data) {
            return searchTree(root.left, key);
        } else {
            return searchTree(root.right, key);
        }
    }

    /**
     * 二叉搜索树的插入
     */
    private TreeNode insert(TreeNode root, int key) {
        //当前节点为空就创建新节点
        if (root == null) {
            return new TreeNode(key);
        }
        //不为空就递归
        if (key < root.data){//小于递归左边
            root.left = insert(root.left,key);//插入到左子树
        }else {
            root.right = insert(root.right,key);//大于等于递归右边插入到右子树
        }
        //插入后返回当前节点
        return root;

    }

    /**
     * 删除节点
     * @param
     */
    private int DeleteNode(TreeNode root ,int key){
        return 0;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode treeNode = tree.insert(null, 4);
        tree.insert(treeNode, 7);
        tree.insert(treeNode, 3);
        tree.insert(treeNode, 4);
        tree.insert(treeNode, 8);

        System.out.println(tree.searchTree(treeNode, 8).data);
    }


}



