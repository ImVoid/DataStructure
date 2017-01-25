package tree;

/**
 * Created by Ken on 2017/1/25.
 */
public interface Tree<T> {
    /**
     * 若树t存在，则将树t清空
     */
    void clearTree();

    /**
     * 判断一棵树是否为空
     * @return 若树为空返回true
     *          否则返回    false
     */
    boolean treeEmpty();

    /**
     * 返回树的深度
     * @return 树的深度数值
     */
    int treeDepth();

    /**
     * 返回树的根节点
     * @return
     */
    Node root();

    /**
     * 返回树中结点node的值
     * @param node
     * @return
     */
    T value(Node node);

    /**
     * 为结点设置值
     * @param node 结点
     * @param value 值
     */
    void assign(Node node, T value);

    /**
     * 若node非根结点则返回其双亲结点，否则返回null
     * @param node
     * @return
     */
    Node parent(Node node);

    /**
     * 若node非叶子结点返回此结点的最左孩子，否则返回null
     * @param node 结点
     * @return 最左孩子
     */
    Node leftChild(Node node);

    /**
     * 若node非叶子结点返回此结点的最右孩子，否则返回null
     * @param node 结点
     * @return 最左孩子
     */
    Node rightChild(Node node);

    /**
     * 树的结点
     * @param <T> 参数化类型由接口传入
     */
    abstract class Node<T>{
        //数据域
        private T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
