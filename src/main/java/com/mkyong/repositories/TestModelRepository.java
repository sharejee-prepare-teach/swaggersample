package com.mkyong.repositories;

import com.mkyong.models.TestModel;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
public interface TestModelRepository extends PagingAndSortingRepository<TestModel,Long> {
}
