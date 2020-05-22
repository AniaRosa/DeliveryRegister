package pl.parabar.deliveryregister01.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    private String date;

    private String time;

    private String address1;

    private String address2;

    private String address3;

    private String address4;

    private String address5;

    private String address6;

    private double price2;

    private double price3;

    private double price4;

    private double price5;

}
