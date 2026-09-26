interface Switchable {
    void turnOn();
    void turnOff();
    boolean isOn();
}

interface SmartDevice extends Switchable {
    void connectWifi(String networkName);
    boolean isConnected();
}

class SmartLight implements SmartDevice {
    private boolean poweredOn = false;
    private boolean connected = false;
    private String networkName;

    @Override
    public void turnOn() {
        this.poweredOn = true;
    }

    @Override
    public void turnOff() {
        this.poweredOn = false;
    }

    @Override
    public boolean isOn() {
        return poweredOn;
    }

    @Override
    public void connectWifi(String networkName) {
        this.networkName = networkName;
        this.connected = true;
    }

    @Override
    public boolean isConnected() {
        return connected;
    }
}

class SimpleFan implements Switchable {
    private boolean poweredOn = false;

    @Override
    public void turnOn() {
        this.poweredOn = true;
    }

    @Override
    public void turnOff() {
        this.poweredOn = false;
    }

    @Override
    public boolean isOn() {
        return poweredOn;
    }
}