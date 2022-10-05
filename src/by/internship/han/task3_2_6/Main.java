package by.internship.han.task3_2_6;

public class Main {

    public static void main(String[] args) {
        System.out.println("Reverse height: " + getBST().recursiveHeight());
        System.out.println("Height: " + getBST().height());
        System.out.println("Size: " + getBST().size());
    }

    private static BST<String, String> getBST() {
        BST<String, String> bst = new BST();
        bst.put("0", "a");
        bst.put("1", "b");
        bst.put("2", "c");
        bst.put("3", "d");
        return bst;
    }
}
