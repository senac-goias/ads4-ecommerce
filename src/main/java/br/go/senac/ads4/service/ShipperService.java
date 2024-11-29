package br.go.senac.ads4.service;

import br.go.senac.ads4.dto.ShipperDto;
import br.go.senac.ads4.interfaces.IService;
import br.go.senac.ads4.repository.ShipperRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShipperService implements IService<ShipperDto, Integer>{

    final ShipperRepository shipperRepository;

    public ShipperService(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }


    @Override
    public ShipperDto create(ShipperDto entity) {
        log.info("ShipperService::create");
        return null;
    }

    @Override
    public ShipperDto read(Integer id) {
        log.info("ShipperService::read(id)");
        return null;
    }

    @Override
    public List<ShipperDto> read() {
        log.info("ShipperService::read()");
        return List.of();
    }

    @Override
    public ShipperDto update(Integer id, ShipperDto entity) {
        log.info("ShipperService::update(id,entity");
        return null;
    }

    @Override
    public void delete(Integer id) {
        log.info("ShipperService::delete(id)");

    }
}
