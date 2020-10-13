package pl.zz.sharefood.service;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.domain.dto.FoodDto;
import pl.zz.sharefood.payload.PagedResponse;
import pl.zz.sharefood.repository.FoodRepository;
import pl.zz.sharefood.util.ValidatePageUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FoodGetService {

    private final FoodRepository foodRepository;

    FoodGetService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    public PagedResponse<FoodDto> getFood(List<String> foodNames, int page, int size){

        size = ValidatePageUtil.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size);

        Page<Food> foundFood = foodRepository.findByNameIn(foodNames, pageable);

        return getFoodPagedResponse(foundFood);
    }

    private PagedResponse<FoodDto> getFoodPagedResponse(Page<Food> foundFood) {
        if (foundFood.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), foundFood.getNumber(), foundFood.getSize(), foundFood.getTotalElements(), foundFood.getTotalPages(), foundFood.isLast());
        }
        List<FoodDto> foodDto = new ArrayList<>();
        BeanUtils.copyProperties(foodDto, foundFood.getContent());

        return new PagedResponse<>(foodDto, foundFood.getNumber(), foundFood.getSize(), foundFood.getTotalElements(), foundFood.getTotalPages(), foundFood.isLast());
    }
}
