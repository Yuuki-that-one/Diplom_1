import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestIngredientType {


    @Test
    public void checkIngredientTypeSauce() {
        assertEquals("���� �� ���������", IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }
    @Test
    public void checkIngredientTypeFilling() {
        assertEquals("������� �� ���������", IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}