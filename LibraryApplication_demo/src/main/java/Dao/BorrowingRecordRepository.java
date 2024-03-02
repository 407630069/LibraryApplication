package Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.BorrowingRecord;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {

	BorrowingRecord findByUserIdAndInventoryId(int userId, String isbn);

	BorrowingRecord findByUserIdAndBookId(Integer userId, Integer bookId);
}
