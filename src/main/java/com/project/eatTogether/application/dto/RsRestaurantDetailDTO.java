package com.project.eatTogether.application.dto;

import com.project.eatTogether.application.dto.differed.coordinates.RsCoordinatesDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RsRestaurantDetailDTO {
    private RsRestaurantDTO restaurant; // 식당 정보
    private List<RsMenusDTO> menuItems; // 메뉴 정보
    private RsCoordinatesDto coordinates; // 좌표 정보
    private List<RsNewsDTO> newsItems; // 소식 정보
    private List<RsAmenitiesDTO> amenities; // 편의시설 정보
    private RsLocationCategoriesDTO locationCategory; // 위치 카테고리 정보
    private List<RsReviewDTO> reviews; // 리뷰 정보
}
