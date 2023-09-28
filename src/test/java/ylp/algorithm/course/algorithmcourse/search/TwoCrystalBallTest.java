package ylp.algorithm.course.algorithmcourse.search;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Predicate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TwoCrystalBallTest {


    @Test
    void whenDoesItBreak_it_will_never() {
        // Given
        boolean[] ballResistance = {false, false, false, false, false, false, false, false, false, false};

        // When
        Optional<Integer> breakThreshold = TwoCrystalBall.whenDoesItBreak(ballResistance);

        // Then
        assertThat(breakThreshold)
                .isEmpty();
    }

    @Test
    void whenDoesItBreak() {
        // Given
        boolean[] ballResistance = {false, false, false, false, true, true, true, true, true, true};

        // When
        Optional<Integer> breakThreshold = TwoCrystalBall.whenDoesItBreak(ballResistance);

        // Then
        assertThat(breakThreshold)
                .contains(4);
    }

    @Test
    void whenDoesItBreak_at_the_end() {
        // Given
        boolean[] ballResistance = {false, false, false, false, false, false, false, false, false, true};

        // When
        Optional<Integer> breakThreshold = TwoCrystalBall.whenDoesItBreak(ballResistance);

        // Then
        assertThat(breakThreshold)
                .contains(9);
    }

    @Test
    void whenDoesItBreak_at_the_start() {
        // Given
        boolean[] ballResistance = {true, true, true, true, true, true, true, true, true, true};

        // When
        Optional<Integer> breakThreshold = TwoCrystalBall.whenDoesItBreak(ballResistance);

        // Then
        assertThat(breakThreshold)
                .contains(0);
    }


    @Test
    void whenDoesItBreak_generic_it_will_never() {
        // Given
        ARecord[] array =  {
                new ARecord(1),
                new ARecord(2),
                new ARecord(3),
                new ARecord(4),
                new ARecord(5)
        };

        // When
        Optional<Integer> breakThreshold = TwoCrystalBall.whenDoesItBreak(
                array,
                aRecordPredicate(10)
        );

        // Then
        assertThat(breakThreshold)
                .isEmpty();
    }

    @Test
    void whenDoesItBreak_generic() {
        // Given
        ARecord[] array =  {
                new ARecord(1),
                new ARecord(2),
                new ARecord(3),
                new ARecord(4),
                new ARecord(5)
        };

        // When
        Optional<Integer> breakThreshold = TwoCrystalBall.whenDoesItBreak(
                array,
                aRecordPredicate(3)
        );

        // Then
        assertThat(breakThreshold)
                .contains(2);
    }

    @Test
    void whenDoesItBreak_generic_at_the_end() {
        // Given
        ARecord[] array =  {
                new ARecord(1),
                new ARecord(2),
                new ARecord(3),
                new ARecord(4),
                new ARecord(5)
        };

        // When
        Optional<Integer> breakThreshold = TwoCrystalBall.whenDoesItBreak(
                array,
                aRecordPredicate(5)
        );

        // Then
        assertThat(breakThreshold)
                .contains(4);
    }

    @Test
    void whenDoesItBreak_generic_at_the_start() {
        // Given
        ARecord[] array =  {
                new ARecord(1),
                new ARecord(2),
                new ARecord(3),
                new ARecord(4),
                new ARecord(5)
        };

        // When
        Optional<Integer> breakThreshold = TwoCrystalBall.whenDoesItBreak(
                array,
                aRecordPredicate(1)
                );

        // Then
        assertThat(breakThreshold)
                .contains(0);
    }

    Predicate<ARecord> aRecordPredicate(int threshold) {
        return aRecord -> aRecord.aNumber >= threshold;
    }
    record ARecord(int aNumber) {}
}