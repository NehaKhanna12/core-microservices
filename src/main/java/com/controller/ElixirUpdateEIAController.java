package com.controller;

import com.dto.elixirUpdateEIA.ElixirUpdateEIARequest;
import com.dto.elixirUpdateEIA.ElixirUpdateEIAResponse;
import com.exception.APIRequestException;
import com.exception.ServiceException;
import com.service.elixirUpdateEIA.IElixirUpdateEIAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping(path = "/entity")
@Controller
public class ElixirUpdateEIAController {

    private static final Logger logger = LoggerFactory.getLogger(ElixirUpdateEIAController.class);

    @Autowired
    IElixirUpdateEIAService iElixirUpdateEIAService;

    @PostMapping(path="/elixirUpdateEiaNumber", produces = "application/json")
    public ResponseEntity<ElixirUpdateEIAResponse> elixirUpdateEiaNumber(@Valid @NotNull @RequestBody ElixirUpdateEIARequest elixirUpdateEIARequest)
    {
        ElixirUpdateEIAResponse elixirUpdateEIAResponse = null;
        try {
            elixirUpdateEIAResponse = iElixirUpdateEIAService.updateEiaNumberToElixir(elixirUpdateEIARequest);
        } catch (ServiceException ex) {
            logger.error(ex.getMessage());
            throw new APIRequestException("ESB Service Exception!", ex);
        }  catch (APIRequestException ex){
            logger.error(ex.getMessage());
            throw new APIRequestException("Invalid Request!", ex);
        }catch (Exception ex){
            logger.error(ex.toString());
            throw new APIRequestException("UnHandled Exception!", ex);
        }
        return new ResponseEntity<ElixirUpdateEIAResponse>(elixirUpdateEIAResponse, HttpStatus.OK);
    }
}
