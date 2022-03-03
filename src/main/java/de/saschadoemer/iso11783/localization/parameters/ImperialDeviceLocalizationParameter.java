package de.saschadoemer.iso11783.localization.parameters;

import de.saschadoemer.iso11783.localization.enums.UnitSystem;
import de.saschadoemer.iso11783.localization.enums.units.*;

/**
 * Device localization parameters, especially for the imperial/us system. All units are predefined.
 */
public class ImperialDeviceLocalizationParameter extends DeviceLocalizationLabelParameter {

    public ImperialDeviceLocalizationParameter() {
        super();
        distanceUnit = DistanceUnit.IMPERIAL_US;
        areaUnit = AreaUnit.IMPERIAL_US;
        volumeUnit = VolumeUnit.IMPERIAL;
        massUnit = MassUnit.IMPERIAL;
        temperatureUnit = TemperatureUnit.IMPERIAL_US;
        pressureUnit = PressureUnit.IMPERIAL_US;
        forceUnit = ForceUnit.IMPERIAL_US;
        unitSystem = UnitSystem.IMPERIAL;
    }

}
