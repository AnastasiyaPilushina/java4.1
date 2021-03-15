package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Book first = new Book(1, "name1", 100, "A1");
    private Book second = new Book(2, "name2", 200, "A2");
    private Smartphone third = new Smartphone(3, "name3", 2000, "M1");
    private Smartphone forth = new Smartphone(4, "name4", 3000, "M2");
    private Product[] notProduct = new Product[0];


    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(forth);


    }

    @Test
    public void shouldSearchSmartphoneManufacture() {
        String text = "M1";

        Product[] expected = new Product[]{third};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchSmartphoneName() {
        String text = "name4";


        Product[] expected = new Product[]{forth};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBookName() {
        String text = "name2";

        Product[] expected = new Product[]{second};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBookAuthor() {
        String text = "name1";

        Product[] expected = new Product[]{first};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchNotBookAuthor() {
        String text = "A3";

        Product[] expected = new Product[0];
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{first, second, third, forth};
        Product[] actual = productManager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBook() {

        Product[] actual = productManager.searchBy("name2");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphone() {

        Product[] actual = productManager.searchBy("name4");
        Product[] expected = new Product[]{forth};
        assertArrayEquals(expected, actual);
    }
}