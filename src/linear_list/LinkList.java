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

    public int GetElem(int index){

        //处理空表情况
        if(headNode.next == null){
            try{
                throw new Exception("空表");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //处理索引为负数的情况
        if(index <= 0){
            try{
                throw new IllegalArgumentException("元素不在线性表范围");
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
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
    public static class Node{
        public int data;    //数据域
        public Node next;   //指针域
    }
}
