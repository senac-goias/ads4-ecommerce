package br.go.senac.ads4.service;

import br.go.senac.ads4.dto.UserDto;
import br.go.senac.ads4.interfaces.IService;
import br.go.senac.ads4.model.UserModel;
import br.go.senac.ads4.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService implements IService<UserDto, Integer> {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public UserDto create(UserDto entity) {
        log.info("UserService::create");
        log.debug("Valores: {}", entity);

        //Neste ponto precisamos transformar o objeto DTO para Model

        //Fazer alteração no banco de dados
        userRepository.save(null);

        //Retornar a entidade que foi persistida
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto read(Integer id) {
        log.info("UserService::read(id)");
        log.debug("Valores: {}", id);

        //Faz pesquisa(busca) o user com o Id informado
        Optional<UserModel> userFound = userRepository.findById(id);
        UserModel userQueVaiReceberObjetoTratado;

        //Verifica se o objeto tem valor
        if(userFound.isPresent()){
            //Obtém o valor contido dentro de Optional
            userQueVaiReceberObjetoTratado = userFound.get();
        }

        //Converter MODEL > DTO


        //Retornar objeto convertido

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> read() {
        log.info("UserService::read()");
        log.debug("Valores: sem parâmetros");

        //Pesquisa a lista de usuários
        List<UserModel> listUserModel = userRepository.findAll();

        //Converter lista de List<UserModel> >>> List<UserDto>


        //Retornar a lista de DTOS (List<UserDto)

        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public UserDto update(Integer id, UserDto entity) {
        log.info("UserService::update");
        log.debug("Valores: {} e {}", id, entity);

        //01 - Consulta o registro para verificar se o ID existe
        //TODO Corrigir a exception
        Optional<UserModel> userFound = userRepository.findById(id);
        UserModel userPresente = new UserModel();
        if(userFound.isPresent() && !userFound.isEmpty()){
            userPresente = userFound.get();
        }

        //02 - Pega o objeto consultado e fazer a atualização dos dados
        //Vamos copiar
        userPresente.setName(entity.getName());
        userPresente.setSurname(entity.getSurname());
        userPresente.setLocation(entity.getLocation());
        userPresente.setCity(entity.getCity());
        userPresente.setState(entity.getState());


        //03 - Converter MODEL > Dto


        //04 - Retonar o Dto

        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("UserService::delete");
        log.debug("Valores: {}", id);

        userRepository.deleteById(id);

    }
}
