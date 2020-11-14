package kz.downtown.jar.rest;

import kz.downtown.jar.dtos.BlockInsertUpdateDTO;
import kz.downtown.jar.models.Block;
import kz.downtown.jar.service.BlockService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blocks")
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBlockById(@PathVariable("id") Long id) {
        Block block = blockService.getBlockById(id);

        if(block == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(block, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllBlocks() {
        List<Block> blocks = blockService.getBlocksSorted();

        if(blocks.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(blocks, HttpStatus.OK);
    }

    @RequestMapping(value = "name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBlockByName(@RequestParam("name") String name) {
        if (name.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        List<Block> blocks = blockService.getBlockByName(name);
        if (blocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blocks, HttpStatus.OK);
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public ResponseEntity<?> createBlock(@RequestBody BlockInsertUpdateDTO blockInsertUpdateDTO) {
        try {
            //long id = blockService.getDistinctFirstId() + 1;
            blockInsertUpdateDTO.setId(0L);
            blockService.addBlock(blockInsertUpdateDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("New block was added");
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBlock(@RequestBody BlockInsertUpdateDTO categoryUpdateDTO) {
        try {
            blockService.updateBlock(categoryUpdateDTO);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

        return ResponseEntity.ok().body("Selected block was updated successfully!");
    }

    @RequestMapping(value = "admin/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        try {
            blockService.removeBlockById(id);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Block does not exist!");
        }
            return ResponseEntity.ok().body("Selected block was removed successfully!");
        }



}
