import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void removeByIdExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "ручка", 20);
        Product product2 = new Product(15, "тетрадь", 75);
        Product product3 = new Product(7, "карандаш", 15);
        Product product4 = new Product(4, "папка", 118);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.remove(15);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3, product4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "ручка", 20);
        Product product2 = new Product(15, "тетрадь", 75);
        Product product3 = new Product(7, "карандаш", 15);
        Product product4 = new Product(4, "папка", 118);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(256));
    }
}
