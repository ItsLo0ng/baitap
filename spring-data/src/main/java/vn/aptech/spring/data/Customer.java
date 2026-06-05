package vn.aptech.spring.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor //cac ham tham so
@Entity //show day la 1 entity
@Table(name = "customers") //mapping xuong database
public class Customer {
    //tat ca tham so phai khai bao dang private
    //can 1 ham khoi tao ko tham so
    //can cac ham getter setter

    @Id //khoa chinh cua bang
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Identity: tu dong tang, Auto: tu dong
    private long id;

    @Column(nullable = false, length = 100)
    private  String name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 10) //phone number la string de do mat du lieu
    private String phone;

//    @Column(nullable = false, length = 100)
//    private String address;


    @Column(nullable = false)
    private LocalDate birthday;
    //dau la code-first, con Db-first thi ko can

    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses;

    @ManyToMany(mappedBy = "customers", cascade = CascadeType.ALL)//khi xoa customer thi xoa het product
    @JoinTable (name = "customers_products",
//        JoinColumns = @JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;
}
