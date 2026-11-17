package com.tecsup.minishop.service;

import com.tecsup.minishop.model.Product;
import com.tecsup.minishop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @Test
    void findById_inexistente_lanzaProductNotFoundException() {
        // Arrange
        ProductRepository repository = mock(ProductRepository.class);
        when(repository.findById(99L)).thenReturn(Optional.empty());
        ProductService service = new ProductService(repository);

        // Act + Assert
        assertThrows(ProductNotFoundException.class, () -> service.findById(99L));
    }
}