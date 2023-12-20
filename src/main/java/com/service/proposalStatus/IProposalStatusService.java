package com.service.proposalStatus;

import com.dto.proposalStatus.ProposalStatusRequest;
import com.dto.proposalStatus.ProposalStatusResponse;

import javax.validation.Valid;

public interface IProposalStatusService {

    ProposalStatusResponse getProposalStatus(@Valid ProposalStatusRequest proposalStatusRequest);
}
