package Project.Bookstore.Service.Impl;

import Project.Bookstore.Data.Dto.Req.BookPostReq;
import Project.Bookstore.Data.Entity.Book;
import Project.Bookstore.Repository.BookRepository;
import Project.Bookstore.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public ResponseEntity<HttpStatus> post(BookPostReq bookPostReq) {
        bookRepository.save(Book.builder()
                .imageNum(bookPostReq.getImageNum())
                .title(bookPostReq.getTitle())
                .price(bookPostReq.getPrice())
                .author(bookPostReq.getAuthor())
                .description(bookPostReq.getDescription())
                .build()
        );

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
