package com.hatcher.haemo.user.presentation;

import com.hatcher.haemo.common.exception.BaseException;
import com.hatcher.haemo.common.BaseResponse;
import com.hatcher.haemo.user.application.UserService;
import com.hatcher.haemo.user.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.hatcher.haemo.common.constants.RequestURI.user;
import static com.hatcher.haemo.common.enums.BaseResponseStatus.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping(user)
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping(value = "/signup")
    public BaseResponse<TokenResponse> signup(@RequestBody SignupRequest signupRequest) {
        try {
            return new BaseResponse<>(userService.signup(signupRequest));
         } catch(BaseException e) {
            return new BaseResponse<>(e.getStatus());
         }
    }

    // 로그인
    @PostMapping("/login")
    public BaseResponse<TokenResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            return new BaseResponse<>(userService.login(loginRequest));
        } catch(BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    // 닉네임 중복 체크
    @PostMapping("/nickname")
    public BaseResponse<String> validateNickname(@RequestBody NicknameRequest nicknameRequest) {
        try {
            userService.validateNickname(nicknameRequest.nickname());
            return new BaseResponse<>(SUCCESS);
        } catch(BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    // 아이디 중복 체크
    @PostMapping("/loginId")
    public BaseResponse<String> validateLoginId(@RequestBody LoginIdRequest loginIdRequest) {
        try {
            userService.validateLoginId(loginIdRequest.loginId());
            return new BaseResponse<>(SUCCESS);
        } catch(BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
