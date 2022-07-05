package id.co.bfi.bfitaskallocation.service;

import id.co.bfi.bfitaskallocation.dto.CreateDummyRequest;
import id.co.bfi.bfitaskallocation.dto.DummyResponse;

public interface DummyService {
  public DummyResponse getLatestDummy();
  public DummyResponse getDummy(Long id);
  public DummyResponse createDummy(CreateDummyRequest createDummyRequest);
}
