import java.util.ArrayList;

public class PiTree {
    public TreeNode<Integer> generateTree()
    {
        TreeNode<Integer> root = new TreeNode<Integer>(3);
        Integer[] array = {1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8,3,2,7,9,5,0,2,8,8,4,1,9,7,1,6,9,3,9,9,3,7,5,1,0};
        int idx = 0;
        ArrayList<TreeNode<Integer>> queue = new ArrayList<TreeNode<Integer>>();
        queue.add(root);

        while (queue.size() != 0 && idx < 50)
        {
            TreeNode<Integer> currentValue = queue.remove(0);
            for (int i = 0; i < currentValue.getValue(); i++)
            {
                if (idx >= 50)
                    break;
                TreeNode<Integer> node = new TreeNode<Integer>(array[idx++]);
                queue.add(node);
                currentValue.add(node);
            }
        }
        return root;
    }
}
