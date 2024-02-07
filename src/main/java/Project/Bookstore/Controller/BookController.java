package Project.Bookstore.Controller;

import Project.Bookstore.Data.Dto.Req.BookPostReq;
import Project.Bookstore.Data.Dto.Res.BookGetRes;
import Project.Bookstore.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<HttpStatus> post(@RequestBody BookPostReq bookPostReq) {
        return bookService.post(bookPostReq);
    }

    @GetMapping
    public ResponseEntity<BookGetRes> get(@RequestParam Integer id) {
        return bookService.get(id);
    }
}
