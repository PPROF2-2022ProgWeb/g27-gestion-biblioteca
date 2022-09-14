package com.grupo27.libreria.repository;

import com.grupo27.libreria.model.Loan;
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

    @Query("SELECT l FROM Loan l WHERE l.user.name = ?1 AND l.user.lastName = ?2")
    List<Loan> listLoansByUserName(String name, String lastName);

    @Query("SELECT l FROM Loan l WHERE l.book.title = ?1")
    List<Loan> listLoansByBook(String title);
}
