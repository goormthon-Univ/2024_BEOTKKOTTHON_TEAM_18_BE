package com.hatcher.haemo.recruitment.presentation;

import com.hatcher.haemo.common.exception.BaseException;
import com.hatcher.haemo.common.BaseResponse;
import com.hatcher.haemo.recruitment.application.RecruitmentService;
import com.hatcher.haemo.recruitment.dto.RecruitmentPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.hatcher.haemo.common.constants.RequestURI.recruitment;

@RestController
@RequiredArgsConstructor
@RequestMapping(recruitment)
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    // 모집글 등록
    @PostMapping("")
    public BaseResponse<?> postRecruitment(@RequestBody RecruitmentPostRequest recruitmentPostRequest) {
       try {
            return recruitmentService.postRecruitment(recruitmentPostRequest);
        } catch(BaseException e) {
           return new BaseResponse<>(e.getStatus());
        }
    }

//    // 모집글 목록 조회
//    @GetMapping("")
//    public BaseResponse<RecruitmentListResponse> getRecruitmentList() {
//        try {
//            return BaseResponse.success(recruitmentService.getRecruitmentList());
//        } catch (BaseException e) {
//            throw e;
//        }
//    }
}
