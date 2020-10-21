package pl.zz.sharefood.food.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.InvocationTargetException;

import pl.zz.sharefood.food.domain.Food;
import pl.zz.sharefood.food.service.FoodDeleteService;
import pl.zz.sharefood.food.repository.FoodRepository;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FoodDeleteServiceTest {

    @Mock
    private FoodRepository foodRepository;
    @InjectMocks
    private FoodDeleteService foodDeleteService;

    @BeforeAll
    public void setUp() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MockitoAnnotations.initMocks(this);

        Food food = Food.builder()
                .id(1L).build();

        foodRepository.save(food);

        Food mockFood = food.getClass().getConstructor().newInstance();

        Mockito.when(foodRepository.save(food)).thenReturn(mockFood);

    }

    @Test
    public void shouldDeleteFood() {

        //Mockito.when(foodDeleteService.foodDeleteService(1L)).thenReturn(Optional.of(new Date()));

    }

    @Test
    public void shouldThrowExceptionWhenDeleteFood() {

        /*
        assertThrows(
                ResourceNotFoundException.class,
                () -> foodDeleteService.foodDeleteService(5L)
        );

         */
    }




}
