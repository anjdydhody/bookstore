package Project.Bookstore.Data.Dto.Res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookGetRes {

    private Integer id;
    private String imagePath;
    private String title;
    private Integer price;
    private String author;
    private String description;
}
