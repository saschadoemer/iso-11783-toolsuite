package de.saschadoemer.iso11783.localization.enums;

/**
 * The internal decimal symbol.
 * <p>
 * 00 Comma is used
 * 01 Point is used
 * 10 Reserved
 * 11 No action
 */
public enum DecimalSymbol {

    COMMA(false, false),
    POINT(false, true),
    RESERVED(true, false),
    NO_ACTION(true, true);

    private final boolean bit_1;
    private final boolean bit_2;

    DecimalSymbol(boolean bit_1, boolean bit_2) {
        this.bit_1 = bit_1;
        this.bit_2 = bit_2;
    }

    public boolean isBit_1() {
        return bit_1;
    }

    public boolean isBit_2() {
        return bit_2;
    }
}
