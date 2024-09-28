import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

import java.util.List;



@RunWith(Parameterized.class)
public class ReceiptTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expectedReceipt;

    public ReceiptTest(Bun bun, List<Ingredient> ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {
                        new Bun("sesame bun", 120f),
                        List.of(
                                new Ingredient(IngredientType.SAUCE, "barbecue sauce", 150f),
                                new Ingredient(IngredientType.FILLING, "chicken", 200f),
                                new Ingredient(IngredientType.FILLING, "bacon", 50f)
                        ),
                        "(==== sesame bun ====)" + System.lineSeparator() +
                                "= sauce barbecue sauce =" + System.lineSeparator() +
                                "= filling chicken =" + System.lineSeparator() +
                                "= filling bacon =" + System.lineSeparator() +
                                "(==== sesame bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 640,000000" + System.lineSeparator()
                },
                {
                        new Bun("rye bun", 90f),
                        List.of(
                                new Ingredient(IngredientType.FILLING, "pork", 250f),
                                new Ingredient(IngredientType.SAUCE, "mustard sauce", 75f),
                                new Ingredient(IngredientType.FILLING, "fried onions", 30f)
                        ),
                        "(==== rye bun ====)" + System.lineSeparator() +
                                "= filling pork =" + System.lineSeparator() +
                                "= sauce mustard sauce =" + System.lineSeparator() +
                                "= filling fried onions =" + System.lineSeparator() +
                                "(==== rye bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 535,000000" + System.lineSeparator()
                },
                {
                        new Bun("corn bun", 110f),
                        List.of(
                                new Ingredient(IngredientType.SAUCE, "garlic", 80f),
                                new Ingredient(IngredientType.FILLING, "falafel", 180f),
                                new Ingredient(IngredientType.FILLING, "grilled mushrooms", 60f)
                        ),
                        "(==== corn bun ====)" + System.lineSeparator() +
                                "= sauce garlic =" + System.lineSeparator() +
                                "= filling falafel =" + System.lineSeparator() +
                                "= filling grilled mushrooms =" + System.lineSeparator() +
                                "(==== corn bun ====)" + System.lineSeparator() +
                                System.lineSeparator() +
                                "Price: 540,000000" + System.lineSeparator()
                },
        };
    }


    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        ingredients.forEach(burger::addIngredient);
        String receipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, receipt);
    }
}