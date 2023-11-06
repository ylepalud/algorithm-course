package ylp.algorithm.course.algorithmcourse.data.heap;

import org.junit.jupiter.api.Test;
import ylp.algorithm.course.algorithmcourse.data.TrieTree.TrieTree;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrieTreeTest {

    @Test
    void insertion() {
        // Given
        TrieTree trieTree = new TrieTree();

        // When
        trieTree.insert("cat");
        trieTree.insert("cattle");
        trieTree.insert("card");

        // Then
    }


    @Test
    void shouldPredict() {
        // Given
        TrieTree trieTree = new TrieTree();
        trieTree.insert("cat");
        trieTree.insert("cattle");
        trieTree.insert("card");
        trieTree.insert("potato");
        trieTree.insert("pizza");
        trieTree.insert("water");

        // When
        List<String> prediction = trieTree.predict("ca");

        // Then
        assertThat(prediction)
                .containsExactly(
                        "cat",
                        "cattle",
                        "card"
                );
    }

}