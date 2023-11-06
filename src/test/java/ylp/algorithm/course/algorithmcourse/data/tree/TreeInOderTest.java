package ylp.algorithm.course.algorithmcourse.data.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TreeInOderTest {

    @Test
    void preOrderSearch() {
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

        TreeInOder<Integer> tree = new TreeInOder<>(root);

        // When
        List<Integer> integers = tree.preOrderSearch();

        // Then
        assertThat(integers)
                .containsExactly(1, 3, 4, 5, 2, 2, 3);
    }
}