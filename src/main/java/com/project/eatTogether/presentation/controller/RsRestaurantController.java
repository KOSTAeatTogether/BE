package com.project.eatTogether.presentation.controller;

import com.project.eatTogether.application.dto.RsCuisineCategoriesDTO;
import com.project.eatTogether.application.dto.RsRestaurantMapReadResponse;
import com.project.eatTogether.application.dto.restaurantDto.CategoryDto;
import com.project.eatTogether.application.dto.restaurantDto.RestaurantDepositResponse;
import com.project.eatTogether.application.service.RestaurantInfoService;
import com.project.eatTogether.application.service.RsCuisineCategoriesService;
import com.project.eatTogether.application.service.RsRestaurantDetailService;
import com.project.eatTogether.domain.enums.CuisineType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RsRestaurantController {

    //    private final RsCuisineCategoriesService cuisineCategoriesService;
    private final RsRestaurantDetailService restaurantDetailService;
    private final RsCuisineCategoriesService cuisineCategoryService;
    //    private final RsRestaurantService restaurantService;
    private final RestaurantInfoService restaurantInfoService;


    /**동진씨가 만든 음식 종류별 카테고리 불러오는 부분*/
//    @GetMapping("/cuisine-category")
//    public List<RsCuisineCategoriesDTO> getCuisineCategory(@RequestParam String categoryName,
//                                                           @RequestParam(defaultValue = "0") int page,
//                                                           @RequestParam(defaultValue = "10") int size) {
//        return cuisineCategoryService.getCuisineCategoryByName(categoryName, page, size);
//    }

    @GetMapping("/cuisine-category")
    public List<RsCuisineCategoriesDTO> getCuisineCategory(
            @RequestParam CuisineType categoryType,  // String 대신 CuisineType으로 변경
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return cuisineCategoryService.getCuisineCategoryByType(categoryType, page, size);
    }
    
    @GetMapping("/all_thousand_addr")
    public List<RsRestaurantMapReadResponse> getRestaurantMapAddress(){
        Long id = 1L;
        return restaurantDetailService.getRestaurantMapAddress(id);
    }

    @PutMapping("/close")
    public ResponseEntity<HttpStatus> closeRestaurant(@RequestParam String state) {
        Long id = 1L;
        return restaurantDetailService.deleteRestaurant(id, state);
    }

    //전체식당조회
//    @GetMapping
//    public ResponseEntity<?> getAllRestaurants() {
//        try {
//            List<RestaurantResponseDto> restaurants = restaurantService.findAllRsRestaurants();
//            return ResponseEntity.ok(restaurants);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//    @GetMapping("/{rsId}/coordinates")
//    public ResponseEntity<RsCoordinatesDTO> getRestaurantCoordinates(@PathVariable Long rsId) {
//        RsCoordinatesDTO coordinates = restaurantService.getRestaurantCoordinates(rsId);
//        return ResponseEntity.ok(coordinates);
//    }
//
//    @GetMapping("/all-coordinates")
//    public ResponseEntity<List<RestaurantLocationDto>> getAllRestaurantCoordinates() {
//        List<RestaurantLocationDto> locations = restaurantService.getAllRestaurantLocations();
//        return ResponseEntity.ok(locations);
//    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        List<CategoryDto> categories = Arrays.stream(CuisineType.values())
                .map(type -> CategoryDto.builder()
                        .id(Long.valueOf(type.ordinal()))  // enum의 순서를 ID로 사용
                        .name(type.getDisplayName())       // 표시될 이름 (한글명)
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(categories);
    }

    //예약금 조회
    @GetMapping("/{rsId}/deposit-info")
    public ResponseEntity<RestaurantDepositResponse> getRestaurantDepositInfo(
            @PathVariable Long rsId) {
        RestaurantDepositResponse depositInfo = restaurantInfoService.getDepositInfo(rsId);
        return ResponseEntity.ok(depositInfo);
    }
}