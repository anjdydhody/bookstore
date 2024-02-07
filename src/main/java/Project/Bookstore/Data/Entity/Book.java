package Project.Bookstore.Data.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    private Integer id;
    private String imageNum;
    private String title;
    private Integer price;
    private String author;
    private String description;
}
