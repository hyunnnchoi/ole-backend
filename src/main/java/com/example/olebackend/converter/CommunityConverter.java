package com.example.olebackend.converter;

import com.example.olebackend.domain.Community;
import com.example.olebackend.domain.Member;
import com.example.olebackend.domain.mapping.CommunityComment;
import com.example.olebackend.web.dto.CommunityRequest;
import com.example.olebackend.web.dto.CommunityResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommunityConverter {

    public static CommunityResponse.getCommunityPreviewDTO toCommunityPreviewDTO(Community community) {
        Integer commentCount = community.getComments().size();

        return CommunityResponse.getCommunityPreviewDTO.builder()
                .id(community.getId())
                .title(community.getTitle())
                .body(community.getBody())
                .category(community.getCategory().toString())
                .commentCounts(commentCount)
                .views(community.getViews())
                .build();

    }

    public static CommunityResponse.getCommunityListDTO toCommunityListDTO(Page<Community> communityList) {
        List<CommunityResponse.getCommunityPreviewDTO> communityPreviewDTOList = communityList.stream()
                .map(CommunityConverter::toCommunityPreviewDTO).collect(Collectors.toList());

        return CommunityResponse.getCommunityListDTO.builder()
                .communityList(communityPreviewDTOList)
                .isLast(communityList.isLast())
                .isFirst(communityList.isFirst())
                .totalPage(communityList.getTotalPages())
                .totalElements(communityList.getTotalElements())
                .listSize(communityPreviewDTOList.size())
                .build();
    }

    public static CommunityResponse.getCommunityDetailDTO toCommunityDetailDTO(Optional<Community> community) {
        List<CommunityComment> communityCommentList = community.get().getComments();

        List<CommunityResponse.getCommunityCommentPreviewDTO> communityCommentPreviewDTOList = communityCommentList.stream()
                .map(CommunityConverter::toCommunityCommentPreviewDTO).collect(Collectors.toList());


        return CommunityResponse.getCommunityDetailDTO.builder()
                .title(community.get().getTitle())
                .body(community.get().getBody())
                .category(community.get().getCategory().toString())
                .views(community.get().getViews())
                .commentCounts(community.get().getComments().size())
                .memberName(community.get().getMember().getName())
                .createdAt(community.get().getCreatedAt())
                .communityCommentList(communityCommentPreviewDTOList)

                .build();
    }

    public static CommunityComment toCommunityComment(Community community, Member member, CommunityRequest.toCommunityComment request) {
        return CommunityComment.builder()
                .community(community)
                .member(member)
                .content(request.getContent())
                .build();
    }

    public static CommunityResponse.getCommunityCommentPreviewDTO toCommunityCommentPreviewDTO(CommunityComment comment) {
        return CommunityResponse.getCommunityCommentPreviewDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .likeCounts(comment.getLikeCount())
                .memberName(comment.getMember().getName())
                .createdAt(comment.getCreatedAt())
                .build();
    }

}

