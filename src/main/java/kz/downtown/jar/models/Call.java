package kz.downtown.jar.models;

import kz.downtown.jar.dtos.CallInsertUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "calls")
@NoArgsConstructor
@AllArgsConstructor
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "block_name")
    private String blockName;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "subservice_name")
    private String subserviceName;

    @Column(name = "office_number")
    private String officeNumber;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    public Call(CallInsertUpdateDTO dto) {
        setId(dto.getId());
        setBlockName(dto.getBlockName());
        setCreatedAt(dto.getCreatedAt());
        setOfficeNumber(dto.getOfficeNumber());
        setServiceName(dto.getServiceName());
        setSubserviceName(dto.getSubserviceName());
    }
}
