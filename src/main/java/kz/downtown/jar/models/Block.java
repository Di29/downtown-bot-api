package kz.downtown.jar.models;

import kz.downtown.jar.dtos.BlockInsertUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "blocks")
@NoArgsConstructor
@AllArgsConstructor
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "block_name")
    private String blockName;

    public Block(BlockInsertUpdateDTO dto) {
        setId(dto.getId());
        setBlockName(dto.getBlockName());
    }
}
