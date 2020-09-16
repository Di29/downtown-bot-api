package kz.downtown.jar.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CallRecord {

    @Id
    private Long id;

    @Column
    private String block_name;

    @Column
    private String service_name;

    @Column
    private int count;
}
