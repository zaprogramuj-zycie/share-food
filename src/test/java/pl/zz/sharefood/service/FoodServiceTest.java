package pl.zz.sharefood.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.repository.FoodRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FoodServiceTest {

    @InjectMocks
    private FoodServiceImpl foodService;
    @Mock
    private FoodRepository foodRepository;
    @Test
    void shouldSaveFood(){
        Food food= new Food();
        when(foodRepository.save(any())).thenReturn(food);

        Food result = foodService.save(new Food());

        assertThat(result).isEqualTo(food);
    }
}
