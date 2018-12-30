package myleetcode;

public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3, null, null);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode two = new TreeNode(2, four, null);
        TreeNode one = new TreeNode(1, two, three);
        ConstructStringFromBinaryTree tree = new ConstructStringFromBinaryTree();
        System.out.println(tree.tree2str(one));
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "()";
        } else {
            return createSubstringFromSubtree(t).toString();
        }
    }

    /**
     * The node is non-null.
     */
    private StringBuilder createSubstringFromSubtree(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        if (node.left != null && node.right != null) {
            sb.append('(');
            sb.append(createSubstringFromSubtree(node.left));
            sb.append(')');
            sb.append('(');
            sb.append(createSubstringFromSubtree(node.right));
            sb.append(')');
        } else if (node.left != null) {
            sb.append('(');
            sb.append(createSubstringFromSubtree(node.left));
            sb.append(')');
        } else if (node.right != null) {
            sb.append("()(");
            sb.append(createSubstringFromSubtree(node.right));
            sb.append(')');
        }
        return sb;
    }

    private static final class TreeNode {
        private final int val;
        private final TreeNode left;
        private final TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

}