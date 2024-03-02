package Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.BookRepository;
import Dao.BorrowingRecordRepository;
import model.Book;
import model.BorrowingRecord;
import model.User;

import java.time.LocalDateTime;

@Service
public class BorrowingService {

	@Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Transactional
    public void borrowBook(User user, Book book) {
        // 檢查書籍是否已被借閱
        if (!bookRepository.existsById(book.getIsbn())) {
            throw new RuntimeException("書籍不存在");
        }

        // 創建借閱紀錄
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setUserId(user.getUserId());
        borrowingRecord.setInventoryId(Integer.valueOf(book.getIsbn()));
        borrowingRecord.setBorrowingTime(LocalDateTime.now());

        // 更新書籍狀態
        book.setAvailable(false);

        // 保存借閱紀錄和更新書籍狀態
        borrowingRecordRepository.save(borrowingRecord);
        bookRepository.save(book);
    }

    @Transactional
    public void returnBook(User user, Book book) {
        // 更新書籍狀態
        book.setAvailable(true);

        // 更新借閱紀錄的還書時間
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByUserIdAndInventoryId(user.getUserId(), book.getIsbn());
        borrowingRecord.setReturnTime(LocalDateTime.now());

        // 保存更新後的書籍狀態和借閱紀錄
        bookRepository.save(book);
        borrowingRecordRepository.save(borrowingRecord);
    }
}
