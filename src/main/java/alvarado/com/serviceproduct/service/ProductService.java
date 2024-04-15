package alvarado.com.serviceproduct.service;

import alvarado.com.serviceproduct.entity.Category;
import alvarado.com.serviceproduct.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listAllProduct();
    public Product getProduct(Long id);
    public Product creteProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Long id, Double quantify);
}
