package com.example.springboot.dao;

import com.example.springboot.entity.TestDataPO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/6/22 10:53
 */
public interface UserRepository extends CrudRepository<TestDataPO, Long> {

    @Query("select t from TestDataPO t where t.cardId = :cardId")
    TestDataPO findFirstByCardId(@Param("cardId") String cardId);
}
