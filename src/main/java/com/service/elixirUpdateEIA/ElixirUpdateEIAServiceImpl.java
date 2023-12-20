package com.service.elixirUpdateEIA;

import com.dto.elixirUpdateEIA.ElixirUpdateEIARequest;
import com.dto.elixirUpdateEIA.ElixirUpdateEIAResponse;
import com.exception.BusinessException;
import com.exception.PersistentException;
import com.exception.ServiceException;
import com.persist.elixirUpdateEIA.IElixirUpdateEIAPersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElixirUpdateEIAServiceImpl implements IElixirUpdateEIAService {

    private static final Logger logger = LoggerFactory.getLogger(ElixirUpdateEIAServiceImpl.class);

    @Autowired
    IElixirUpdateEIAPersist iElixirUpdateEIAPersist;

    @Override
    public ElixirUpdateEIAResponse updateEiaNumberToElixir(ElixirUpdateEIARequest elixirUpdateEIARequest) throws BusinessException {

        ElixirUpdateEIAResponse elixirUpdateEIAResponse = null;
        try {
            elixirUpdateEIAResponse =  iElixirUpdateEIAPersist.updateEiaNumber(elixirUpdateEIARequest);
        }catch(PersistentException |IOException ex){
            logger.error("Persistent Exception ElixirUpdateEIAServiceImpl : -" + ex.getMessage());
            throw new ServiceException("updateEiaNumberToElixir", ex);
        }
        return elixirUpdateEIAResponse;
    }
}
