package Day3.repository;
import Day3.entity.Product;
import Day3.entity.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository
        extends JpaRepository<Product, Long> {

    Product findByCode(String code);

    Page<Product> findByStatus(
            ProductStatus status,
            Pageable pageable);

    boolean existsByCode(String code);
}