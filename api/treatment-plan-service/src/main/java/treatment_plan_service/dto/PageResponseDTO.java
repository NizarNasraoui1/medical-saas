package treatment_plan_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResponseDTO<T> {
    private List<T> content;
    private long totalElements;
    private int totalPages;
    private int page;
    private int size;


}
