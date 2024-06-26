package alvarado.com.serviceproduct.service;

import alvarado.com.serviceproduct.entity.Category;
import alvarado.com.serviceproduct.entity.Product;
import alvarado.com.serviceproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product creteProduct(Product product) {
        product.setStatus("CREATE");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = getProduct(product.getId());

        if(productDB == null) return  null;

        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setCategory(product.getCategory());
        productDB.setPrice(product.getPrice());

        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) {

        Product productDB = getProduct(id);

        if(productDB == null) return  null;

        productDB.setStatus("DELETED");

        return productRepository.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantify) {
        Product productDB = getProduct(id);

        if(productDB == null) return  null;

        Double stock = productDB.getStock() + quantify;
        productDB.setStock(stock);
        return productRepository.save(productDB);
    }
}
