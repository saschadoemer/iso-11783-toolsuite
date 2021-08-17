package de.saschadoemer.iso11783;

/**
 * The result after parsing the client name.
 */
public class ClientName {

    /**
     * If the CF is self configurable, the value would be 'true', false otherwise.
     */
    private boolean selfConfigurableAddress;

    /**
     * Contains the industry group.
     */
    private int industryGroup;

    /**
     * Contains the device class instance.
     */
    private int deviceClassInstance;

    /**
     * Contains the device class.
     */
    private int deviceClass;

    /**
     * Contains the function.
     */
    private int function;

    /**
     * Contains the functions instance.
     */
    private int functionInstance;

    /**
     * Contains the ECU instance.
     */
    private int ecuInstance;

    /**
     * Contains the manufacturer code.
     */
    private int manufacturerCode;

    /**
     * Contains the identity number.
     */
    private int identityNumber;

    public boolean isSelfConfigurableAddress() {
        return selfConfigurableAddress;
    }

    public void setSelfConfigurableAddress(boolean selfConfigurableAddress) {
        this.selfConfigurableAddress = selfConfigurableAddress;
    }

    public int getIndustryGroup() {
        return industryGroup;
    }

    public void setIndustryGroup(int industryGroup) {
        this.industryGroup = industryGroup;
    }

    public int getDeviceClassInstance() {
        return deviceClassInstance;
    }

    public void setDeviceClassInstance(int deviceClassInstance) {
        this.deviceClassInstance = deviceClassInstance;
    }

    public int getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(int deviceClass) {
        this.deviceClass = deviceClass;
    }

    public int getFunction() {
        return function;
    }

    public void setFunction(int function) {
        this.function = function;
    }

    public int getFunctionInstance() {
        return functionInstance;
    }

    public void setFunctionInstance(int functionInstance) {
        this.functionInstance = functionInstance;
    }

    public int getEcuInstance() {
        return ecuInstance;
    }

    public void setEcuInstance(int ecuInstance) {
        this.ecuInstance = ecuInstance;
    }

    public int getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(int manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public int getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(int identityNumber) {
        this.identityNumber = identityNumber;
    }
}
