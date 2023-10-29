package ylp.algorithm.course.algorithmcourse.data.structure.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyStackTest {

    @Test
    void push_pop() {
        MyStack<Integer> integerMyStack = new MyStack<>();

        assertThat(integerMyStack.size())
                .isEqualTo(0);

        assertThat(integerMyStack.pop())
                .isEmpty();

        integerMyStack.push(1);
        integerMyStack.push(2);

        assertThat(integerMyStack.size())
                .isEqualTo(2);

        assertThat(integerMyStack.pop().get())
                .isEqualTo(2);

        assertThat(integerMyStack.size())
                .isEqualTo(1);

        assertThat(integerMyStack.pop().get())
                .isEqualTo(1);

        assertThat(integerMyStack.pop())
                .isEmpty();

        assertThat(integerMyStack.size())
                .isEqualTo(0);
    }

}