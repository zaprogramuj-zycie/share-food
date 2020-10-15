package pl.zz.sharefood.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.domain.dto.FoodDto;
import pl.zz.sharefood.payload.PagedResponse;
import pl.zz.sharefood.repository.FoodRepository;
import pl.zz.sharefood.requests.ListPageRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodListService {

    private final FoodRepository foodRepository;

    //    String DEFAULT_PAGE_NUMBER = "0";
    //    String DEFAULT_PAGE_SIZE = "10";


    public PagedResponse<FoodDto> execute(ListPageRequest listPageRequest){



        Pageable pageable = PageRequest.of(listPageRequest.getSize(), listPageRequest.getPage());

        Page<Food> foundFood = foodRepository.findAll(pageable);

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


    /*
    PagedResponseBuilder.create()
    .listFoodDto(listFoodDto)
    .foodEntityPage(foodEntityPage)
    .build();
     */

}
