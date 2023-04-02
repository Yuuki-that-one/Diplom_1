package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestBurgerDb {

    private static Database database = new Database();
    private final List<Ingredient> ingredients;
    private final Bun bun;
    private final float price;
    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    public TestBurgerDb(Bun bun, List<Ingredient> ingredients, float price) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBurger() {
        List<Bun> buns = database.availableBuns();
        int randomBun1 = (int) (Math.random() * database.availableBuns().size());
        int randomBun2 = (int) (Math.random() * database.availableBuns().size());
        int randomBun3 = (int) (Math.random() * database.availableBuns().size());
        List<Ingredient> emptyList = new ArrayList<>();
        List<Ingredient> AllIngredients = database.availableIngredients();
        List<Ingredient> oneIngredient = new ArrayList<>();
        int randomIngredient = (int) (Math.random() * AllIngredients.size());
        oneIngredient.add(AllIngredients.get(randomIngredient));
        float totalPrice = 0f;
        for (Ingredient ingredient : AllIngredients) {
            totalPrice = totalPrice + ingredient.getPrice();
        }
        return new Object[][]{
                {buns.get(randomBun1), emptyList, buns.get(randomBun1).getPrice() * 2},
                {buns.get(randomBun2), oneIngredient, buns.get(randomBun2).getPrice() * 2 + oneIngredient.get(0).getPrice()},
                {buns.get(randomBun3), AllIngredients, buns.get(randomBun3).getPrice() * 2 + totalPrice},
        };
    }
    @Test
    public void checkGetPriceWithRealDatabase() {
        assertEquals("Полученная цена бургера не совпала с ожидаемой",price, burger.getPrice(), 0);
    }
}
