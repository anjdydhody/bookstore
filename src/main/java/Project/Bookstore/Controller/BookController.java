package Project.Bookstore.Controller;

import Project.Bookstore.Data.Dto.Req.BookPostReq;
import Project.Bookstore.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<HttpStatus> post(@RequestBody BookPostReq bookPostReq) {
        return bookService.post(bookPostReq);
    }
}
