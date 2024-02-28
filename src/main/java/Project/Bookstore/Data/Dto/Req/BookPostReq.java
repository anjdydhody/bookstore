package Project.Bookstore.Data.Dto.Req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BookPostReq {

    @NotEmpty
    private String title;
    @NotEmpty
    private Integer price;
    @NotEmpty
    private String author;
    @NotEmpty
    private String description;
}
