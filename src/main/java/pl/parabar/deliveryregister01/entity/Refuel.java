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

    @NotEmpty
    @ManyToOne
    private User user;

    @NotEmpty
    private String date;

    @NotEmpty
    private String time;

    @NotEmpty
    private String fuelType;

    @NotEmpty
    @Min(1)
    private double quantity;

    @NotEmpty
    @Min(1)
    private double price;
}
