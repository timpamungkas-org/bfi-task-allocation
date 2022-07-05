package id.co.bfi.bfitaskallocation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.bfi.bfitaskallocation.dto.CreateDummyRequest;
import id.co.bfi.bfitaskallocation.dto.DummyResponse;
import id.co.bfi.bfitaskallocation.entity.Dummy;
import id.co.bfi.bfitaskallocation.repository.DummyRepository;
import id.co.bfi.bfitaskallocation.service.DummyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DummyServiceImpl implements DummyService {

  @Autowired
  private DummyRepository dummyRepository;

  @Override
  public DummyResponse getLatestDummy() {
    Dummy dummyModel = dummyRepository.findFirstByOrderByIdDesc().orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND)
      );

    log.info("Latest dummy record found !");

    return DummyResponse.builder()
      .id(dummyModel.getId())
      .name(dummyModel.getName())
      .code(dummyModel.getCode())
      .category(dummyModel.getCategory())
      .description(dummyModel.getDescription())
      .build();
  }

  @Override
  public DummyResponse getDummy(Long id) {
    Dummy dummyModel = dummyRepository.findById(id).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND)
      );

    log.info("Requested ID dummy record found !");

    return DummyResponse.builder()
      .id(dummyModel.getId())
      .name(dummyModel.getName())
      .code(dummyModel.getCode())
      .category(dummyModel.getCategory())
      .description(dummyModel.getDescription())
      .build();
  }

  @Override
  public DummyResponse createDummy(CreateDummyRequest createDummyRequest) {
    Dummy dummyModel = dummyRepository.save(Dummy.builder()
        .name(createDummyRequest.getName())
        .code(createDummyRequest.getCode())
        .category(createDummyRequest.getCategory())
        .description(createDummyRequest.getDescription())
        .build()
      );

    log.info("New dummy record created !");

    return DummyResponse.builder()
      .id(dummyModel.getId())
      .name(dummyModel.getName())
      .code(dummyModel.getCode())
      .category(dummyModel.getCategory())
      .description(dummyModel.getDescription())
      .build();
  }
}
