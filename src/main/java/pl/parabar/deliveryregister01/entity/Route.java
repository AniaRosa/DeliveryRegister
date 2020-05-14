package pl.parabar.deliveryregister01.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
public class Route {

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
    @OneToOne
    private Address address1;

    @NotEmpty
    @OneToOne
    private Address address2;

    @NotEmpty
    @OneToOne
    private Address address3;

    @OneToOne
    private Address address4;

    @OneToOne
    private Address address5;

    @OneToOne
    private Address address6;

    @NotEmpty
    @Min(1)
    private double price;
}
