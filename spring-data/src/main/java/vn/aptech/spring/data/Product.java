package vn.aptech.spring.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

//1 khach hang mua nhieu san pham va 1 san pham duoc nhieu khach hang mua
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private BigDecimal price;
    private String description;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private Set<Customer> customers;
}
