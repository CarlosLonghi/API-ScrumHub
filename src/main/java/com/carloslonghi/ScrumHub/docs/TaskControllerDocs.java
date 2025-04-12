package com.carloslonghi.ScrumHub.docs;

import com.carloslonghi.ScrumHub.dto.TaskDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tarefas", description = "Operações relacionadas às Tarefas")
public interface TaskControllerDocs {

    @Operation(summary = "Listar Tarefas", description = "Rota para LISTAR todas as tarefas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefas listadas com sucesso")
    })
    ResponseEntity<List<TaskDTO>> getAll();

    @Operation(summary = "Cadastrar Tarefa", description = "Rota para CRIAR uma nova tarefa.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarefa cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro no cadastro da tarefa")
    })
    ResponseEntity<String> create(@RequestBody TaskDTO task);

    @Operation(summary = "Buscar Tarefa por ID", description = "Rota para BUSCAR uma tarefa por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    ResponseEntity<?> getById(@PathVariable Long id);

    @Operation(summary = "Atualizar Tarefa por ID", description = "Rota para ATUALIZAR uma tarefa existente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody TaskDTO task);

    @Operation(summary = "Deletar Tarefa por ID", description = "Rota para DELETAR uma tarefa existente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    ResponseEntity<String> deleteById(@PathVariable Long id);
}
