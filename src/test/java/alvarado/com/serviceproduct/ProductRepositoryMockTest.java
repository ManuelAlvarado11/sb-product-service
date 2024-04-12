package alvarado.com.serviceproduct;

import alvarado.com.serviceproduct.entity.Category;
import alvarado.com.serviceproduct.entity.Product;
import alvarado.com.serviceproduct.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {
    @Autowired
    private ProductRepository productRepository;

    //TEST REPOSITORY PRODUCTS
    @Test
    public void whenFindByCategory_thenReturnListProduct(){

        // CREATE PRODUCT
        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.77"))
                .status("Created")
                .createAt(new Date())
                .build();

        // INSERT PRODUCT
        productRepository.save(product01);

        // FIND PRODUCT BY CATEGORY
        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        // VALIDATE RESULT
        Assertions.assertThat(founds.size()).isEqualTo(3);
    }
}
