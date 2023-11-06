package ylp.algorithm.course.algorithmcourse.data.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CompareBinaryTreeTest {

    @Test
    void compare_different_Tree() {
        // Given
        BinaryNode<Integer> root = new BinaryNode<>(1);

        BinaryNode<Integer> node1 = new BinaryNode<>(2);
        BinaryNode<Integer> node2 = new BinaryNode<>(3);
        BinaryNode<Integer> node3 = new BinaryNode<>(2);
        BinaryNode<Integer> node4 = new BinaryNode<>(3);
        BinaryNode<Integer> node5 = new BinaryNode<>(4);
        BinaryNode<Integer> node6 = new BinaryNode<>(5);

        root.setRight(node1);
        root.setLeft(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);

        BinaryNode<Integer> root2 = new BinaryNode<>(1);

        BinaryNode<Integer> node1ForRoot2 = new BinaryNode<>(2);
        BinaryNode<Integer> node2ForRoot2 = new BinaryNode<>(3);
        BinaryNode<Integer> node3ForRoot2 = new BinaryNode<>(2);
        BinaryNode<Integer> node4ForRoot2 = new BinaryNode<>(3);
        BinaryNode<Integer> node5ForRoot2 = new BinaryNode<>(4);
        BinaryNode<Integer> node6ForRoot2 = new BinaryNode<>(5);

        root2.setRight(node1ForRoot2);
        root2.setLeft(node2ForRoot2);

        node1ForRoot2.setLeft(node3ForRoot2);
        node1ForRoot2.setRight(node4ForRoot2);

        node2ForRoot2.setLeft(node5ForRoot2);
        node2ForRoot2.setRight(node6ForRoot2);

        // When
        boolean compare = CompareBinaryTree.compare(root, root2);

        // Then
        assertThat(compare)
                .isTrue();
    }

    @Test
    void compare_equivalent_Tree() {
        // Given
        BinaryNode<Integer> root = new BinaryNode<>(1);

        BinaryNode<Integer> node1 = new BinaryNode<>(2);
        BinaryNode<Integer> node2 = new BinaryNode<>(3);
        BinaryNode<Integer> node3 = new BinaryNode<>(2);
        BinaryNode<Integer> node4 = new BinaryNode<>(3);
        BinaryNode<Integer> node5 = new BinaryNode<>(4);
        BinaryNode<Integer> node6 = new BinaryNode<>(5);

        root.setRight(node1);
        root.setLeft(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);



        BinaryNode<Integer> root2 = new BinaryNode<>(1);

        BinaryNode<Integer> node1ForRoot2 = new BinaryNode<>(2);
        BinaryNode<Integer> node2ForRoot2 = new BinaryNode<>(3);
        BinaryNode<Integer> node3ForRoot2 = new BinaryNode<>(2);
        BinaryNode<Integer> node4ForRoot2 = new BinaryNode<>(3);
        BinaryNode<Integer> node6ForRoot2 = new BinaryNode<>(5);

        root2.setRight(node1ForRoot2);
        root2.setLeft(node2ForRoot2);

        node1.setLeft(node3ForRoot2);
        node1.setRight(node4ForRoot2);

        node2.setRight(node6ForRoot2);

        // When
        boolean compare = CompareBinaryTree.compare(root, root2);

        // Then
        assertThat(compare)
                .isFalse();
    }

}