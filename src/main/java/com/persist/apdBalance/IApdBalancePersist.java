package com.persist.apdBalance;

import com.dto.apdBalance.ApdBalanceRequest;
import com.dto.apdBalance.ApdBalanceResponse;

public interface IApdBalancePersist {

    ApdBalanceResponse fetchApdBalanceFromESBService(ApdBalanceRequest apdBalanceRequest);
}
