package ylp.algorithm.course.algorithmcourse.data.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeBreathFirstSearchTest {

    @ParameterizedTest
    @CsvSource({
            "1,true",
            "6,false",
    })
    void visit(int valueLookingFor, boolean expected) {
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

        BinaryTreeBreathFirstSearch<Integer> tree = new BinaryTreeBreathFirstSearch<>(root);

        // When
        boolean contain = tree.contain(valueLookingFor);

        // Then
        assertThat(contain)
                .isEqualTo(expected);
    }
}