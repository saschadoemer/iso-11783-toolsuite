package de.saschadoemer.iso11783.localization.parameters;

import de.saschadoemer.iso11783.localization.enums.DateFormat;
import de.saschadoemer.iso11783.localization.enums.DecimalSymbol;
import de.saschadoemer.iso11783.localization.enums.TimeFormat;
import de.saschadoemer.iso11783.localization.enums.UnitSystem;
import de.saschadoemer.iso11783.localization.enums.units.*;

import java.util.Locale;

/**
 * Parameters to encode the
 */
public class DeviceLocalizationLabelParameter {

    /**
     * The locale.
     */
    private Locale locale;

    /**
     * The internal date format.
     */
    private DateFormat dateFormat;

    /**
     * The internal decimal symbol.
     */
    private DecimalSymbol decimalSymbol;

    /**
     * The internal time format.
     */
    private TimeFormat timeFormat;

    /**
     * The distance unit.
     */
    DistanceUnit distanceUnit = DistanceUnit.NO_ACTION;

    /**
     * The area unit.
     */
    AreaUnit areaUnit = AreaUnit.NO_ACTION;

    /**
     * The volume unit.
     */
    VolumeUnit volumeUnit = VolumeUnit.NO_ACTION;

    /**
     * The mass unit.
     */
    MassUnit massUnit = MassUnit.NO_ACTION;

    /**
     * The temperature unit.
     */
    TemperatureUnit temperatureUnit = TemperatureUnit.NO_ACTION;

    /**
     * The pressure unit.
     */
    PressureUnit pressureUnit = PressureUnit.NO_ACTION;

    /**
     * The force unit.
     */
    ForceUnit forceUnit = ForceUnit.NO_ACTION;

    /**
     * The unit system.
     */
    UnitSystem unitSystem = UnitSystem.NO_ACTION;

    /**
     * Checks whether all mandatory parameters are set.
     *
     * @return -
     */
    public boolean hasAllNecessaryParameters() {
        return null != getLocale() && null != getDateFormat() && null != getDecimalSymbol() && null != getTimeFormat();
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DecimalSymbol getDecimalSymbol() {
        return decimalSymbol;
    }

    public void setDecimalSymbol(DecimalSymbol decimalSymbol) {
        this.decimalSymbol = decimalSymbol;
    }

    public TimeFormat getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(TimeFormat timeFormat) {
        this.timeFormat = timeFormat;
    }

    public DistanceUnit getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(DistanceUnit distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public AreaUnit getAreaUnit() {
        return areaUnit;
    }

    public void setAreaUnit(AreaUnit areaUnit) {
        this.areaUnit = areaUnit;
    }

    public VolumeUnit getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(VolumeUnit volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public MassUnit getMassUnit() {
        return massUnit;
    }

    public void setMassUnit(MassUnit massUnit) {
        this.massUnit = massUnit;
    }

    public TemperatureUnit getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(TemperatureUnit temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public PressureUnit getPressureUnit() {
        return pressureUnit;
    }

    public void setPressureUnit(PressureUnit pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    public ForceUnit getForceUnit() {
        return forceUnit;
    }

    public void setForceUnit(ForceUnit forceUnit) {
        this.forceUnit = forceUnit;
    }

    public UnitSystem getUnitSystem() {
        return unitSystem;
    }

    public void setUnitSystem(UnitSystem unitSystem) {
        this.unitSystem = unitSystem;
    }
}
