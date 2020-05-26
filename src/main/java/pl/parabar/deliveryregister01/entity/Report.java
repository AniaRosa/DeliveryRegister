package pl.parabar.deliveryregister01.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Report {

    private String type;
    private List<Integer> months;
    private List<Integer> years;

}
