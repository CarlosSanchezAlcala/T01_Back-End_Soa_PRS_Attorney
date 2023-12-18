package com.soa.canete.attorney.repository;

import com.soa.canete.attorney.domain.model.Attorney;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AttorneyRepository extends ReactiveCrudRepository<Attorney, Integer> {
}
