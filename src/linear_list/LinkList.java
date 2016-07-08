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

    public static class Node{
        public int data;    //数据域
        public Node next;   //指针域
    }

    //处理空表情况
    private void handleEmptyList(){
        if(headNode.next == null){
            try{
                throw new Exception("空表");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void handleIllegalIndex(String errMsg){
            try{
                throw new IllegalArgumentException(errMsg);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
    }

    public void listInsert(int index, int element){
        handleEmptyList();
        if(index <= 0) {
            handleIllegalIndex("元素不在线性表范围");
        }

        int i = 1;
        Node p = headNode, s = new Node();
        /**
         * 遍历中应该找到插入位置的前一结点
         */
        while (p != null && i < index){
            p = p.next;
            ++i;
        }
        if(p == null || i > index){
            handleIllegalIndex("元素不在线性表范围");
        }
        s.data = element;
        s.next = p.next;
        p.next = s;
    }

    public int getElem(int index){
        handleEmptyList();
        if(index <= 0) {
            handleIllegalIndex("元素不在线性表范围");
        }

        Node curNode = headNode;
        for(int i = 0; i < index; ++i){
            if(curNode.next != null) {
                curNode = curNode.next;
            }else {
                try{
                    throw new IllegalArgumentException("元素不在线性表范围");
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                }
            }
        }
        return curNode.data;
    }

    //建立一个内部类作为结点类型

}
