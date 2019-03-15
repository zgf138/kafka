package com.vanvov.kafka.dao;

import com.vanvov.kafka.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper    //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface IUserMapper {

    int insertUser(User user);

    User findByUsername(@Param("username") String username);
}
