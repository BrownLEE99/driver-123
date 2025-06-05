/**
 * This class is used by the operating system to interact with the hardware 'FlashMemoryDevice'.
 */
public class DeviceDriver {

    FlashMemoryDevice flashMemoryDevice;

    public DeviceDriver(FlashMemoryDevice hardware) {
        // TODO: implement this method
        this.flashMemoryDevice = hardware;
    }

    public byte read(long address) {
        // TODO: implement this method
        // Add...
        return flashMemoryDevice.read(address);
    }

    public void write(long address, byte data) {
        // TODO: implement this method
        flashMemoryDevice.write(address, data);
    }
}