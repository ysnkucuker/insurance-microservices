package com.yasinkucuker.validationservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CustomerCreditCardValidationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long customerId;
    private boolean isValid;
    private int binNumber;
    private LocalDateTime validationDate;

    public void setId(Long id) {        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
