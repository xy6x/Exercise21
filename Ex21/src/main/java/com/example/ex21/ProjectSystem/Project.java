package com.example.ex21.ProjectSystem;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Project {
@NotNull
@Size(min = 2)
    private String ID;
@NotEmpty
@Size(min = 8)
    private  String title;
    @NotEmpty
    @Size(min = 15)
    private  String description;
    @NotNull
    @Pattern(regexp ="(Not Started|Progress|Completed)",message = "The entry is incorrect")
    private  String status;
   @NotNull
   @Size(min = 6)
    private  String companyName ;
}
