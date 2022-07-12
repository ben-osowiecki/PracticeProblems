package romanNumeralToInteger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumeralToIntegerConverterTest {

    private final NumeralToIntegerConverter target = new NumeralToIntegerConverter();

    @ParameterizedTest(name="Numeral: {0}")
    @MethodSource("numeralStringProvider")
    void romanToIntTest(String numeral, Integer expected){
        assertEquals(expected, target.romanToInt(numeral));
    }

    private static Stream<Arguments> numeralStringProvider() {
        return Stream.of(
                arguments("III", 3),
                arguments("LVIII", 58),
                arguments("MCMXCIV", 1994),
                arguments("DCXXI", 621)
        );
    }

    @ParameterizedTest(name = "Current: {0}, Next: {1}")
    @MethodSource("trueShouldSubtractProvider")
    void shouldSubtractTest_true(RomanNumeral current, RomanNumeral next) {
        assertTrue(target.shouldSubtract(current, next));
    }

    private static Stream<Arguments> trueShouldSubtractProvider() {
        return Stream.of(
                arguments(RomanNumeral.I, RomanNumeral.V),
                arguments(RomanNumeral.I, RomanNumeral.X),
                arguments(RomanNumeral.X, RomanNumeral.L),
                arguments(RomanNumeral.X, RomanNumeral.C),
                arguments(RomanNumeral.C, RomanNumeral.D),
                arguments(RomanNumeral.C, RomanNumeral.M)
        );
    }

    @ParameterizedTest(name = "Current: {0}, Next: {1}")
    @MethodSource("falseShouldSubtractProvider")
    void shouldSubtractTest_false(RomanNumeral current, RomanNumeral next) {
        assertFalse(target.shouldSubtract(current, next));
    }

    private static List<Arguments> falseShouldSubtractProvider() {
        List<RomanNumeral> romanNumerals = Arrays.asList(RomanNumeral.values());

        List<Arguments> args = new ArrayList<>();

        romanNumerals.stream().filter(numeral -> numeral!=RomanNumeral.V && numeral!=RomanNumeral.X).forEach(numeral -> args.add(arguments(RomanNumeral.I, numeral)));

        romanNumerals.stream().filter(numeral -> numeral!=RomanNumeral.L && numeral!=RomanNumeral.C).forEach(numeral -> args.add(arguments(RomanNumeral.X, numeral)));

        romanNumerals.stream().filter(numeral -> numeral!=RomanNumeral.D && numeral!=RomanNumeral.M).forEach(numeral -> args.add(arguments(RomanNumeral.C, numeral)));

        romanNumerals.stream().filter(numeral -> numeral!=RomanNumeral.I && numeral!=RomanNumeral.X && numeral!=RomanNumeral.C).forEach(current ->
                romanNumerals.forEach(next -> args.add(arguments(current, next)))
        );

        return args;
    }
}
