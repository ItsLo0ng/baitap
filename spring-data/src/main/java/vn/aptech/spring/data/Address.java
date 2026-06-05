package vn.aptech.spring.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "addresses")
// 1 customer co nhieu address
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String street;
    private String city;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
