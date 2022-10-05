package by.internship.han.task3_2_6;

public class Main {

    public static void main(String[] args) {
        System.out.println(getBST().recursiveHeight());
    }

    private static BST<Integer, String> getBST() {
        BST<Integer, String> bst = new BST();
        bst.put(0, "a");
        bst.put(1, "b");
        bst.put(2, "c");
        bst.put(3, "d");
        return bst;
    }
}
