package Project.Bookstore.Service;

import Project.Bookstore.Data.Dto.Req.BookPostReq;
import Project.Bookstore.Data.Dto.Res.BookGetRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface BookService {

    ResponseEntity<HttpStatus> post(BookPostReq bookPostReq);

    ResponseEntity<BookGetRes> get(Integer id);
}
