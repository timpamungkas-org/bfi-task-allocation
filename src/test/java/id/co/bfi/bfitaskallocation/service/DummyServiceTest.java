package id.co.bfi.bfitaskallocation.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import id.co.bfi.bfitaskallocation.repository.DummyRepository;
import id.co.bfi.bfitaskallocation.service.impl.DummyServiceImpl;

@ExtendWith(SpringExtension.class)
@ActiveProfiles(profiles = "unit-test")
class DummyServiceTest {

  @InjectMocks
  private DummyServiceImpl dummyService;

  @Mock
  private DummyRepository mockDummyRepository;

  @Test
  public void test_no_db_record_exists() {
    assertThrows(ResponseStatusException.class, () ->
      dummyService.getLatestDummy()
    );
  }
}
