package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.domain.Community;
import com.example.olebackend.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommunityService {

    private final CommunityRepository communityRepository;
    public Page<Community> getCommunityList(Integer page) {

        Page<Community> communityList = communityRepository.findAll(PageRequest.of(page - 1, 10));

        // 전체 페이지 수 이상의 값을 입력했을 때
        if (page > communityList.getTotalPages()) {
            throw new GeneralException(PAGE_NOT_FOUND);
        }

        return communityList;
    }

    @Transactional
    public Optional<Community> getCommunity(Long communityId) {
        Optional<Community> community = communityRepository.findById(communityId);

        // communityId에 해당하는 글이 없는 경우
        if(community.isEmpty()){
            throw new GeneralException(COMMUNITY_NOT_FOUND);
        }

        community.ifPresent(Community::incrementViews);
        communityRepository.save(community.get());

        return community;
    }
}
