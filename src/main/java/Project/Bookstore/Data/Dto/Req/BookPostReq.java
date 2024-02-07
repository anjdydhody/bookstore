package Project.Bookstore.Data.Dto.Req;

import lombok.Data;

@Data
public class BookPostReq {

    private String imageNum;
    private String title;
    private Integer price;
    private String author;
    private String description;
}
