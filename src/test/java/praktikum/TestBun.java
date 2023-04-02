package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class TestBun {
    @Test
    public void checkGetName() {
        Bun bun = new Bun("Зеленая булочка", 25f);
        Assert.assertEquals("Имя задается неверно","Зеленая булочка", bun.getName());
    }
    @Test
    public void checkGetPrice() {
        Bun bun = new Bun("Красная булочка", 456f);
        Assert.assertEquals("Цена задается неверно",456f, bun.getPrice(),0);
    }

}
