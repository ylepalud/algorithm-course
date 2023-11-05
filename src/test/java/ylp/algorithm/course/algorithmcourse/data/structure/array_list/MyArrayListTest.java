package ylp.algorithm.course.algorithmcourse.data.structure.array_list;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void add() {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();

        IntStream.range(0, 21)
                        .forEach(integerMyArrayList::append);


    }

}