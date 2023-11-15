import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        // Configurar el WebDriver antes de todas las pruebas
        // Se ejecuta solo una vez

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://www.calculator.net/");
        driver.manage().window().maximize();
        // Click on Math Calculators
        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();

        // Click on Percent Calculators
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
    }

    @Before
    public void setUp() {
        // Limpiar los campos de entrada antes de cada prueba
        try {
            // Limpiar los campos de entrada
            driver.findElement(By.id("cpar1")).clear();
            driver.findElement(By.id("cpar2")).clear();
        } catch (Exception e) {
            System.err.println("Error al limpiar campos de entrada: " + e.getMessage());
        }
    }

    @Test
    public void testPercentCalculator() {
        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("10");

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("50");

        // Click Calculate Button
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

        // Get the Result Text based on its xpath
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();

        // assert the value of result
        assertEquals("5", result);
    }

    @Test
    public void testOtroCaso() {
        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("10");

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("100");

        // Click Calculate Button
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

        // Get the Result Text based on its xpath
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();

        // assert the value of result
        assertEquals("10", result);
    }

    @Test
    public void testErrorForzado() {
        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("10");

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("100");

        // Click Calculate Button
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

        // Get the Result Text based on its xpath
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();

        // assert the value of result
        assertEquals("100", result);
    }

    @After
    public void tearDown() {
        // No es necesario hacer nada aquí, ya que la limpieza se realiza en tearDownClass
    }

    @AfterClass
    public static void tearDownClass() {
        // Cerrar el WebDriver después de todas las pruebas
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
