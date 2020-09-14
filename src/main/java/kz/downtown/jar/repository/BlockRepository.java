package kz.downtown.jar.repository;

import kz.downtown.jar.models.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Long> {
    List<Block> findByBlockName(String name);

    List<Block> findBlocksByOrderById();

}
