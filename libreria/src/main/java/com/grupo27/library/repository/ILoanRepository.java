package com.grupo27.library.repository;

import com.grupo27.library.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l WHERE l.dateOut = ?1 AND l.dateReturn = ?2")
    List<Loan> listLoansByDateRange(String dateOut, String dateReturn);

    @Query("SELECT l FROM Loan l WHERE l.dateOut = ?1")
    List<Loan> listLoansByOutDate(String dateOut);

    @Query("SELECT l FROM Loan l WHERE l.dateReturn = ?1")
    List<Loan> listLoansByReturnDate(String dateReturn);

    @Query("SELECT l FROM Loan l WHERE l.user.email = ?1")
    List<Loan> listLoansByUser(String email);

    @Query("SELECT l FROM Loan l WHERE l.book.title = ?1")
    List<Loan> listLoansByBook(String title);
}
