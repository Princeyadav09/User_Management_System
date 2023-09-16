package com.cafe.management.system.service.lmpl;

import com.cafe.management.system.auth.JwtTokenService;
import com.cafe.management.system.constants.CafeContest;
import com.cafe.management.system.model.entities.User;
import com.cafe.management.system.model.request.UserDto;
import com.cafe.management.system.model.response.BasicResponse;
import com.cafe.management.system.model.response.LoginResponse;
import com.cafe.management.system.repository.UserRepository;
import com.cafe.management.system.service.UserService;
import com.cafe.management.system.utils.CafeUtils;
import com.cafe.management.system.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private AuthenticationManager authenticationManager;

    private UserRepository userRepository;

    @Autowired
    JwtTokenService jwtTokenService;

    public UserServiceImpl(
            UserRepository userRepository,
            AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Object> signUp(@Validated UserDto userDto) {
        try {
                User user = userRepository.findByEmail(userDto.getEmail());
                if (Objects.isNull(user) ) {
                    userRepository.save(Mapper.UserDtoToUser(userDto));
                    return CafeUtils.getResponseEntity(new BasicResponse<>(userDto,"Successfully Registered.",HttpStatus.OK.value()), HttpStatus.OK);
                } else {
                    return CafeUtils.getResponseEntity("Email already Exists", HttpStatus.BAD_REQUEST);
                }
        }catch (Exception ex){
            log.error("Exeception");
        }
        return CafeUtils.getResponseEntity(CafeContest.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Object> logIn(@Validated UserDto userDto){

            this.doAuthenticate(userDto.getEmail(),userDto.getPassword());

            String token = jwtTokenService.generateToken(userDto.getEmail());

            return CafeUtils.getResponseEntity(new LoginResponse<>("Logged In Successfully." , token ,HttpStatus.OK.value()), HttpStatus.OK);

    }

    private void doAuthenticate(String email, String password) {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    email  , password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }


}
