package Day3.service;


import Day3.entity.Product;
import Day3.entity.ProductStatus;
import Day3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(String code, String name, Double price) {

        if (productRepository.existsByCode(code)) {
            throw new RuntimeException("Product code already exists!");
        }

        Product product = new Product(
                null,
                code,
                name,
                price,
                ProductStatus.INACTIVE
        );

        return productRepository.save(product);
    }

    public Product findByCode(String code) {
        return productRepository.findByCode(code);
    }

    public void activateProduct(String code) {
        Product product = productRepository.findByCode(code);

        if (product != null) {
            product.setStatus(ProductStatus.ACTIVE);
            productRepository.save(product);
        }
    }

    public void deactivateProduct(String code) {
        Product product = productRepository.findByCode(code);

        if (product != null) {
            product.setStatus(ProductStatus.INACTIVE);
            productRepository.save(product);
        }
    }
}