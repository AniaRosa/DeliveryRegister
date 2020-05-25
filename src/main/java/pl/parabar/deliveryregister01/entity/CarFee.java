package pl.parabar.deliveryregister01.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "car_fees")
@Getter
@Setter
@NoArgsConstructor
public class CarFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    private String date;

    @Min(1)
    private double fee;

    @Size(min = 5)
    private String description;
}
