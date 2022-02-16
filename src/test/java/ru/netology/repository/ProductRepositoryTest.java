package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager =  new ProductManager(repository);
    private Product first = new Book(11, "Полный курс высшей математики", 300, "Просто Виктор", 200, 2001);
    private Product second = new Book(2376427, "Кратий курс высшей математики", 600, "Гуиндий", 1000, 2012);
    private Product third = new TShirt(1426, "Курлык в вышине неба", 1300, "Морской океан", "2300 рупилей");
    private Product fourth = new TShirt(89769, "Енот +", 1300, "Какой-то красный", "XXXXXXXXL");

    @Test
    public void shouldRemoveById() {
        manager.addProduct(first);
        manager.addProduct(second);
        manager.addProduct(third);
        manager.addProduct(fourth);

        repository.removeById(1426);

        Product[] expected = {first, second, fourth};
        Product[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByNotExistId() {
        manager.addProduct(first);
        manager.addProduct(second);
        manager.addProduct(third);
        manager.addProduct(fourth);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(123456);
        });
    }
}