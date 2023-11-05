package ylp.algorithm.course.algorithmcourse.data.structure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ylp.algorithm.course.algorithmcourse.data.structure.linked_list.NaiveLinkedList;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NaiveLinkedListTest {

    @Test
    void insertAt() {
        // Given
        MyList<Integer> integerLinkedList = new NaiveLinkedList<>();
        integerLinkedList.append(0);
        integerLinkedList.append(2);

        // When
        integerLinkedList.insertAt(1, 1);

        // Then
        assertThat(integerLinkedList.getAt(0))
                .contains(0);

        assertThat(integerLinkedList.getAt(1))
                .contains(1);

        assertThat(integerLinkedList.getAt(2))
                .contains(2);
    }

    @Test
    void prepend() {
        // Given
        MyList<Integer> integerLinkedList = new NaiveLinkedList<>();

        // When
        integerLinkedList.prepend(2);
        integerLinkedList.prepend(1);
        integerLinkedList.prepend(0);

        // Then
        assertThat(integerLinkedList.getAt(0))
                .contains(0);

        assertThat(integerLinkedList.getAt(1))
                .contains(1);

        assertThat(integerLinkedList.getAt(2))
                .contains(2);
    }

    @Test
    void append() {
        // Given
        MyList<Integer> integerLinkedList = new NaiveLinkedList<>();

        // When
        integerLinkedList.append(0);
        integerLinkedList.append(1);
        integerLinkedList.append(2);

        // Then
        assertThat(integerLinkedList.getAt(0))
                .contains(0);

        assertThat(integerLinkedList.getAt(1))
                .contains(1);

        assertThat(integerLinkedList.getAt(2))
                .contains(2);
    }

    @Test
    void remove() {
        // Given
        MyList<Integer> integerLinkedList = new NaiveLinkedList<>();
        integerLinkedList.append(1);

        // When
        Optional<Integer> removedElement = integerLinkedList.remove(1);

        // Then

        assertThat(integerLinkedList.length())
                .isEqualTo(0);
        assertThat(removedElement)
                .contains(1);
    }

    @Test
    void remove_with_multiple_element() {
        // Given
        MyList<Integer> integerLinkedList = new NaiveLinkedList<>();
        integerLinkedList.append(1);
        integerLinkedList.append(2);
        integerLinkedList.append(1);

        // When
        Optional<Integer> removedElement = integerLinkedList.remove(2);

        // Then

        assertThat(integerLinkedList.length())
                .isEqualTo(2);
        assertThat(removedElement)
                .contains(2);
    }

    @Test
    void size() {
        // Given
        MyList<Integer> integerLinkedList = new NaiveLinkedList<>();
        integerLinkedList.append(1);
        integerLinkedList.append(1);
        integerLinkedList.append(1);

        // When
        int size = integerLinkedList.length();

        // Then
        assertThat(size)
                .isEqualTo(3);
    }

    @Test
    void constructor() {
        // Given
        MyList<Integer> integerLinkedList;

        // When
        integerLinkedList = new NaiveLinkedList<>(0, 1, 2);

        // Then
        assertThat(integerLinkedList.getAt(0))
                .contains(0);

        assertThat(integerLinkedList.getAt(1))
                .contains(1);

        assertThat(integerLinkedList.getAt(2))
                .contains(2);
    }

    @ParameterizedTest
    @CsvSource({
            "0,true",
            "3,false"
    })
    void contain(Integer valueWeLookingFor, boolean expected) {
        // Given
        MyList<Integer> integerLinkedList = new NaiveLinkedList<>(0, 1, 2);

        // When
        boolean test = integerLinkedList.contain(valueWeLookingFor);

        // Then
        assertThat(test)
                .isEqualTo(expected);
    }
}