package ylp.algorithm.course.algorithmcourse.data.tree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @ParameterizedTest
    @CsvSource({
            "4,true",
            "3,false",
    })
    void find(int lookingFor, boolean expected) {
        // Given
        BinarySearchTree<Integer> integerBinarySearchTree = new BinarySearchTree<>(new BinaryNode<>(10));
        integerBinarySearchTree.insert(2);
        integerBinarySearchTree.insert(4);
        integerBinarySearchTree.insert(12);
        integerBinarySearchTree.insert(14);

        // When
        boolean find = integerBinarySearchTree.find(lookingFor);

        // Then
        assertThat(find)
                .isEqualTo(expected);
    }
}