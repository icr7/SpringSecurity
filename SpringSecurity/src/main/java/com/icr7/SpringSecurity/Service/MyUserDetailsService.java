package com.icr7.SpringSecurity.Service;

import com.icr7.SpringSecurity.Model.MyUserDetail;
import com.icr7.SpringSecurity.Repository.UserRepository;
import com.icr7.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserTable> users = userRepository.findByUserName(userName);
        if(users==null || users.get()==null){
            throw new UsernameNotFoundException("user: "+userName+" not found");
        }
        UserTable user = users.get();
        return new MyUserDetail(user.getUserName(),user.getPassword(), user.getRole());
    }
}
