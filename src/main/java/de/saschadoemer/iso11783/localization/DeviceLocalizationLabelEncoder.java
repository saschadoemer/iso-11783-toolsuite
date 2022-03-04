package de.saschadoemer.iso11783.localization;

import de.saschadoemer.iso11783.localization.builder.DeviceLocalizationLabelParameterBuilder;
import de.saschadoemer.iso11783.localization.enums.DateFormat;
import de.saschadoemer.iso11783.localization.enums.DecimalSymbol;
import de.saschadoemer.iso11783.localization.enums.TimeFormat;
import de.saschadoemer.iso11783.localization.enums.UnitSystem;
import de.saschadoemer.iso11783.localization.enums.units.*;
import de.saschadoemer.iso11783.localization.parameters.DeviceLocalizationLabelParameter;

import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Encoder for the device localization label.
 */
public final class DeviceLocalizationLabelEncoder {

    private static final Logger LOG = Logger.getLogger(DeviceLocalizationLabelParameterBuilder.class.getName());

    public static final int SINGLE_BYTE = 8;
    public static final int TWO_BYTES = 16;
    private static final int SEVEN_BYTES = 56;

    private DeviceLocalizationLabelEncoder() {
        //HIDDEN
    }

    /**
     * Generate the label given by device to identify the device
     * descriptor localization.
     * <p>
     * Bytes 1 to 6 are defined by the language command PGN (see ISO 11783-7).
     * <p>
     * | 11111111 (7) | Units of measure (5,6) | Date format (4) | Number format (3) | Language Code (1,2) |
     * <p>
     * Bytes 1 to 2: Language code
     * Byte 3: Number format
     * Byte 4: Date format
     * Byte 5: Units of measure
     * Byte 6: Units of measure
     * Byte 7: Reserved
     * <p>
     * Byte 7 is reserved and set to FF16. Byte 1 is transmitted closest to the device structure label
     * parameter and is the least significant byte of the DeviceLocalizationLabel in the XML element device.
     *
     * @param deviceLocalizationParameters -
     * @return -
     */
    public static byte[] encode(DeviceLocalizationLabelParameter deviceLocalizationParameters) {
        if (null == deviceLocalizationParameters) {
            throw new IllegalArgumentException("Please provide parameters to encode the device localization label");
        } else {
            if (deviceLocalizationParameters.hasAllNecessaryParameters()) {
                try {
                    final String languageCode = encodeLanguageCode(deviceLocalizationParameters.getLocale());
                    LOG.fine(String.format("The language code is: %s", languageCode));
                    assert languageCode.length() == TWO_BYTES;

                    final String numberFormat = encodeNumberFormat(deviceLocalizationParameters.getDecimalSymbol(), deviceLocalizationParameters.getTimeFormat());
                    LOG.fine(String.format("The number format is: %s", numberFormat));
                    assert numberFormat.length() == SINGLE_BYTE;

                    final String dateFormat = encodeDateFormat(deviceLocalizationParameters.getDateFormat());
                    LOG.fine(String.format("The date format is: %s", dateFormat));
                    assert dateFormat.length() == SINGLE_BYTE;

                    final String unitsOfMeasure = encodeUnitsOfMeasure(deviceLocalizationParameters.getDistanceUnit(),
                            deviceLocalizationParameters.getAreaUnit(),
                            deviceLocalizationParameters.getVolumeUnit(),
                            deviceLocalizationParameters.getMassUnit(),
                            deviceLocalizationParameters.getTemperatureUnit(),
                            deviceLocalizationParameters.getPressureUnit(),
                            deviceLocalizationParameters.getForceUnit(),
                            deviceLocalizationParameters.getUnitSystem());
                    LOG.fine(String.format("The units of measure is: %s", unitsOfMeasure));
                    assert unitsOfMeasure.length() == TWO_BYTES;

                    final String reservedLastByte = reservedLastByte();
                    LOG.fine(String.format("The reserved last byte is: %s", reservedLastByte));
                    assert reservedLastByte.length() == SINGLE_BYTE;

                    String finalBinaryRepresentation = reservedLastByte + unitsOfMeasure + dateFormat + numberFormat + languageCode;
                    LOG.fine(String.format("The final byte representation is: %s", finalBinaryRepresentation));

                    final BitSet bitSet = new BitSet(SEVEN_BYTES);
                    for (int b = 0; b < SEVEN_BYTES; b++) {
                        bitSet.set(b, finalBinaryRepresentation.charAt(SEVEN_BYTES - (b + 1)) == '1');
                    }
                    assert bitSet.length() == SEVEN_BYTES;
                    return bitSet.toByteArray();

                } catch (Exception e) {
                    throw new RuntimeException("There was an error while encoding the device localization label.", e);
                }
            } else {
                throw new IllegalArgumentException("Please check your input. The following parameters are mandatory: Locale");
            }
        }
    }

    /**
     * Byte 7 is reserved and set to FF16.
     *
     * @return -
     */
    private static String reservedLastByte() {
        return Integer.toBinaryString(255);
    }

