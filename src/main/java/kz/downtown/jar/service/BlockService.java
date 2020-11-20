package kz.downtown.jar.service;

import kz.downtown.jar.dtos.BlockInsertUpdateDTO;
import kz.downtown.jar.models.Block;
import kz.downtown.jar.repository.BlockRepository;
import kz.downtown.jar.service.interfaces.BlockInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService implements BlockInterface {

    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public Block getBlockById(Long id) {
        return blockRepository.findById(id).orElse(null);
    }

    @Override
    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    @Override
    public List<Block> getBlocksSorted() {
        return blockRepository.findBlocksByOrderById();
    }

    @Override
    public List<Block> getBlockByName(String name) {
        return blockRepository.findByBlockName(name);
    }

//    @Override
//    public long getDistinctFirstId() {
//        return blockRepository.getDistinctFirstId();
//    }

    @Override
    public void addBlock(BlockInsertUpdateDTO blockInsertUpdateDTO) {
        Block block = new Block(blockInsertUpdateDTO);
        blockRepository.save(block);
    }

    @Override
    public void removeBlockById(Long id) {
        blockRepository.deleteById(id);
    }

    @Override
    public void updateBlock(BlockInsertUpdateDTO blockInsertUpdateDTO) throws Exception {
        if(!blockRepository.existsById(blockInsertUpdateDTO.getId())) {
            throw new Exception("Block doesn't exist");
        }
        Block block = new Block(blockInsertUpdateDTO);
        blockRepository.save(block);
    }
}
