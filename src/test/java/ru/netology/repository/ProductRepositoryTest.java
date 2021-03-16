package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product first = new Product(1,"name1",100);
    private Product second = new Product(2,"name2",200);
    private Product third = new Product(3,"name3",300);
    private Product forth = new Product(4,"name4",400);


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);


    }
    @Test
    void shouldRemoveByExistId() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {
                second,
                third,
                forth
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNotExist(){
        int idToRemove = 5;
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
    }


}