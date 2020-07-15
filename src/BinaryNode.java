public class BinaryNode<T> {
    private T payload;
    public BinaryNode<T> leftChild;
    public BinaryNode<T> rightChild;

    public BinaryNode(T value)
    {
        this.payload = value;
    }

    public int getHoehe()
    {
        int left = 0;
        int right = 0;
        if (leftChild != null)
        left = this.leftChild.getHoehe()+1;
        if (rightChild != null)
        right = this.rightChild.getHoehe()+1;
        return left > right ? left:right;
    }

    public String toString()
    {
        return desc(this, "", "", "");
    }
    // Inspired by Knuth
    private String desc(BinaryNode<T> node, String top, String root, String bottom)
    {
        if (node == null) return root + "null\n";

        if ((node.leftChild == null) && (node.rightChild == null))
            return root + node.payload + "\n";

        return desc(node.rightChild,
                top + " ",
                top + "┌──",
                top + "│ ") +
                root + node.payload + "\n" +
                desc(node.leftChild,
                        bottom + "| ",
                        bottom + "└──",
                        bottom + " ");
    }

    public void setValue(T value)
    {
        this.payload = value;
    }

    public T getValue()
    {
        return this.payload;
    }
}
