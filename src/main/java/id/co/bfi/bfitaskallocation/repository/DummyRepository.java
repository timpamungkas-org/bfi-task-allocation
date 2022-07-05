package id.co.bfi.bfitaskallocation.repository;

import org.springframework.stereotype.Repository;

import id.co.bfi.bfitaskallocation.entity.Dummy;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface DummyRepository extends CrudRepository<Dummy, Long> {
  public Optional<Dummy> findFirstByOrderByIdDesc();
}
