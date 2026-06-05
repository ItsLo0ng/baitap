package Day3;


import Day3.entity.Product;
import Day3.entity.ProductStatus;
import Day3.repository.ProductRepository;
import Day3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductRunner
        implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository repository;

    @Override
    public void run(String... args) {

        System.out.println("=== CREATE ===");

        productService.createProduct(
                "P001",
                "Laptop",
                1200.0);

        productService.createProduct(
                "P002",
                "Mouse",
                20.0);

        productService.createProduct(
                "P003",
                "Keyboard",
                35.0);

        System.out.println("\n=== FIND BY CODE ===");

        Product p =
                productService.findByCode("P001");

        System.out.println(p);

        System.out.println("\n=== ACTIVATE ===");

        productService.activateProduct("P001");

        System.out.println(
                productService.findByCode("P001"));

        System.out.println("\n=== DEACTIVATE ===");

        productService.deactivateProduct("P001");

        System.out.println(
                productService.findByCode("P001"));

        System.out.println("\n=== PAGING ===");

        Page<Product> page =
                repository.findByStatus(
                        ProductStatus.INACTIVE,
                        PageRequest.of(0, 2));

        page.getContent()
                .forEach(System.out::println);
    }
}