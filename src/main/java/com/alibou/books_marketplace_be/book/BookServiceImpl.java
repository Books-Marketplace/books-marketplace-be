package com.alibou.books_marketplace_be.book;

import com.alibou.books_marketplace_be.user.UserInformation;
import com.alibou.books_marketplace_be.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final UserRepository userRepository;


    @Override
    public void createBook(BookRequest bookRequest, UserInformation admin) {
        if(bookRepository.existsByIsbn(bookRequest.getIsbn())){
            throw new RuntimeException("Book already exists");
        }
        try {
            Book book=bookMapper.mapToBookEntity(bookRequest,admin);
            bookRepository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("Failed to map book entity: " + e.getMessage());
        }


    }


    @Override
    public BookResponse findBookById(String bookId) {
        return bookRepository.findById(bookId)
                .map(bookMapper::mapToBookResponse)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public void updateBook(String adminId,String bookId, BookRequest bookRequest) {
        UserInformation admin=userRepository.findById( adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        Book book=bookRepository.findById( bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setIsbn(bookRequest.getIsbn());
        book.setAuthor(bookRequest.getAuthor());
        book.setDescription(bookRequest.getDescription());
        book.setPrice(bookRequest.getPrice());
        book.setImage(bookRequest.getImage());
        book.setTitle(bookRequest.getTitle());
        bookRepository.save(book);

    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<BookResponse> getAllBooks(int page ,int size) {
        PageRequest pageRequest=PageRequest.of(page,size);
        return bookRepository.findAll(pageRequest)
                .getContent()
                .stream()
                .map(bookMapper::mapToBookResponse)
                .toList();

    }

    @Override
    public List<BookResponse> getAllBooksByAuthor(String author ,int page ,int size) {
        Pageable pageable=PageRequest.of(page,size);
        return bookRepository.findAllByAuthor(author,pageable)
                .getContent()
                .stream()
                .map(bookMapper::mapToBookResponse)
                .toList();
    }

    @Override
    public List<BookResponse> filterBooksByCategory(String category ,int page ,int size) {
        Pageable pageable=PageRequest.of(page,size);
        return bookRepository.findAllByCategory(category,pageable)
                .getContent()
                .stream()
                .map(bookMapper::mapToBookResponse)
                .toList();
    }

    @Override
    public List<BookResponse> search(String keyword, int page, int pageSize) {
        Pageable pageable=PageRequest.of(page,pageSize);
        return bookRepository.findBookByKeyword(keyword,pageable)
                .getContent()
                .stream()
                .map(bookMapper::mapToBookResponse)
                .toList();
    }
}

