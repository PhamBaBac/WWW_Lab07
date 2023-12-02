package vn.edu.iuh.fit.www_lab07.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private long price_id;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    @Column(name = "price_date_time")
    private LocalDateTime price_date_time;

    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "note")
    private String note;

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product=" + product +
                ", price_date_time=" + price_date_time +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
