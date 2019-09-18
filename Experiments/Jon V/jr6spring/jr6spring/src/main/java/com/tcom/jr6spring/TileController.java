package com.tcom.jr6spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
class TileController {

    @Autowired
    OwnerRepository ownersRepository;

    private final Logger logger = LoggerFactory.getLogger(TileController.class);

    @RequestMapping(method = RequestMethod.POST, path = "/tiles/new")
    public String saveTile(Tiles tile) {
        tilesRepository.save(tile);
        return "New Tile "+ tile.getId() + " Saved";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tiles")
    public List<Tiles> getAllTiles() {
        logger.info("Entered into Controller Layer");
        List<Tiles> results = tilesRepository.findAll();
        logger.info("Number of Records Fetched:" + results.size());
        return results;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tiles/{tileId}")
    public Optional<Tiles> findTileById(@PathVariable("tileId") int id) {
        logger.info("Entered into Controller Layer");
        Optional<Tiles> results = tilesRepository.findById(id);
        return results;
    }

}