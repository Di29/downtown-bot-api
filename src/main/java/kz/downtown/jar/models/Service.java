package kz.downtown.jar.models;

import kz.downtown.jar.dtos.ServiceInsertUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "services")
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "picture_url")
    private String pictureUrl;

    public Service(ServiceInsertUpdateDTO dto){
        setId(dto.getId());
        setPictureUrl(dto.getPictureUrl());
        setServiceName(dto.getServiceName());
    }
}
