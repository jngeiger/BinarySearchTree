public class Main {
    public static void main(String[] args) {
        var b1 = new BinaryNode<Integer>(1);
        var b2 = new BinaryNode<Integer>(2);
        var b3 = new BinaryNode<Integer>(3);
        var b4 = new BinaryNode<Integer>(4);
        var b5 = new BinaryNode<Integer>(5);
        var b6 = new BinaryNode<Integer>(6);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(b6);
        tree.insert(18);
        tree.insert(15);
        tree.insert(13);
        tree.insert(14);
        tree.insert(4);
        tree.insert(3);
        tree.insert(5);
        tree.insert(18);
        tree.insert(14);
        tree.insert(14);
        tree.insert(18);
        tree.insert(25);
        tree.insert(20);
        tree.insert(14);
        tree.insert(18);


        System.out.println(tree);
        tree.deleteIteratively(3);
        System.out.println(tree);



    }
}
