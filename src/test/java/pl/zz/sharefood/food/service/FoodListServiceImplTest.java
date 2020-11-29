package pl.zz.sharefood.food.service;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.dto.FoodBaseDto;
import pl.zz.sharefood.food.repository.FoodRepository;
import pl.zz.sharefood.food.service.impl.FoodListServiceImpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FoodListServiceImplTest {

  @Spy
  FoodRepository foodRepository;
  @InjectMocks
  FoodListServiceImpl foodListServiceImpl;


  Food food;
  Food mockFood;

  private List<String> foodList = new ArrayList<>();
  private List<FoodBaseDto> foodOutput = new ArrayList<>();

  private int page = 0;
  private int size = 8;

  private Pageable pageable = PageRequest.of(page, size);
  private PageImpl<FoodBaseDto> pageContain = new PageImpl<>(foodOutput, pageable, 1);


  @BeforeEach
  public void initializeList() {
    foodList = new ArrayList<>();
    foodOutput = new ArrayList<>();
  }

  @BeforeAll
  public void setUp()
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    MockitoAnnotations.initMocks(this);

    Food food;

    food = Food.builder()
        .id(1L)
        .name("Apple")
        .amount(6).build();

    mockFood = food.getClass().getConstructor().newInstance();

    Mockito.when(foodRepository.save(food)).thenReturn(mockFood);
  }
}
