package com.ldms.demo.amortisation;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "loanDetails", path = "loanDetails")
public interface LoanDetailsRepository extends PagingAndSortingRepository<LoanDetails, Long> {
}
