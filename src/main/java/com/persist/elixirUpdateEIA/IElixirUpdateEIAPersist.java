package com.persist.elixirUpdateEIA;

import com.dto.elixirUpdateEIA.ElixirUpdateEIARequest;
import com.dto.elixirUpdateEIA.ElixirUpdateEIAResponse;
import com.exception.PersistentException;

import java.io.IOException;

public interface IElixirUpdateEIAPersist {

    ElixirUpdateEIAResponse updateEiaNumber(ElixirUpdateEIARequest elixirUpdateEIARequest) throws PersistentException,IOException;
}
