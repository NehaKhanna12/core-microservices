package com.service.apdBalance;

import com.dto.apdBalance.ApdBalanceRequest;
import com.dto.apdBalance.ApdBalanceResponse;
import com.exception.ServiceException;
import com.exception.BusinessException;
import com.exception.PersistentException;
import com.persist.apdBalance.IApdBalancePersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApdBalanceServiceImpl implements IApdBalanceService {

    private static final Logger logger = LoggerFactory.getLogger(ApdBalanceServiceImpl.class);

    @Autowired
    IApdBalancePersist iApdBalancePersist;

    @Override
    public ApdBalanceResponse getApdBalance(ApdBalanceRequest apdBalanceRequest) throws BusinessException {

        ApdBalanceResponse apdBalanceResponse = null;
        try {
            apdBalanceResponse =  iApdBalancePersist.fetchApdBalanceFromESBService(apdBalanceRequest);
        }catch(PersistentException ex){
            logger.error("Persistent Exception ApdBalanceServiceImpl : -" + ex.getMessage());
            throw new ServiceException("getApdBalance", ex);
        }
        return apdBalanceResponse;
    }
}
