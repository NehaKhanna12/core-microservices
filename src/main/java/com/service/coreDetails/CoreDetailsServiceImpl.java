package com.service.coreDetails;

import com.dto.coreDetails.CoreDetailsResponse;
import com.exception.DatabaseException;
import com.exception.ServiceException;
import com.dto.coreDetails.CoreDetailsRequest;
import com.exception.EntityNotFoundException;
import com.exception.PersistentException;
import com.persist.coreDetails.ICoreDetailsPersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CoreDetailsServiceImpl implements ICoreDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CoreDetailsServiceImpl.class);

    @Autowired
    ICoreDetailsPersist iCoreDetailsPersist;

    @Override
    public CoreDetailsResponse getCoreDetails(CoreDetailsRequest coreDetailsRequest) throws PersistentException,EntityNotFoundException,DatabaseException {

        CoreDetailsResponse coreDetailsResponse = null;
        try {
            coreDetailsResponse =  iCoreDetailsPersist.getCoreDetailsFromESBService(coreDetailsRequest);
        }catch(PersistentException ex){
            logger.error("Persistent Exception getCoreDetailsServiceImpl : -" + ex.getMessage());
            throw new ServiceException("PersistentException getCoreDetails", ex);
        }catch(EntityNotFoundException ex){
            logger.error("EntityNotFoundException Exception getCoreDetailsServiceImpl : -" + ex.getMessage());
            throw new EntityNotFoundException("EntityNotFoundException getCoreDetails", ex);
        }catch(DatabaseException ex){
            logger.error("DatabaseException getCoreDetailsServiceImpl : -" + ex.getMessage());
            throw new DatabaseException(" DatabaseException getCoreDetails", ex);
        }
        return coreDetailsResponse;
    }
}
