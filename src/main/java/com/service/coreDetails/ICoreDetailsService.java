package com.service.coreDetails;

import com.dto.coreDetails.CoreDetailsResponse;
import com.dto.coreDetails.CoreDetailsRequest;

import java.io.IOException;

public interface ICoreDetailsService {

    CoreDetailsResponse getCoreDetails(CoreDetailsRequest coreDetailsRequest) throws IOException;
}
