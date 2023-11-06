package ylp.algorithm.course.algorithmcourse.data.list.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyQueueTest {

    @Test
    void push() {
        MyQueue<Integer> integerMyQueue = new MyQueue<>();

        integerMyQueue.queue(1);
        integerMyQueue.queue(2);
        integerMyQueue.queue(3);

        assertThat(integerMyQueue.size())
                .isEqualTo(3);

        assertThat(integerMyQueue.dequeue().get())
                .isEqualTo(1);

        assertThat(integerMyQueue.size())
                .isEqualTo(2);

        assertThat(integerMyQueue.dequeue().get())
                .isEqualTo(2);

        assertThat(integerMyQueue.size())
                .isEqualTo(1);

        assertThat(integerMyQueue.dequeue().get())
                .isEqualTo(3);

        assertThat(integerMyQueue.size())
                .isEqualTo(0);

        assertThat(integerMyQueue.dequeue())
                .isEmpty();
    }
}