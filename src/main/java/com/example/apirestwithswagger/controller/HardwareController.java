package com.example.apirestwithswagger.controller;

import com.example.apirestwithswagger.entities.Hardware;
import com.example.apirestwithswagger.repository.HardwareRepository;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;


@RestController
public class HardwareController {

    private final Logger log = LoggerFactory.getLogger(HardwareController.class);

    // attributes
    private HardwareRepository hardwareRepository;
    // constructors
    public HardwareController(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    /**
     * Search for all hardwares in the database (ArrayList of hardwares)
     * http://localhost:8080/api/hardwares
     * @return
     */
    @GetMapping("/api/hardwares")
    public List<Hardware> findAll(){
        // retrieve and return the database hardwares
        return hardwareRepository.findAll();
    }

    /**
     * http://localhost:8080/api/hardware/1
     * http://localhost:8080/api/hardware/2
     * Request
     * Response
     * @param id
     * @return
     */
    // search a single hardaware in database according to its id
    @GetMapping("/api/hardwares/{id}")
    @ApiOperation("Buscar un libro por clave primaria id Long")
    public ResponseEntity<Hardware> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){

        Optional<Hardware> hardwareOpt = hardwareRepository.findById(id);

        if(hardwareOpt.isPresent())
            return ResponseEntity.ok(hardwareOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    /**
     * Create new a hardware in database
     * POST method, does not collide with findAll because they are different HTTP methods: GET vs. POST
     * @param hardware
     * @param headers
     * @return
     */
    @PostMapping("/api/hardwares")
    public ResponseEntity<Hardware> create(@RequestBody Hardware hardware, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        // save the hardaware received by parameter in the database
        if(hardware.getId() != null){ // it means that the id exists and therefore it is not a creation
            log.warn("trying to create a hardware with id");
            System.out.println("trying to create a hardware with id");
            return ResponseEntity.badRequest().build();
        }
        Hardware result = hardwareRepository.save(hardware);
        return ResponseEntity.ok(result); // the returned hardware has a primary key
    }

    /**
     * update an existing hardware in database
     */
    @PutMapping("/api/hardwares")
    public ResponseEntity<Hardware> update(@RequestBody Hardware hardware){
        if(hardware.getId() == null ){ //if it has id it means that it is a creation
            log.warn("Trying to update a non existent hardware");
            return ResponseEntity.badRequest().build();
        }
        if(!hardwareRepository.existsById(hardware.getId())){
            log.warn("Trying to update a non existent hardware");
            return ResponseEntity.notFound().build();
        }

        // update process
        Hardware result = hardwareRepository.save(hardware);
        return ResponseEntity.ok(result); //  the returned hardware has a primary key
    }

    @ApiIgnore
    @DeleteMapping("/api/hardwares/{id}")
    public ResponseEntity<Hardware> delete(@PathVariable Long id){

        if(!hardwareRepository.existsById(id)){
            log.warn("Trying to delete a non existent hardaware");
            return ResponseEntity.notFound().build();
        }
        hardwareRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @ApiIgnore // ignore this method so it doesn't appear in the swagger api documentation
    @DeleteMapping("/api/hardwares")
    public ResponseEntity<Hardware> deleteAll(){
        log.info("REST Request for delete all hardwares");
        hardwareRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
