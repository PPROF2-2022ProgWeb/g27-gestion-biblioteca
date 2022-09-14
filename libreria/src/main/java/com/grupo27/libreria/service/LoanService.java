package com.grupo27.libreria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo27.libreria.model.Loan;
import com.grupo27.libreria.repository.ILoanRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Data
@Service
public class LoanService {

    @Autowired
    private ILoanRepository loanRepository;
    private final Logger LOGGER = Logger.getLogger((String.valueOf(LoanService.class)));

    @Autowired
    private ObjectMapper mapper;

    public LoanService(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    public Loan save(Loan loan)  {
        loanRepository.save(mapper.convertValue(loan, Loan.class));
        LOGGER.info("New loan saved successfully");
        return loan;
    }


    public Optional<Loan> findById(Long id) {
        LOGGER.info("Search by id in Loans entity");
        Optional<Loan> l = loanRepository.findById(id);
        if(l.isPresent()) {
            LOGGER.info("Loan founded");
        } else {
            LOGGER.info("The id does not match with any existing loan");
        }
        return l;
    }


    public List<Loan> findAll() {
        List<Loan> loans = loanRepository.findAll();
        LOGGER.info("List of all loans");
        return loans;
    }

    public Loan update(Loan newLoan) {
        Loan loan = loanRepository.findById(newLoan.getId()).get();
        loan.setDateOut(newLoan.getDateOut());
        loan.setDateReturn(newLoan.getDateReturn());
        loan.setBook(newLoan.getBook());
        loan.setUser(newLoan.getUser());

        LOGGER.info("Loan with ID: "+ loan.getId() + " has been updated");
        loanRepository.save(loan);
        return loan;
    }


    public void delete(Long id) {
        if(loanRepository.findById(id).isPresent()){
            loanRepository.deleteById(id);
            LOGGER.info("Loan deleted correctly!");
        } else {
            LOGGER.info("Loan was not found!");
        }
    }


    public List<Loan> listLoansByBook(String title){
        LOGGER.info("List of all loans by book");
        return loanRepository.listLoansByBook(title);
    }

    public List<Loan> listLoansByUser(String name, String lastName){
        LOGGER.info("List of all loans by user");
        return loanRepository.listLoansByUserName(name, lastName);
    }

    public List<Loan> listLoansByDate(String dateOut, String dateReturn) {

        List<Loan> filteredLoans = new ArrayList<>();

        if (dateOut != null && dateReturn != null) {
            LocalDate outDate = LocalDate.parse(dateOut);
            LocalDate returnDate = LocalDate.parse(dateReturn);

            if (outDate.isAfter(returnDate)) {
                LOGGER.info("The out date must be prior to the return date");
            }
           filteredLoans = loanRepository.listLoansByDateRange(dateOut, dateReturn);
        }
        if(dateOut!=null) {
            filteredLoans = loanRepository.listLoansByOutDate(dateOut);
        }
        if (dateReturn!= null){
            filteredLoans = loanRepository.listLoansByReturnDate(dateReturn);
        }
        LOGGER.info("List of all loans by date");
        return filteredLoans;
    }



}
