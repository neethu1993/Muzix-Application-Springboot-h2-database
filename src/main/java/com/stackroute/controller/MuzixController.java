/**
 * Controller to control the Muzix Application
 */
package com.stackroute.controller;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.MuzixAlreadyExistsException;
import com.stackroute.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class MuzixController {

    //A variable of type MuzixService
    MuzixService muzixService;

    //Autowired constructor
    @Autowired
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    //Method to perform POST operation
    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix){
        ResponseEntity responseEntity;
        try{
            muzixService.saveMuzix(muzix);
            responseEntity=new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        }catch(MuzixAlreadyExistsException ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //Method to perform GET operation
    @GetMapping("muzix")
    public ResponseEntity<?> getAllMuzixs(){
        return new ResponseEntity<List<Muzix>>(muzixService.getAllMuzixs(),HttpStatus.OK);
    }

    //Method to perform PUT operation
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix){
        ResponseEntity responseEntity;
        try{
            muzixService.updateMuzix(muzix);
            responseEntity=new ResponseEntity<String>("Successfully updated", HttpStatus.CREATED);
        }catch(Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //Method to perform DELETE operation
    @DeleteMapping("muzix")
    public ResponseEntity<?> deleteMuzix(@RequestParam int trackId){
        ResponseEntity responseEntity;
        try{
            muzixService.removeMuzix(trackId);
            responseEntity=new ResponseEntity<String>("Successfully Deleted", HttpStatus.CREATED);
        }catch(Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
