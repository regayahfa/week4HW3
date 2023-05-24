package com.example.week4hw2.Repostry;
import com.example.week4hw2.model.user1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepostry extends JpaRepository<user1, Integer > {
    @Query("SELECT username, passowrd from user1 where username=? and passowrd=?")
    user1 findCheckByUsernameAndPassowrd(String Username, String passowrd);
@Query("SELECT email from user1 where email=username ")
    user1 finduser1sBy(String username , String email);

//@Query("select role from user1 where role )
List<user1>finduser1sByRole(String role);
@Query("select age from user1 where user1.age>?25 ")
List<user1>finduser1sByAge(Integer age);
}
