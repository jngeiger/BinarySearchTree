public class Main {
    public static void main(String[] args) {
        TreeNode<String> beverages = new TreeNode<String>("Beverages");
        TreeNode<String> hot = new TreeNode<String>("Hot");

        TreeNode<String> tea = new TreeNode<String>("Tea");
        TreeNode<String> coffee = new TreeNode<String>("Coffee");
        TreeNode<String> chocolate = new TreeNode<String>("Chocolate");

        TreeNode<String> green = new TreeNode<String>("Green");
        TreeNode<String> black = new TreeNode<String>("Black");
        TreeNode<String> chai = new TreeNode<String>("Chai");


        TreeNode<String> cold = new TreeNode<String>("Cold");

        TreeNode<String> limo = new TreeNode<String>("Limo");
        TreeNode<String> milk = new TreeNode<String>("Milk");

        TreeNode<String> citrone = new TreeNode<String>("Citrone");
        TreeNode<String> orange = new TreeNode<String>("Orange");

        TreeNode<String> sweet = new TreeNode<String>("Sweet");
        TreeNode<String> sour = new TreeNode<String>("Sour");

        beverages.add(hot);
        hot.add(tea);
        hot.add(coffee);
        hot.add(chocolate);
        tea.add(green);
        tea.add(black);
        tea.add(chai);

        beverages.add(cold);
        cold.add(limo);
        cold.add(milk);
        limo.add(citrone);
        limo.add(orange);
        PiTree pi = new PiTree();
        TreeNode<Integer> root = pi.generateTree();
        root.breadthFirstByLevel();
    }
}
