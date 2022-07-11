package romanNumeralToInteger;

public enum RomanNumeral {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);


    private final Integer intValue;

    RomanNumeral(Integer intValue) {
        this.intValue = intValue;
    }

    public Integer getIntValue() {
        return intValue;
    }
}
