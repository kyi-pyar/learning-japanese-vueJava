package com.jwt.Test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.Test.entiites.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer>{

}
