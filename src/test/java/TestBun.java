import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
public class TestBun {
@Test
    public void checkGetName() {
    Bun bun = new Bun("������� �������", 25f);
    Assert.assertEquals("��� �������� �������","������� �������", bun.getName());
}
@Test
    public void checkGetPrice() {
    Bun bun = new Bun("������� �������", 456f);
    Assert.assertEquals("���� �������� �������",456f, bun.getPrice(),0);
}

}
