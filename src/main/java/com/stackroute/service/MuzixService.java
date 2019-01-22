/**
 * Interface that contains the services peerformed by muzix application
 */
package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.MuzixAlreadyExistsException;

import java.util.List;

public interface MuzixService {
    public Muzix saveMuzix(Muzix muzix)throws MuzixAlreadyExistsException;
    public List<Muzix> getAllMuzixs();
    public Muzix updateMuzix(Muzix muzix);
    public Muzix removeMuzix(int trackId);
}
