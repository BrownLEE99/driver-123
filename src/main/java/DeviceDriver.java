/**
 * This class is used by the operating system to interact with the hardware 'FlashMemoryDevice'.
 */

class ReadFailException extends RuntimeException {

}

class WriteFailException extends RuntimeException {

}

public class DeviceDriver {

    FlashMemoryDevice device;

    public DeviceDriver(FlashMemoryDevice hardware) {
        this.device = hardware;
    }

    public byte read(long address) {
        int cnt = 0;
        byte result = device.read(address);
        verifyResult(address, cnt, result);
        return result;
    }

    private void verifyResult(long address, int cnt, byte result) {
        while (cnt < 4) {
            if (result == device.read(address)) {
                cnt++;
            } else {
                throw new ReadFailException();
            }
        }
    }

    public void write(long address, byte data) {
        if (device.read(address) != 0xFF) {
            throw new WriteFailException();
        }
        device.write(address, data);
    }
}