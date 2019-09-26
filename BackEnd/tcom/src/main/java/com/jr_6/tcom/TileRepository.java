package com.jr_6.tcom;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TileRepository extends JpaRepository<Tiles, Integer>{

}
