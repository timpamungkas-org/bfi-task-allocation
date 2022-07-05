package id.bfi.co.id.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import id.bfi.co.id.entity.Dummy;

@Repository
public interface DummyRepository extends CrudRepository<Dummy, Long> {
  public Optional<Dummy> findFirstByOrderByIdDesc();
}
