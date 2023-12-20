package com.persist.proposalStatus;

import com.dto.proposalStatus.ProposalStatusRequest;
import com.dto.proposalStatus.ProposalStatusResponse;
import com.exception.PersistentException;

import java.io.IOException;

public interface IProposalStatusPersist {

    ProposalStatusResponse getProposalStatusFromESBService(ProposalStatusRequest proposalStatusRequest) throws PersistentException,IOException;
}
