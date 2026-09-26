import java.util.ArrayList;
import java.util.List;

interface ControllableDevice {
    void turnOn();
    void turnOff();
    boolean isOn();
    String getDeviceName();
}

class SmartLight implements ControllableDevice {
    private final String name;
    private boolean state;

    public SmartLight(String name) {
        this.name = name;
        this.state = false;
    }

    @Override
    public void turnOn() {
        this.state = true;
        System.out.println(name + " turned ON.");
    }

    @Override
    public void turnOff() {
        this.state = false;
        System.out.println(name + " turned OFF.");
    }

    @Override
    public boolean isOn() {
        return state;
    }

    @Override
    public String getDeviceName() {
        return name;
    }
}

class SmartThermostat implements ControllableDevice {
    private final String name;
    private boolean state;
    private int temperature;

    public SmartThermostat(String name) {
        this.name = name;
        this.state = false;
        this.temperature = 22; // default temp
    }

    @Override
    public void turnOn() {
        this.state = true;
        System.out.println(name + " turned ON.");
    }

    @Override
    public void turnOff() {
        this.state = false;
        System.out.println(name + " turned OFF.");
    }

    @Override
    public boolean isOn() {
        return state;
    }

    @Override
    public String getDeviceName() {
        return name;
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println(name + " temperature set to " + temp + "°C.");
    }
}

class SmartDoorLock implements ControllableDevice {
    private final String name;
    private boolean state; // true = unlocked/ON, false = locked/OFF

    public SmartDoorLock(String name) {
        this.name = name;
        this.state = false;
    }

    @Override
    public void turnOn() {
        this.state = true;
        System.out.println(name + " Unlocked.");
    }

    @Override
    public void turnOff() {
        this.state = false;
        System.out.println(name + " Locked.");
    }

    @Override
    public boolean isOn() {
        return state;
    }

    @Override
    public String getDeviceName() {
        return name;
    }
}

class CentralHub {
    private final List<ControllableDevice> devices;

    public CentralHub() {
        this.devices = new ArrayList<>();
    }

    public void registerDevice(ControllableDevice device) {
        devices.add(device);
    }

    public void turnAllOn() {
        System.out.println("--- Turning ON all devices ---");
        for (ControllableDevice device : devices) {
            device.turnOn();
        }
    }

    public void turnAllOff() {
        System.out.println("--- Turning OFF all devices ---");
        for (ControllableDevice device : devices) {
            device.turnOff();
        }
    }
}