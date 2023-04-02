import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class TestIngredient {

        private final IngredientType type;
        private final String name;
        private final float price;

        public TestIngredient(IngredientType type, String name, float price) {
            this.type = type;
            this.name = name;
            this.price = price;
        }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{
                {SAUCE, "������� ����", 10f},
                {FILLING, "������� ��������", 35f}
        };
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("��� �� ���������",name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("���� �� ���������",price, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("��� ����������� �� ���������", type, ingredient.getType());
    }


}
