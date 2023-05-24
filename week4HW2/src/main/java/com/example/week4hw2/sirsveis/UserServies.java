package com.example.week4hw2.sirsveis;
import com.example.week4hw2.ApiExsption.ApiExspion;
import com.example.week4hw2.Repostry.UserRepostry;
import com.example.week4hw2.model.user1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServies {
    private final UserRepostry userRepostry;

    public List<user1> getAlluser(){

        return userRepostry.findAll();
    }
    public void adduser(user1 user){

        userRepostry.save(user);
    }
    public Boolean updateuser(Integer ID, user1 user){
        user1 oldUser=userRepostry.getReferenceById(ID);
        if (oldUser==null){
            return false;
        }
        oldUser.setAge(user.getAge());
        oldUser.setName(user.getName());
        oldUser.setPassowrd(user.getPassowrd());
        userRepostry.save(oldUser);
        return true;
    }
    public Boolean deleteuser(Integer ID){
        user1 user = userRepostry.getById(ID);
        if (user == null)
            return false;
        userRepostry.delete(user);
        return true;
    }

    public user1 getCheckByUsernameAndPassowrd(String username, String passowrd){
        user1 user=userRepostry.findCheckByUsernameAndPassowrd(username,passowrd);
        if (username==username){
            throw  new ApiExspion("crrect");
        }
        if (passowrd==passowrd){
            return user;
        }
        return user;
    }


}
