package com.jr_6.tcom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import java.util.Optional;

@RestController
public class TileController {
	
    @Autowired
    TileRepository tilesRepository;

    private final Logger logger = LoggerFactory.getLogger(TileController.class);
    
    
    @RequestMapping(method = RequestMethod.POST, path = "/tiles/new")
    public String saveTile(Tiles tile) {
        tilesRepository.save(tile);
        return "New Tile "+ tile.getId() + "at (" + tile.getCenterX() +"," + tile.getCenterY() +") Saved" + " hasPlayer = "+ tile.getHasPlayer();//tile.getName() + " Saved";
    }
	
    
    /**
    @RequestMapping(method = RequestMethod.POST, path = "/tiles/new/{tileName}")
    public String saveTile(@PathVariable("tileName") String name) {
    	Tiles tile;
        tilesRepository.save(tile);
        return "New Tile "+ tile.getName() + " Saved";
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tiles/new/{tileCenter}")
    public String saveTile(@PathVariable("tileCenter") int[] center) {
    	Tiles tile;
    	tile.setCenterX(center[0]);
    	tile.setCenterY(center[1]);
        tilesRepository.save(tile);
        return "New Tile at ("+ tile.getCenterX() + "," + tile.getCenterY() +") Saved";
    }
    **/
    
    @RequestMapping(method = RequestMethod.GET, path = "/tiles")
    public List<Tiles> getAllTiles() {
        logger.info("Entered Into Controller Layer");
        List<Tiles> results = tilesRepository.findAll();
        logger.info("Number of Records Fetched:" + results.size());
        return results;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tiles/{tileId}")
    public Optional<Tiles> findTileById(@PathVariable("tileId") int id) {
        logger.info("Entered Into Controller Layer");
        Optional<Tiles> results = tilesRepository.findById(id);
        return results;
    }
    
    
    @PutMapping("/tiles/{id}")
    public String updateTile(@RequestBody Tiles t, @PathVariable int id) {
    	Optional<Tiles> old = tilesRepository.findById(id);
    	old.get().setCenterX(t.getCenterX());
    	old.get().setCenterY(t.getCenterY());
    	old.get().setHasPlayer(t.getHasPlayer());
    	return "Put tile " + id + " at (" + old.get().getCenterX() + "," + old.get().getCenterY() +")" + "tile has player =" + old.get().getHasPlayer();
    }
    
    @DeleteMapping("/tiles/{id}")
    public String deleteTile(@PathVariable int id) {
    	tilesRepository.deleteById(id);
    	return "deleted " + id;
    }
    
}
