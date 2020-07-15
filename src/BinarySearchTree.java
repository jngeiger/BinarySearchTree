public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;
    public BinarySearchTree(BinaryNode<T> value)
    {
        this.root = value;
    }

    public void insert(T value)
    {
        insertRec(value);
    }
    public void insertRec(T value)
    {
        root = _insertRec(value, root);
    }
    private BinaryNode<T> _insertRec(T value, BinaryNode<T> currentNode)
    {
        if (currentNode == null)
            return new BinaryNode<T>(value);
        if (value.compareTo(currentNode.getValue()) < 0)
        {
            currentNode.leftChild = _insertRec(value,currentNode.leftChild);
        }
        else {
            currentNode.rightChild = _insertRec(value,currentNode.rightChild);
        }
        return currentNode;
    }

    public void insertIterative(T value)
    {
        BinaryNode<T> currentNode = root;
        BinaryNode<T> newNode = new BinaryNode<>(value);
        while (true)
        {
            if (value.compareTo(currentNode.getValue()) < 0)
            {
                if (currentNode.leftChild == null)
                {
                    currentNode.leftChild = newNode; return;
                }
                currentNode = currentNode.leftChild;
            }
            else {
                if (currentNode.rightChild == null)
                {
                    currentNode.rightChild = newNode; return;
                }
                currentNode = currentNode.rightChild;
            }
        }
    }

    public Boolean isIn(T value)
    {
        return _isIn(value,root);
    }

    private Boolean _isIn(T value, BinaryNode<T> currentNode)
    {
        if (currentNode == null) return false;
        else if (value.compareTo(currentNode.getValue()) == 0)
            return true;
        else if (value.compareTo(currentNode.getValue()) < 0)
            return _isIn(value,currentNode.leftChild);
        else return _isIn(value,currentNode.rightChild);
    }

    public int amountOfIns(T value)
    {
            return _amountOfIns(value,root);
    }

    private int _amountOfIns(T value, BinaryNode<T> currentNode)
    {
        if (currentNode == null) return 0;
        else if (value.compareTo(currentNode.getValue()) == 0)
            return 1 + _amountOfIns(value,currentNode.rightChild);
        else if (value.compareTo(currentNode.getValue()) < 0)
            return 0 + _amountOfIns(value,currentNode.leftChild);
        else return 0 + _amountOfIns(value,currentNode.rightChild);
    }

    public void delete(T value)
    {
        root = _delete(root,value);

    }
    private BinaryNode<T> _delete(BinaryNode<T> currentNode, T value)
    {
        if (currentNode == null) return null;

        if (value.compareTo(currentNode.getValue()) == 0)
        {
            if ((currentNode.leftChild == null) && (currentNode.rightChild == null)) return null;
            if (currentNode.leftChild == null) return currentNode.rightChild;
            if (currentNode.rightChild == null) return currentNode.leftChild;

            T replacement = _getMinOf(currentNode.rightChild);
            currentNode.setValue(replacement);
            currentNode.rightChild = _delete(currentNode.rightChild, replacement);
        }
        else if (value.compareTo(currentNode.getValue()) < 0) // >
            currentNode.leftChild = _delete(currentNode.leftChild, value);
        else
            currentNode.rightChild = _delete(currentNode.rightChild, value);

        return currentNode;
    }
    public void deleteIteratively(T value)
    {
        BinaryNode<T> currentNode = root;
        BinaryNode<T> parent = root;
        while (currentNode != null && currentNode.getValue().compareTo(value) != 0)
        {
            parent = currentNode;
            if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.leftChild;
            if (value.compareTo(currentNode.getValue()) >= 0 )
                currentNode = currentNode.rightChild;
        }
        if (currentNode == null)
            return;
        else {
            if (currentNode.leftChild == null && currentNode.rightChild == null)
            {
                if (parent.rightChild == currentNode)
                    parent.rightChild = null;
                else if(parent.leftChild == currentNode)
                    parent.leftChild = null;
            }
            else if (currentNode.rightChild == null)
            {
                if (parent.rightChild == currentNode)
                    parent.rightChild = currentNode.leftChild;
                else if (parent.leftChild == currentNode)
                    parent.leftChild = currentNode.leftChild;
            }
            else if(currentNode.leftChild == null)
            {
                if (parent.rightChild == currentNode)
                    parent.rightChild = currentNode.rightChild;
                else if (parent.leftChild == currentNode)
                    parent.leftChild = currentNode.rightChild;
            }
            else {
                T replacement = _getMinOf(currentNode.rightChild);
                delete(replacement);
                currentNode.setValue(replacement);

            }

        }
    }
    private T _getMinOf(BinaryNode<T> currentNode)
    {
        if (currentNode.leftChild == null)
            return currentNode.getValue();
        else {
            return _getMinOf(currentNode.leftChild);
        }
    }
    private void deleteMinNode(BinaryNode<T> currentNode)  //OPTIONAL
    {
        if (currentNode.leftChild.leftChild == null) {
            currentNode.leftChild = currentNode.leftChild.rightChild;
            return;
        }
        else {
            deleteMinNode(currentNode.leftChild);
        }
    }
    public String toString()
    {
        return root.toString();
    }
}
