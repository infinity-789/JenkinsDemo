import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Test
    @DisplayName("Should correctly add two numbers")
    void testAdd() {
        assertEquals(5, calc.add(2, 3), "2 + 3 should be 5");
    }

    @Test
    void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, calc.multiply(3, 5));
    }

    @Test
    @DisplayName("Division by zero should throw exception")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(10, 0);
        });
    }
}
