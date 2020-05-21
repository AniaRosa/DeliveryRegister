package pl.parabar.deliveryregister01.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "refuels")
@Getter
@Setter
@NoArgsConstructor
public class Refuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    private String date;

    private String time;

    private String fuelType;

    @Min(1)
    private double quantity;

    @Min(1)
    private double price;
}
