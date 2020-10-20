package pl.zz.sharefood.payload;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagedResponse<T> {

  private List<T> data;

  private int page;

  private int size;

  private long totalElement;

  private int totalPages;

  private boolean last;

}
