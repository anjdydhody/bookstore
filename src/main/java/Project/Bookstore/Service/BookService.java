package Project.Bookstore.Service;

import Project.Bookstore.Data.Dto.Req.BookPostReq;
import Project.Bookstore.Data.Dto.Res.BookGetRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {

    ResponseEntity<HttpStatus> post(BookPostReq bookPostReq, MultipartFile image);

    ResponseEntity<BookGetRes> get(Integer id);

    ResponseEntity<List<BookGetRes>> getList();

    ResponseEntity<HttpStatus> delete(Integer id);
}
