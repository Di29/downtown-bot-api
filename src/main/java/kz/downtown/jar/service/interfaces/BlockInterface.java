package kz.downtown.jar.service.interfaces;

import kz.downtown.jar.dtos.BlockInsertUpdateDTO;
import kz.downtown.jar.models.Block;

import java.util.List;

public interface BlockInterface {

    Block getBlockById(Long id);

    List<Block> getAllBlocks();

    List<Block> getBlocksSorted();

    List<Block> getBlockByName(String name);

    void addBlock(BlockInsertUpdateDTO blockInsertUpdateDTO);

    void removeBlockById(Long id);

    void updateBlock(BlockInsertUpdateDTO blockInsertUpdateDTO) throws Exception;
}
