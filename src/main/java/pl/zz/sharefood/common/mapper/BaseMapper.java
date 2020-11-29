package pl.zz.sharefood.common.mapper;

import org.springframework.beans.BeanUtils;

public class BaseMapper {

  public <B, R> R remapObject(B base, R result) {
    BeanUtils.copyProperties(base, result);
    return result;
  }
}
