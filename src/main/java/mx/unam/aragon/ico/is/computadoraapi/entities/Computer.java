package mx.unam.aragon.ico.is.computadoraapi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "computer")
@Data
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50, name = "brand_computer")
    private String brand;

    @Column(nullable = false, columnDefinition = " VARCHAR(50) not null ", name = "model_computer")
    private String model;

    @Column(nullable = false,
            length = 50,
            insertable = false,
            columnDefinition = " VARCHAR(500) DEFAULT 'https://media.licdn.com/dms/image/v2/D4D12AQHLYmtJRpByHw/article-cover_image-shrink_600_2000/article-cover_image-shrink_600_2000/0/1684745697758?e=2147483647&v=beta&t=Q0IUsrr54vbYT4-IUb9O8rCxsw1xvbfRj5yfAFKR0mc'",
            name = "photo_computer")
    private String photo;

    @Column(nullable = true, name = "price_computer")
    private Float price;

    public Computer(int id, String brand, String model, String photo, Float price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.photo = photo;
        this.price = price;
    }

    public Computer() {

    }
}
