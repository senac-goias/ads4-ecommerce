package br.go.senac.ads4.repository;

import br.go.senac.ads4.model.ShipperModel;
import com.sun.jdi.IntegerValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<ShipperModel, IntegerValue> {
}
