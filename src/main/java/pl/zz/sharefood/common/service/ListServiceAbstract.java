package pl.zz.sharefood.common.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.zz.sharefood.common.dto.PagedResponseDto;
import pl.zz.sharefood.common.request.ListPageRequest;

public abstract class ListServiceAbstract<E, D> {

  protected abstract Page<E> getEntities(Pageable pageable);

  protected abstract List<D> getDtos(Page<E> listEntities);

  protected abstract PagedResponseDto<?> getPagedResponse(Page<E> listFood, List<D> listFoodDto);

  public PagedResponseDto<?> execute(ListPageRequest listPageRequest) {
    Pageable pageable = PageRequest.of(listPageRequest.getPage(), listPageRequest.getSize());
    Page<E> listFood = getEntities(pageable);
    List<D> listFoodDto = getDtos(listFood);

    return getPagedResponse(listFood, listFoodDto);
  }
}
