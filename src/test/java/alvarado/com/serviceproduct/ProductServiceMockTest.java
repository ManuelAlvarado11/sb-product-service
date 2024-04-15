package alvarado.com.serviceproduct;

import alvarado.com.serviceproduct.entity.Category;
import alvarado.com.serviceproduct.entity.Product;
import alvarado.com.serviceproduct.repository.ProductRepository;
import alvarado.com.serviceproduct.service.ProductService;
import alvarado.com.serviceproduct.service.ProductServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
    @Mock
    private ProductRepository productRepository;
    private ProductService productService;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .id(1l)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));

        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }

    @Test
    public void whenValidGetId_thenReturnProduct (){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }


    @Test
    public void whenValidUpdateStock(){
        Product newStock = productService.updateStock(1L, Double.parseDouble("7"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(7);
    }
}
