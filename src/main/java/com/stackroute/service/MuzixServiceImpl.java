/**
 * Implimentation of the MuzixService interface
 */
package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.MuzixAlreadyExistsException;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuzixServiceImpl implements MuzixService {

    //Created a variable of MuzixRepository
    MuzixRepository muzixRepository;

    //Autowired the constructor
    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    //Overriden method to save the muzix
    @Override
    public Muzix saveMuzix(Muzix muzix) throws MuzixAlreadyExistsException{
           if(muzixRepository.existsById(muzix.getTrackId())){
               throw new MuzixAlreadyExistsException("User already exists");
           }
           Muzix savedMuzix = muzixRepository.save(muzix);
           if (savedMuzix == null){
               throw new MuzixAlreadyExistsException("User already exists");
           }
           return savedMuzix;
    }

    //Overriden method to get all the muzixs
    @Override
    public List<Muzix> getAllMuzixs() {
        return muzixRepository.findAll();
    }

    //Overriden method to update the muzix
    @Override
    public Muzix updateMuzix(Muzix muzix) {
        return muzixRepository.save(muzix);
    }

    //Overriden method to remove the muzix
    @Override
    public Muzix removeMuzix(int trackId) {
        Muzix deletedMuzix = muzixRepository.getOne(trackId);
        muzixRepository.delete(deletedMuzix);
        return deletedMuzix;
    }
}
