package pl.zz.sharefood.common.builder;

import java.util.List;
import org.springframework.data.domain.Page;
import pl.zz.sharefood.common.dto.PagedResponseDto;

public class PagedResponseDtoBuilder<E, D> {

  protected List<D> listDtos;
  protected Page<E> entityPage;

  public PagedResponseDto<?> build() {
    return new PagedResponseDto<>(
        listDtos,
        entityPage.getNumber(),
        entityPage.getSize(),
        entityPage.getTotalElements(),
        entityPage.getTotalPages(),
        entityPage.isLast()
    );
  }
}
