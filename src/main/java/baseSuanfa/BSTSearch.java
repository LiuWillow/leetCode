//package baseSuanfa;
//
///**
// * @author liuweilong
// * @description
// * @date 2019/4/28 17:42 二叉查找树
// */
//public class BSTSearch {
//    private Node head;
//
//    private class Node{
//        Node left;
//        Node right;
//        int value;
//        int index;
//        Node(int value, int index){
//            this.value = value;
//            this.index = index;
//        }
//    }
//
//    public int locate(int value){
//        return 0;
//    }
//
//    /**
//     * 返回添加后的下标
//     * @param value
//     * @return
//     */
//    public void add(int value){
//        add(head, value, 1);
//    }
//
//    public void add(Node parent, int value, int parentIndex){
//        if (parent == null){
//            parent = new Node(value, parentIndex);
//            return;
//        }
//        if (value > parent.value){
//            add(parent.right, value, );
//        }
//    }
//
//
//
//}