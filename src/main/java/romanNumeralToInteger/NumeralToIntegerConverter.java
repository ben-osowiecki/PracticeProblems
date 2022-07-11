package romanNumeralToInteger;

import java.util.Arrays;
import java.util.List;

/*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
 */

public class NumeralToIntegerConverter {
    public int romanToInt(String numeral) {
        List<RomanNumeral> numerals = Arrays.stream(numeral.split("")).map(RomanNumeral::valueOf).toList();
        int sum = 0;

        for(int i=0; i<numerals.size(); i++) {
            if(i<numerals.size()-1 && shouldSubtract(numerals.get(i), numerals.get(i+1))) {
                sum += numerals.get(i+1).getIntValue()-numerals.get(i).getIntValue();
                i++;
            } else {
                sum += numerals.get(i).getIntValue();
            }
        }

        return sum;
    }

    public boolean shouldSubtract(RomanNumeral current, RomanNumeral next) {
        if(current == next) {
            return false;
        }

        return switch (current) {
            case I -> next == RomanNumeral.V || next == RomanNumeral.X;
            case X -> next == RomanNumeral.L || next == RomanNumeral.C;
            case C -> next == RomanNumeral.D || next == RomanNumeral.M;
            default -> false;
        };

    }
}