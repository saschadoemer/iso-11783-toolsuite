package de.saschadoemer.iso11783.localization;

import de.saschadoemer.iso11783.localization.builder.DeviceLocalizationLabelParameterBuilder;
import de.saschadoemer.iso11783.localization.builder.ImperialDeviceLocalizationLabelParameterBuilder;
import de.saschadoemer.iso11783.localization.builder.MetricDeviceLocalizationLabelParameterBuilder;
import de.saschadoemer.iso11783.localization.builder.USDeviceLocalizationLabelParameterBuilder;
import de.saschadoemer.iso11783.localization.enums.DateFormat;
import de.saschadoemer.iso11783.localization.enums.DecimalSymbol;
import de.saschadoemer.iso11783.localization.enums.TimeFormat;
import de.saschadoemer.iso11783.localization.parameters.DeviceLocalizationLabelParameter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Locale;
import java.util.stream.Stream;

class DeviceLocalizationLabelEncoderTest {

    @Test
    void givenNullAsParameterValuesWhenEncodingDeviceLocalizationLabelThenTheEncoderShouldThrowAnException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DeviceLocalizationLabelEncoder.encode(null));
    }

    @Test
    void givenInvalidParameterValuesWhenEncodingDeviceLocalizationLabelThenTheEncoderShouldThrowAnException() {
        final DeviceLocalizationLabelParameter deviceLocalizationLabelParameter = new DeviceLocalizationLabelParameter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> DeviceLocalizationLabelEncoder.encode(deviceLocalizationLabelParameter));

        deviceLocalizationLabelParameter.setLocale(Locale.ENGLISH);
        Assertions.assertThrows(IllegalArgumentException.class, () -> DeviceLocalizationLabelEncoder.encode(deviceLocalizationLabelParameter));

        deviceLocalizationLabelParameter.setDateFormat(DateFormat.DD_MM_YYYY);
        Assertions.assertThrows(IllegalArgumentException.class, () -> DeviceLocalizationLabelEncoder.encode(deviceLocalizationLabelParameter));

        deviceLocalizationLabelParameter.setDecimalSymbol(DecimalSymbol.COMMA);
        Assertions.assertThrows(IllegalArgumentException.class, () -> DeviceLocalizationLabelEncoder.encode(deviceLocalizationLabelParameter));

        deviceLocalizationLabelParameter.setTimeFormat(TimeFormat._12H);
        Assertions.assertDoesNotThrow(() -> DeviceLocalizationLabelEncoder.encode(deviceLocalizationLabelParameter));
    }

    @MethodSource
    @ParameterizedTest
    void givenEmptyParameterValuesWhenEncodingDeviceLocalizationLabelThenTheEncoderShouldReturnALegalValue(DeviceLocalizationLabelParameter deviceLocalizationLabelParameters, int expectedByteSize) {
        byte[] bytes = DeviceLocalizationLabelEncoder.encode(deviceLocalizationLabelParameters);
        Assertions.assertEquals(expectedByteSize, bytes.length);
    }

    @SuppressWarnings("unused")
    protected static Stream<Arguments> givenEmptyParameterValuesWhenEncodingDeviceLocalizationLabelThenTheEncoderShouldReturnALegalValue() {
        return Stream.of(
                Arguments.of(new DeviceLocalizationLabelParameterBuilder()
                        .withLocale(Locale.ENGLISH)
                        .withDateFormat(DateFormat.DD_MM_YYYY)
                        .withDecimalSymbol(DecimalSymbol.COMMA)
                        .withTimeFormat(TimeFormat._12H)
                        .build(), 7),
                Arguments.of(new DeviceLocalizationLabelParameterBuilder()
                        .withLocale(Locale.GERMAN)
                        .withDateFormat(DateFormat.DD_YYYY_MM)
                        .withDecimalSymbol(DecimalSymbol.POINT)
                        .withTimeFormat(TimeFormat._24H)
                        .build(), 7),
                Arguments.of(new DeviceLocalizationLabelParameterBuilder()
                        .withLocale(Locale.GERMANY)
                        .withDateFormat(DateFormat.MM_DD_YYYY)
                        .withDecimalSymbol(DecimalSymbol.NO_ACTION)
                        .withTimeFormat(TimeFormat._12H)
                        .build(), 7),
                Arguments.of(new DeviceLocalizationLabelParameterBuilder()
                        .withLocale(Locale.FRANCE)
                        .withDateFormat(DateFormat.MM_YYYY_DD)
                        .withDecimalSymbol(DecimalSymbol.NO_ACTION)
                        .withTimeFormat(TimeFormat._12H)
                        .build(), 7),
                Arguments.of(new DeviceLocalizationLabelParameterBuilder()
                        .withLocale(Locale.FRENCH)
                        .withDateFormat(DateFormat.YYYY_DD_MM)
                        .withDecimalSymbol(DecimalSymbol.NO_ACTION)
                        .withTimeFormat(TimeFormat._12H)
                        .build(), 7),
                Arguments.of(new DeviceLocalizationLabelParameterBuilder()
                        .withLocale(Locale.US)
                        .withDateFormat(DateFormat.YYYY_MM_DD)
                        .withDecimalSymbol(DecimalSymbol.NO_ACTION)
                        .withTimeFormat(TimeFormat._12H)
                        .build(), 7),

                Arguments.of(new ImperialDeviceLocalizationLabelParameterBuilder()
                        .withLocale(Locale.forLanguageTag("es"))
                        .withDateFormat(DateFormat.DD_MM_YYYY)
                        .withDecimalSymbol(DecimalSymbol.NO_ACTION)
                        .withTimeFormat(TimeFormat._12H)
                        .build(), 7),
                Arguments.of(new MetricDeviceLocalizationLabelParameterBuilder()
                        .withLocale(Locale.forLanguageTag("es"))
                        .withDateFormat(DateFormat.DD_MM_YYYY)
                        .withDecimalSymbol(DecimalSymbol.NO_ACTION)
                        .withTimeFormat(TimeFormat._12H)
                        .build(), 7),
                Arguments.of(new USDeviceLocalizationLabelParameterBuilder()
                        .withLocale(Locale.forLanguageTag("es"))
                        .withDateFormat(DateFormat.DD_MM_YYYY)
                        .withDecimalSymbol(DecimalSymbol.NO_ACTION)
                        .withTimeFormat(TimeFormat._12H)
                        .build(), 7)
        );
    }

}
