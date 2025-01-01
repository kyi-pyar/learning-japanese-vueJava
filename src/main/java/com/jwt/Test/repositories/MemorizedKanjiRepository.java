package com.jwt.Test.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.Test.entiites.MemorizedKanji;


@Repository
public interface MemorizedKanjiRepository extends CrudRepository<MemorizedKanji, Integer>{
 public List<MemorizedKanji> findByUser_id(int user_id);
}
