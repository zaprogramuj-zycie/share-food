package pl.zz.sharefood.common.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListPageRequest {

  private int page;
  private int size;
}