    /**
     * Bits 8, 7: Distance units (see A.23.5.2)
     * Command specifying a distance unit.
     * <p>
     * Bits 6, 5: Area units (see A.23.5.3)
     * Command specifying an area unit.
     * <p>
     * Bits 4, 3: Volume units (see A.23.5.4)
     * Command specifying a volume unit.
     * <p>
     * Bits 2, 1: Mass units (see A.23.5.5)
     * Command specifying a mass unit.
     * <p>
     * Bits 8, 7: Temperature units (see A.23.5.6)
     * Command specifying a temperature unit.
     * <p>
     * Bits 6, 5: Pressure units (see A.23.5.7)
     * Command specifying a pressure unit.
     * <p>
     * Bits 4, 3: Force units (see A.23.5.8)
     * Command specifying a force unit.
     * <p>
     * Bits 2, 1: Units system (see A.23.5.9)
     * Command specifying the system to be used for the display of any unit, or a unit other than those specified
     * in A.23.5.2 to A.23.5.8.
     *
     * @return -
     */
    private static String encodeUnitsOfMeasure(DistanceUnit distanceUnit,
                                               AreaUnit areaUnit,
                                               VolumeUnit volumeUnit,
                                               MassUnit massUnit,
                                               TemperatureUnit temperatureUnits,
                                               PressureUnit pressureUnit,
                                               ForceUnit forceUnit,
                                               UnitSystem unitSystem) {
        final char[] binaryRepresentation = new char[TWO_BYTES];

        binaryRepresentation[15] = distanceUnit.isBit_1() ? '1' : '0';
        binaryRepresentation[14] = distanceUnit.isBit_2() ? '1' : '0';

        binaryRepresentation[13] = areaUnit.isBit_1() ? '1' : '0';
        binaryRepresentation[12] = areaUnit.isBit_2() ? '1' : '0';

        binaryRepresentation[11] = volumeUnit.isBit_1() ? '1' : '0';
        binaryRepresentation[10] = volumeUnit.isBit_2() ? '1' : '0';

        binaryRepresentation[9] = massUnit.isBit_1() ? '1' : '0';
        binaryRepresentation[8] = massUnit.isBit_2() ? '1' : '0';

        binaryRepresentation[7] = temperatureUnits.isBit_1() ? '1' : '0';
        binaryRepresentation[6] = temperatureUnits.isBit_2() ? '1' : '0';

        binaryRepresentation[5] = pressureUnit.isBit_1() ? '1' : '0';
        binaryRepresentation[4] = pressureUnit.isBit_2() ? '1' : '0';

        binaryRepresentation[3] = forceUnit.isBit_1() ? '1' : '0';
        binaryRepresentation[2] = forceUnit.isBit_2() ? '1' : '0';

        binaryRepresentation[1] = unitSystem.isBit_1() ? '1' : '0';
        binaryRepresentation[0] = unitSystem.isBit_2() ? '1' : '0';

        return new String(binaryRepresentation);
    }

    /**
     * Command sent to all ECUs specifying the displayed format of the date.
     *
     * @param dateFormat -
     * @return -
     */
    private static String encodeDateFormat(DateFormat dateFormat) {
        StringBuilder binaryRepresentation = new StringBuilder(Integer.toBinaryString(dateFormat.getValue()));
        while (binaryRepresentation.length() < SINGLE_BYTE) {
            binaryRepresentation.insert(0, "0");
        }
        return binaryRepresentation.toString();
    }

    /**
     * Bits 8, 7: Decimal symbol (see A.23.2)
     * <p>
     * Command sent to all ECUs that determines whether a point or a comma will be displayed as the decimal
     * symbol.
     * <p>
     * Bits 6, 5: Time format (see A.23.4)
     * <p>
     * Command sent to all ECUs specifying the displayed format of the time.
     *
     * @param decimalSymbol      -
     * @param iso11873TimeFormat -
     * @return -
     */
    private static String encodeNumberFormat(DecimalSymbol decimalSymbol, TimeFormat iso11873TimeFormat) {
        final char[] binaryRepresentation = new char[SINGLE_BYTE];

        binaryRepresentation[7] = decimalSymbol.isBit_1() ? '1' : '0';
        binaryRepresentation[6] = decimalSymbol.isBit_2() ? '1' : '0';

        binaryRepresentation[5] = iso11873TimeFormat.isBit_1() ? '1' : '0';
        binaryRepresentation[4] = iso11873TimeFormat.isBit_2() ? '1' : '0';

        binaryRepresentation[3] = '1'; // RESERVED
        binaryRepresentation[2] = '1'; // RESERVED
        binaryRepresentation[1] = '1'; // RESERVED
        binaryRepresentation[0] = '1'; // RESERVED

        return new String(binaryRepresentation);
    }

    /**
     * Command sent to all ECUs specifying the operator’s desired language of information.
     * ISO 11783 networks shall use the two-character string country codes in accordance with ISO 639.
     *
     * @param locale -
     * @return -
     */
    private static String encodeLanguageCode(Locale locale) {
        StringBuilder result = new StringBuilder();
        char[] chars = locale.getLanguage().toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0")
            );
        }
        return result.toString();
    }

}
