package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("properties")
    void checkProperties() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
        // gradle clean properties_tests -Dbrowser=opera

    }
}
