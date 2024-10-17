package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.model.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
