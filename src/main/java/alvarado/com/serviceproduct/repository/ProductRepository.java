package alvarado.com.serviceproduct.repository;

import alvarado.com.serviceproduct.entity.Category;
import alvarado.com.serviceproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
