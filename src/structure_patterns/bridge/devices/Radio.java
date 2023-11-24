package structure_patterns.bridge.devices;

public class Radio implements Device {
    private boolean on = false;
    private int volume = 50;
    private int channel = 3;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent >= 100) {
            volume = 100;
        } else {volume = Math.max(percent, 0);}
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm radio.");
        System.out.printf("| I'm %s%n", (on ? "enabled" : "disabled"));
        System.out.printf("| Current volume is %d percent %n", volume);
        System.out.printf("| Current channel is %d %n", channel);
        System.out.println("------------------------------------\n");
    }
}
