interface Powerable {
    void turnOn();
    void turnOff();
    boolean isOn();
}

interface Connectable {
    void connectWifi(String networkName);
    boolean isConnected();
}

class SmartTV implements Powerable, Connectable {
    private boolean poweredOn = false;
    private boolean connected = false;
    private String network;

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
        this.network = networkName;
        this.connected = true;
    }

    @Override
    public boolean isConnected() {
        return connected;
    }
}

class DumbSpeaker implements Powerable {
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