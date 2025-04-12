package com.carloslonghi.ScrumHub.docs;

import com.carloslonghi.ScrumHub.dto.EmployeeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Funcionários", description = "Operações relacionadas aos Funcionários")
public interface EmployeeControllerDocs {

    @Operation(summary = "Listar Funcionários", description = "Rota para LISTAR os funcionários cadastrados, assim como suas respectivas tarefas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionários listados com sucesso")
    })
    ResponseEntity<List<EmployeeDTO>> getAll();

    @Operation(summary = "Cadastrar Funcionário", description = "Rota para CRIAR um novo funcionário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Funcionário cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro no cadastro do Funcionário")
    })
    ResponseEntity<String> create(@RequestBody EmployeeDTO employee);

    @Operation(summary = "Buscar Funcionário por ID", description = "Rota para BUSCAR funcionário cadastrado por ID")
    ResponseEntity<?> getById(@PathVariable Long id);

    @Operation(summary = "Atualizar Funcionário por ID", description = "Rota para ATUALIZAR funcionário cadastrado por ID")
    ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody EmployeeDTO employee);

    @Operation(summary = "Deletar Funcionário por ID", description = "Rota para DELETAR funcionário cadastrado por ID")
    ResponseEntity<String> deleteById(@PathVariable Long id);
}
