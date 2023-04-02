package praktikum;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TestIngredientType {


    @Test
    public void checkIngredientTypeSauce() {
        assertEquals("Соус не совпадает", IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }
    @Test
    public void checkIngredientTypeFilling() {
        assertEquals("Начинка не совпадает", IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}