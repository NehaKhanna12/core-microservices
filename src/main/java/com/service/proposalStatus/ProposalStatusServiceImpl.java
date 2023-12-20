package com.service.proposalStatus;

import com.dto.proposalStatus.ProposalStatusRequest;
import com.dto.proposalStatus.ProposalStatusResponse;
import com.exception.ServiceException;
import com.exception.BusinessException;
import com.exception.PersistentException;
import com.persist.proposalStatus.IProposalStatusPersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProposalStatusServiceImpl implements IProposalStatusService {

    private static final Logger logger = LoggerFactory.getLogger(ProposalStatusServiceImpl.class);

    @Autowired
    IProposalStatusPersist iProposalStatusPersist;

    @Override
    public ProposalStatusResponse getProposalStatus(ProposalStatusRequest proposalStatusRequest) throws BusinessException {

        ProposalStatusResponse proposalStatusResponse = null;
        try {
            proposalStatusResponse =  iProposalStatusPersist.getProposalStatusFromESBService(proposalStatusRequest);
        }catch(PersistentException |IOException ex){
            logger.error("Persistent Exception getProposalStatus  : -" + ex.getMessage());
            throw new ServiceException("getProposalStatus", ex);
        }
        return proposalStatusResponse;
    }
}
