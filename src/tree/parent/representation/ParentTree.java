package tree.parent.representation;

import tree.Tree;

import java.util.Arrays;

/**
 * Created by Ken on 2017/1/25.
 */
public class ParentTree<T> implements Tree<T>{

    //结点数组
    private PTNode[] nodes;
    //根结点在数组中的位置
    private int rootPos = -1;
    //节点数
    private int nodeAmount = 0;

    public ParentTree(int treeSize){
        nodes = new PTNode[treeSize];
    }

    @Override
    public void clearTree() {
        for(int i = 0; i < nodeAmount; i++){
            nodes[i] = null;
        }
        rootPos = -1;
        nodeAmount = 0;
    }

    @Override
    public boolean treeEmpty() {
        return nodeAmount == 0 ? true : false;
    }

    @Override
    public Node root() {
        if(nodeAmount != 0){
            return nodes[0];
        }
        return null;
    }

    @Override
    public T value(Node node) {
        return (T) node.getData();
    }

    @Override
    public void assign(Node node, T value) {
        node.setData(value);
    }

    @Override
    public Node parent(Node node) {
        PTNode ptNode = (PTNode) node;
        if(ptNode.getParentPos() != -1){
            return nodes[ptNode.getParentPos()];
        }
        return null;
    }

    @Override
    public Node leftChild(Node node) {
        PTNode ptNode = (PTNode) node;
        //遍历所有结点找到此结点的数组下标
        Integer index = null;
        for (int i = 0; i < nodes.length; i++){
            if(ptNode == nodes[i]){
                index = i;
                break;
            }
        }
        if(index == null){
            throw new RuntimeException("结点不属于此树");
        }
        //遍历每一个结点找到此结点的所有孩子结点，下标最小的就是最左孩子
        Integer leftIndex = Integer.MAX_VALUE;
        for(int i = 0; i < nodeAmount; i++){
            PTNode nd = nodes[i];
            if(nd.getParentPos() == index){
                leftIndex = i < leftIndex ? i : leftIndex;
            }
        }
        return leftIndex == Integer.MAX_VALUE ? null : nodes[leftIndex];
    }

    @Override
    public Node rightChild(Node node) {
        PTNode ptNode = (PTNode) node;
        //遍历所有结点找到此结点的数组下标
        Integer index = null;
        for (int i = 0; i < nodes.length; i++){
            if(ptNode == nodes[i]){
                index = i;
                break;
            }
        }
        if(index == null){
            throw new RuntimeException("结点不属于此树");
        }
        //遍历每一个结点找到此结点的所有孩子结点，下标最小的就是最左孩子
        Integer rightIndex = Integer.MIN_VALUE;
        for(int i = 0; i < nodeAmount; i++){
            PTNode nd = nodes[i];
            if(nd.getParentPos() == index){
                rightIndex = i > rightIndex ? i : rightIndex;
            }
        }
        return rightIndex == Integer.MIN_VALUE ? null : nodes[rightIndex];
    }

    /**
     * 遍历每一个结点，不断向上寻找双亲结点每找到一个就+1，取最大值为树的深度
     * @return
     */
    @Override
    public int treeDepth() {
        //树中结点的最大层次为树的深度
        int maxDepth = 0;
        for(int i = 0; i < nodeAmount; i++){
            PTNode node = nodes[i];
            int depth = 1;
            //未抵达根节点时循环
            while(node.parentPos != -1){
                node = nodes[node.parentPos];
                depth++;
            }
            //取最大值为树的度
            maxDepth = depth > maxDepth ? depth : maxDepth;
        }
        return maxDepth;
    }

    /**
     * 添加一个结点
     * @param node
     */
    public void addNode(PTNode node){
        if(nodeAmount >= nodes.length){
            throw new RuntimeException("结点数组已满");
        }
        nodes[nodeAmount] = node;
        nodeAmount++;
        //第一个结点是根节点，存储在数组首位
        if(nodeAmount == 1){
            rootPos = 0;
        }
    }

    /**
     * 获得一个空的结点
     * @return
     */
    public PTNode getNode(){
        return new PTNode<T>();
    }

    /**
     * 伴随类：结点类型
     * @param <T> 结点数据类型的参数化类型
     */
    class PTNode<T> extends Tree.Node<T>{
        //双亲在数组中的位置
        private int parentPos;

        public int getParentPos() {
            return parentPos;
        }

        public void setParentPos(int parentPos) {
            this.parentPos = parentPos;
        }

        @Override
        public String toString() {
            return "PTNode{" +
                    "data=" + this.getData() +
                    ", parentPos=" + parentPos +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ParentTree{" +
                "nodes=" + Arrays.toString(nodes) +
                ", rootPos=" + rootPos +
                ", nodeAmount=" + nodeAmount +
                '}';
    }
}
