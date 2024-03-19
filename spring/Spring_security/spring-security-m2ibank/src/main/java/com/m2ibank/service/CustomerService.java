package com.m2ibank.service;

import com.m2ibank.model.Customer;
import com.m2ibank.repository.CustomerRepository;
import com.m2ibank.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;


    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    public boolean createUser(Customer user) {
        user.setPwd(passwordEncoder.encode(user.getPwd()));
        customerRepository.save(user);
        return true;

    }

    public boolean verifyUser(String email, String password) {
        return customerRepository.findByEmail(email).map(user -> passwordEncoder.matches(password, user.getPwd()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));

    }

    public String generateToken(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return token;


    }

    public boolean checkUsernameExists(String email) {
        return customerRepository.findByEmail(email).isPresent();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found with email : " + username));
    }
}
