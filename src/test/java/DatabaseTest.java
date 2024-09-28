import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Database;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {
    Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testBunsSize() {
        Assert.assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void testIngredientsSize() {
        Assert.assertEquals(6, database.availableIngredients().size());
    }
}