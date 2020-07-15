import java.util.ArrayList;

public class TreeNode<T> {
    private T value;
    private ArrayList<TreeNode<T>> children;

    public TreeNode(T value)
    {
        this.value = value;
        children = new ArrayList<TreeNode<T>>();
    }
    public T getValue()
    {
        return this.value;
    }
    public void add(TreeNode<T> newNode)
    {
        children.add(newNode);
    }
    public void depthFirst()
    {
        System.out.println(this.value);
        for (int i = 0; i < children.size(); i++)
        {
            children.get(i).depthFirst();
        }
    }
    public void breadthFirst()
    {
        ArrayList<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
        queue.add(this);
        while (queue.size() != 0)
        {
            TreeNode<T> currentNode = queue.remove(0);
            System.out.println(currentNode.getValue());
            for (int i = 0; i < currentNode.children.size(); i++)
            {
                queue.add(currentNode.children.get(i));
            }
        }
    }
    public void breadthFirstByLevel()
    {
        ArrayList<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
        queue.add(this);
        int marker = 1;
        int counter = 0;
        while (queue.size() != 0)
        {
            TreeNode<T> currentValue = queue.remove(0); counter++;
            System.out.print(currentValue.getValue());


                for (int i = 0; i < currentValue.children.size(); i++) {
                    queue.add(currentValue.children.get(i));
                }
            if (counter == marker)
            {
                System.out.println();
                counter = 0;
                marker = queue.size();
            }
        }
    }


}
