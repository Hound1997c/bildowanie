package pl.put.poznan.buildingInfo.rest.building;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.buildingInfo.logic.building.BuildingService;


@RestController
@RequestMapping("/building")
public class BuildingController {

  private static final Logger logger = LoggerFactory.getLogger(BuildingController.class);

  @Autowired
  BuildingService buildingService;

  @RequestMapping("/area/{buildingId}")
  public ResponseEntity<Float> getBuildingArea(@PathVariable Integer buildingId) {

    logger.debug(buildingId.toString());

    Float totalArea = buildingService.calculateBuildingArea(buildingId);
    return new ResponseEntity<>(totalArea, HttpStatus.OK);
  }

  @RequestMapping("/cube/{buildingId}")
  public ResponseEntity<Float> getBuildingCube(@PathVariable Integer buildingId) {

    //TODO
    return new ResponseEntity<>((float) 0, HttpStatus.OK);
  }
}

