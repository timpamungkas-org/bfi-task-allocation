package id.bfi.co.id.service;

import id.bfi.co.id.dto.CreateDummyRequest;
import id.bfi.co.id.dto.DummyResponse;

public interface DummyService {
  public DummyResponse getLatestDummy();
  public DummyResponse getDummy(Long id);
  public DummyResponse createDummy(CreateDummyRequest createDummyRequest);
}
