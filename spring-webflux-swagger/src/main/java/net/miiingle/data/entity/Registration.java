package net.miiingle.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Registration {

    @Id
    Long id;

    String name;
    Integer age;
}
