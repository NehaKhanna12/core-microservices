package com.service.elixirUpdateEIA;

import com.dto.elixirUpdateEIA.ElixirUpdateEIARequest;
import com.dto.elixirUpdateEIA.ElixirUpdateEIAResponse;

import java.io.IOException;

public interface IElixirUpdateEIAService {

    ElixirUpdateEIAResponse updateEiaNumberToElixir(ElixirUpdateEIARequest elixirUpdateEIARequest) throws IOException;
}
