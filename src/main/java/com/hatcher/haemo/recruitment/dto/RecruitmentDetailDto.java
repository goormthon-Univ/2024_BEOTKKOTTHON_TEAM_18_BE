package com.hatcher.haemo.recruitment.dto;

public record RecruitmentDetailDto(Long recruitmentIdx,
                                   String type,
                                   String name,
                                   String leader,
                                   int participantNumber,
                                   Integer participantLimit,
                                   String description,
                                   boolean isLeader,
                                   boolean isRecruiting) {}
