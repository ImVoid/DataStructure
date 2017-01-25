package tree.parent.representation;

import org.junit.Test;
import tree.parent.representation.ParentTree.PTNode;

/**
 * Created by Ken on 2017/1/25.
 */
public class ParentTreeTest {
    @Test
    public void testAddNode(){
        ParentTree<String> parentTree = new ParentTree<>(100);
        ParentTree<String>.PTNode<String> nodeA = parentTree.getNode();
        nodeA.setData("A");
        nodeA.setParentPos(-1);
        parentTree.addNode(nodeA);

        ParentTree<String>.PTNode<String> nodeB = parentTree.getNode();
        nodeB.setData("B");
        nodeB.setParentPos(0);
        parentTree.addNode(nodeB);

        ParentTree<String>.PTNode<String> nodeC = parentTree.getNode();
        nodeC.setData("C");
        nodeC.setParentPos(0);
        parentTree.addNode(nodeC);

        ParentTree<String>.PTNode<String> nodeD = parentTree.getNode();
        nodeD.setData("D");
        nodeD.setParentPos(1);
        parentTree.addNode(nodeD);

//        parentTree.clearTree();


        System.out.println(parentTree.rightChild(nodeA));
    }
}
