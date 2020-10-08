package ru.mirea.aod_practice10;

public class Tester {

    public static void main(String[] args) {
        Tree tree=new Tree();
        for(int i =0;i<20;i++){
            tree.insert((int) (Math.random() * 100));
        }
        tree.insert(15);
        tree.printTree(tree.getRoot());
        System.out.println();
        System.out.println(tree.find(15).iData);
        tree.delete(15);
        System.out.println();
        tree.printTree(tree.getRoot());
    }
}
