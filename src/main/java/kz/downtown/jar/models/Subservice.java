package kz.downtown.jar.models;

import kz.downtown.jar.dtos.SubserviceInsertUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subservices")
@NoArgsConstructor
@AllArgsConstructor
public class Subservice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subservice_name")
    private String subserviceName;

    @Column(name = "service_id")
    private Long serviceId;

    public Subservice(SubserviceInsertUpdateDTO dto) {
        setId(dto.getId());
        setServiceId(dto.getServiceId());
        setSubserviceName(dto.getSubserviceName());
    }
}
