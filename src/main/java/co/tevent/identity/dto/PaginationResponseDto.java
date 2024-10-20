package co.tevent.identity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginationResponseDto {
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;
    private Integer totalRecord;
}
