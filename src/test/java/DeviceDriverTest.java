import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeviceDriverTest {

    @Mock
    FlashMemoryDevice deviceMock;

    @Test
    void notNullMockFlashMemoryDevice() {
        assertThat(deviceMock).isNotNull();
    }

    DeviceDriver driver;

    @BeforeEach
    void setUp() {
        driver = new DeviceDriver(deviceMock);
    }

    @Test
    void readTestFail() {
        when(deviceMock.read(0x11))
                .thenReturn((byte)0x56)
                .thenReturn((byte)0x56)
                .thenReturn((byte)0x56)
                .thenReturn((byte)0x53)
                .thenReturn((byte)0x56);
        assertThrows(ReadFailException.class, () -> {
            driver.read(0x11);
        });
    }

    @Test
    void writeTestSuccess() {
        when(deviceMock.read(0x99)).thenReturn((byte)0x482);
        assertThrows(WriteFailException.class, () -> {
            driver.write(0x99, anyByte());
        });
    }

}