package linear_list;

/**
 * Created by imliu on 2016/7/7.
 * 线性表链式存储及其操作
 */
public class LinkList {

    public Node headNode;   //头结点

    public LinkList(){
        headNode = new Node();
    }

    //建立一个内部类作为结点类型
    public static class Node{
        public int data;    //数据域
        public Node next;   //指针域
    }
}
