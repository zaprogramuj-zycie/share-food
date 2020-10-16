package pl.zz.sharefood.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.Food;
import pl.zz.sharefood.domain.PagedResponseBuilder;
import pl.zz.sharefood.domain.dto.FoodDto;
import pl.zz.sharefood.payload.PagedResponse;
import pl.zz.sharefood.repository.FoodRepository;
import pl.zz.sharefood.requests.ListPageRequest;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodListService {

    private final FoodRepository foodRepository;
    
    public PagedResponse<?> execute(ListPageRequest listPageRequest){

        Pageable pageable = PageRequest.of(listPageRequest.getSize(), listPageRequest.getPage());

        Page<Food> listFood = foodRepository.findAll(pageable);

        List<FoodDto> listFoodDto= mapFoodToDto(listFood);

        return PagedResponseBuilder.create()
            .listFoodDto(listFoodDto)
            .foodEntityPage(listFood)
            .build();
    }

    public List<FoodDto> mapFoodToDto (Page<Food> listFood ) {
        List<FoodDto> listFoodDto = new ArrayList<>();
        BeanUtils.copyProperties(listFoodDto, listFood.getContent());
        return listFoodDto;
    }
}
