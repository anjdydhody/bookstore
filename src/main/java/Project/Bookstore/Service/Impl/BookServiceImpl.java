package Project.Bookstore.Service.Impl;

import Project.Bookstore.Data.Dto.Req.BookPostReq;
import Project.Bookstore.Data.Dto.Res.BookGetRes;
import Project.Bookstore.Data.Entity.Book;
import Project.Bookstore.Repository.BookRepository;
import Project.Bookstore.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${site.path}")
    private String sitePath;
    private final BookRepository bookRepository;

    @Override
    public ResponseEntity<HttpStatus> post(BookPostReq bookPostReq, MultipartFile image) {
        String imageName = saveImage(image);
        bookRepository.save(Book.builder()
                .imagePath(sitePath + imageName)
                .title(bookPostReq.getTitle())
                .price(bookPostReq.getPrice())
                .author(bookPostReq.getAuthor())
                .description(bookPostReq.getDescription())
                .deleted(Boolean.FALSE)
                .build()
        );

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookGetRes> get(Integer id) {
        Optional<Book> optionalBook = bookRepository.findByIdAndDeleted(id, Boolean.FALSE);

        if (optionalBook.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new BookGetRes(
                optionalBook.get().getId(),
                optionalBook.get().getImagePath(),
                optionalBook.get().getTitle(),
                optionalBook.get().getPrice(),
                optionalBook.get().getAuthor(),
                optionalBook.get().getDescription()
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookGetRes>> getList() {
        List<BookGetRes> bookGetResList = new ArrayList<>();
        List<Book> bookList = bookRepository.findAllByDeleted(Boolean.FALSE);

        for (Book book : bookList) {
            bookGetResList.add(new BookGetRes(
                    book.getId(),
                    book.getImagePath(),
                    book.getTitle(),
                    book.getPrice(),
                    book.getAuthor(),
                    book.getDescription()
            ));
        }

        return new ResponseEntity<>(bookGetResList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> delete(Integer id) {
        Optional<Book> optionalBook = bookRepository.findByIdAndDeleted(id, Boolean.FALSE);

        if (optionalBook.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        optionalBook.get().setDeleted(Boolean.TRUE);
        bookRepository.save(optionalBook.get());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String saveImage(MultipartFile image) {
        String originalName = image.getOriginalFilename();
        String newName = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(originalName);
        String newPath = uploadPath + newName;
        Path filePath = Paths.get(newPath);

        try {
            Files.copy(image.getInputStream(), filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return newName;
    }
}
