package com.example.event.Event;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class Event {

    @NotNull
    @Size(min = 2)
    private String id;
    @NotNull
    @Size(min = 15)
    private String description;
    @NotNull
    @Min(2)
//    @Pattern(regexp = "[0-9]+")
    private int capacity;
    private String startDate ;
    private String endDate;
}
