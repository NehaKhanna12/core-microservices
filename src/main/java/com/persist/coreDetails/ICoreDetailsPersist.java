package com.persist.coreDetails;

import com.dto.coreDetails.CoreDetailsResponse;
import com.exception.EntityNotFoundException;
import com.exception.PersistentException;
import com.dto.coreDetails.CoreDetailsRequest;

import java.io.IOException;

public interface ICoreDetailsPersist {

    CoreDetailsResponse getCoreDetailsFromESBService(CoreDetailsRequest coreDetailsRequest) throws PersistentException,EntityNotFoundException;
}
