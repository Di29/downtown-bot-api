package kz.downtown.jar.dtos;

import kz.downtown.jar.models.Block;
import lombok.Data;

@Data
public class BlockDTO {
    private Long id;
    private String name;

    public BlockDTO(Block block) {
        this.setId(block.getId());
        this.setName(block.getBlockName());
    }
}
