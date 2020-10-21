package pl.zz.sharefood.common.request;

import lombok.Getter;

@Getter
public class ListPageRequest {
  private int page;
  private int size;
}
