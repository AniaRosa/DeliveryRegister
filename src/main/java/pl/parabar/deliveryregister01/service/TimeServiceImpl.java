package pl.parabar.deliveryregister01.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeServiceImpl implements TimeService {
    @Override
    public String getDate() {
        return String.valueOf(LocalDate.now());
    }

    @Override
    public String getTime() {
        return String.valueOf(LocalDateTime.now().getHour()) + ":" + String.valueOf(LocalDateTime.now().getMinute());
    }
}
