package pl.zz.sharefood.requests;

import lombok.Getter;

@Getter
public class ListPageRequest {
  private int page;
  private int size;
}
