package br.go.senac.ads4.resource;

import br.go.senac.ads4.dto.ShipperDto;
import br.go.senac.ads4.interfaces.IResource;
import br.go.senac.ads4.service.ShipperService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/shipper")
public class ShipperResource implements IResource<ShipperDto, Integer>{

    final ShipperService shipperService;

    public ShipperResource(ShipperService shipperService) {
        this.shipperService = shipperService;
    }


    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ShipperDto create(@RequestBody ShipperDto entity) {
        log.info("ShipperResource::create");
        return null;
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    @GetMapping(value = "/{id}",
    produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ShipperDto get(@PathVariable Integer id) {
        log.info("ShipperResource::get(id)");
        return null;
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ShipperDto> get() {
        log.info("ShipperResource::get()");
        return List.of();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @Override
    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ShipperDto update(@PathVariable Integer id,
                             @RequestBody ShipperDto entity) {
        log.info("ShipperResource::update(id,entity)");
        return null;
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @Override
@DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("ShipperResource::delete(id)");

    }
}
