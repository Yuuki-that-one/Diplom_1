import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    private Burger burger;
    @Mock
    Ingredient ingredientMock;
    @Mock
    Ingredient ingredientMock2;
    @Mock
    Bun bunMock;

    @Before
    public void setUp(){
        burger = new Burger();
    }
    @After
    public void shutdown() {
        burger.bun = null;
        burger.ingredients.clear();
    }
    @Test
    public void checkSetBuns() {
        burger.setBuns(bunMock);
        Assert.assertEquals("Булочка не задана", bunMock, burger.bun);
    }
    @Test
    public void checkTheIngredientCanBeAdded() {

        burger.addIngredient(ingredientMock);
        Assert.assertTrue("Ингридиент не добавлен", burger.ingredients.contains(ingredientMock));

    }
    @Test
    public void checkTheIngredientCanBeRemoved() {
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        Assert.assertFalse("Ингридиент не удален", burger.ingredients.contains(ingredientMock));

}
    @Test
    public void checkTheIngredientCanBeMoved() {
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингридиент не перемещен", ingredientMock2, burger.ingredients.get(1));
    }
    @Test
    public void checkGetPrice() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        Mockito.when(bunMock.getPrice()).thenReturn(10f);
        Mockito.when(ingredientMock.getPrice()).thenReturn(200f);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(3000f);
        Assert.assertEquals("Цена посчитана неверно",3220F, burger.getPrice(), 0);

    }
    @Test
    public void checkReceipt() {
        burger.addIngredient(ingredientMock);
        burger.setBuns(bunMock);
        Mockito.when(bunMock.getName()).thenReturn("Test Bun");
        Mockito.when(bunMock.getPrice()).thenReturn(25f);
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientMock.getName()).thenReturn("Cheese");
        Mockito.when(ingredientMock.getPrice()).thenReturn(110f);
        String expectedReceipt = "(==== Test Bun ====)\r\n= filling Cheese =\r\n(==== Test Bun ====)\r\n\r\nPrice: 160,000000\r\n";
        Assert.assertEquals("Чек не совпадает", expectedReceipt, burger.getReceipt());
    }
}
