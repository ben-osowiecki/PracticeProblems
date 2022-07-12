package twoSum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SumElementFinderTest {

    private final SumElementFinder target = new SumElementFinder();

    @ParameterizedTest(name = "Integers: {0}, Target: {1} - Expected: {2}")
    @MethodSource("twoSumArgumentProvider")
    void twoSumTest(int[] integers, int goal, int[] expected) {

        assertArrayEquals(expected, target.twoSum(integers, goal));
    }

    private static Stream<Arguments> twoSumArgumentProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{2,7,11,15}, 9, new int[]{0,1}),
                Arguments.arguments(new int[]{3,2,4}, 6, new int[]{1,2}),
                Arguments.arguments(new int[]{3,3}, 6, new int[]{0,1})
        );
    }
}
