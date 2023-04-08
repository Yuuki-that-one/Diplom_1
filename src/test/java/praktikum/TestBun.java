package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import com.github.javafaker.Faker;

import java.util.Locale;

public class TestBun {
    @Test
    public void checkGetName() {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.funnyName() + faker.pokemon().toString();
        Bun bun = new Bun(name, 25f);
        Assert.assertEquals("Имя задается неверно",name, bun.getName());
    }
    @Test
    public void checkGetPrice() {
        float price = Float.parseFloat(RandomStringUtils.randomNumeric(3));
        Bun bun = new Bun("Красная булочка", price);
        Assert.assertEquals("Цена задается неверно",price, bun.getPrice(),0);
    }

}
