package pl.put.poznan.buildingInfo.rest.building.floor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.buildingInfo.logic.building.BuildingService;
import pl.put.poznan.buildingInfo.logic.building.floor.FloorService;

@RestController
@RequestMapping("/floor")
public class FloorController {

  private static final Logger logger = LoggerFactory.getLogger(FloorController.class);

  @Autowired
  FloorService floorService;

  @RequestMapping("/area/{floorId}")
  public ResponseEntity<Float> getFloorArea(@PathVariable Integer floorId) {

    logger.debug(floorId.toString());

    Float totalArea = floorService.calculateFloorArea(floorId);
    return new ResponseEntity<>(totalArea, HttpStatus.OK);
  }
}
