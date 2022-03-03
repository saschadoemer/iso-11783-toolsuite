package de.saschadoemer.iso11783.localization.builder;

import de.saschadoemer.iso11783.localization.enums.DateFormat;
import de.saschadoemer.iso11783.localization.enums.DecimalSymbol;
import de.saschadoemer.iso11783.localization.enums.TimeFormat;
import de.saschadoemer.iso11783.localization.enums.UnitSystem;
import de.saschadoemer.iso11783.localization.enums.units.*;
import de.saschadoemer.iso11783.localization.parameters.DeviceLocalizationLabelParameter;

import java.util.Locale;

/**
 * Builder class for the parameter.
 */
public class DeviceLocalizationLabelParameterBuilder {

    private final DeviceLocalizationLabelParameter deviceLocalizationLabelParameter;

    public DeviceLocalizationLabelParameterBuilder() {
        deviceLocalizationLabelParameter = new DeviceLocalizationLabelParameter();
    }

    protected DeviceLocalizationLabelParameterBuilder(DeviceLocalizationLabelParameter deviceLocalizationLabelParameter) {
        this.deviceLocalizationLabelParameter = deviceLocalizationLabelParameter;
    }

    /**
     * Set the locale.
     *
     * @param locale -
     * @return The builder.
     */
    public DeviceLocalizationLabelParameterBuilder withLocale(Locale locale) {
        deviceLocalizationLabelParameter.setLocale(locale);
        return this;
    }

    /**
     * Set the date format.
     *
     * @param dateFormat -
     * @return The builder.
     */
    public DeviceLocalizationLabelParameterBuilder withDateFormat(DateFormat dateFormat) {
        deviceLocalizationLabelParameter.setDateFormat(dateFormat);
        return this;
    }

    /**
     * Set the decimal symbol.
     *
     * @param decimalSymbol -
     * @return The builder.
     */
    public DeviceLocalizationLabelParameterBuilder withDecimalSymbol(DecimalSymbol decimalSymbol) {
        deviceLocalizationLabelParameter.setDecimalSymbol(decimalSymbol);
        return this;
    }

    /**
     * Set the time format.
     *
     * @param timeFormat -
     * @return The builder.
     */
    public DeviceLocalizationLabelParameterBuilder withTimeFormat(TimeFormat timeFormat) {
        deviceLocalizationLabelParameter.setTimeFormat(timeFormat);
        return this;
    }

    /**
     * Set the distance unit.
     *
     * @return -
     */
    public DeviceLocalizationLabelParameterBuilder withDistanceUnit(DistanceUnit distanceUnit) {
        deviceLocalizationLabelParameter.setDistanceUnit(distanceUnit);
        return this;
    }

    /**
     * Set the area unit.
     *
     * @return -
     */
    public DeviceLocalizationLabelParameterBuilder withDistanceUnit(AreaUnit areaUnit) {
        deviceLocalizationLabelParameter.setAreaUnit(areaUnit);
        return this;
    }

    /**
     * Set the volume unit.
     *
     * @return -
     */
    public DeviceLocalizationLabelParameterBuilder withVolumeUnit(VolumeUnit volumeUnit) {
        deviceLocalizationLabelParameter.setVolumeUnit(volumeUnit);
        return this;
    }

    /**
     * Set the mass unit.
     *
     * @return -
     */
    public DeviceLocalizationLabelParameterBuilder withMassUnit(MassUnit massUnit) {
        deviceLocalizationLabelParameter.setMassUnit(massUnit);
        return this;
    }

    /**
     * Set the temperature unit.
     *
     * @return -
     */
    public DeviceLocalizationLabelParameterBuilder withTemperature(TemperatureUnit temperatureUnit) {
        deviceLocalizationLabelParameter.setTemperatureUnit(temperatureUnit);
        return this;
    }

    /**
     * Set the pressure unit.
     *
     * @return -
     */
    public DeviceLocalizationLabelParameterBuilder withTemperature(PressureUnit pressureUnit) {
        deviceLocalizationLabelParameter.setPressureUnit(pressureUnit);
        return this;
    }

    /**
     * Set the force unit.
     *
     * @return -
     */
    public DeviceLocalizationLabelParameterBuilder withTemperature(ForceUnit forceUnit) {
        deviceLocalizationLabelParameter.setForceUnit(forceUnit);
        return this;
    }

    /**
     * Set the unit system.
     *
     * @return -
     */
    public DeviceLocalizationLabelParameterBuilder withUnitSystem(UnitSystem unitSystem) {
        deviceLocalizationLabelParameter.setUnitSystem(unitSystem);
        return this;
    }

    /**
     * Build the parameter object.
     *
     * @return -
     */
    public DeviceLocalizationLabelParameter build() {
        return deviceLocalizationLabelParameter;
    }

}
