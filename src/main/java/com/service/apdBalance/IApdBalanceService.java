package com.service.apdBalance;

import com.dto.apdBalance.ApdBalanceRequest;
import com.dto.apdBalance.ApdBalanceResponse;

import java.io.IOException;

public interface IApdBalanceService {

    ApdBalanceResponse getApdBalance(ApdBalanceRequest apdBalanceRequest) throws IOException;
}
