import linear_list.LinkList;

/**
 * Created by imliu on 2016/7/7.
 */
public class Driver {

    public static void main(String[] args){
        linkListDriver();
    }

    private static void linkListDriver(){

        /**
         *头结点是至始至终存在，当头结点为null时为空表
         * 前驱结点的存在是为了连接后继结点
         */
        LinkList.Node headNode = new LinkList.Node();
        LinkList.Node preNode = null;

        for(int i = 1; i <= 10; ++i){
            //新建一个结点并赋值给数据域
            LinkList.Node node = new LinkList.Node();
            node.data = i;

            //空表需要先为头结点链接后继结点
            if(headNode.next == null){
                headNode.next = node;
                //对于第一个结点而言头结点即前驱结点
                preNode = headNode;
            }
            //链接后继结点并使得当前结点为下一结点的前驱
            preNode.next = node;
            preNode = node;
        }


        LinkList.Node curNode = headNode;
        for(int i = 0; i < 10; ++i){
            System.out.println(curNode.next.data);
            curNode = curNode.next;
        }
    }
}
