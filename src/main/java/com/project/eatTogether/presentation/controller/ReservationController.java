package com.project.eatTogether.presentation.controller;

import com.project.eatTogether.application.dto.differed.reservation.ReservationRequestDto;
import com.project.eatTogether.application.dto.restaurantDto.ReservationReadResponse;
import com.project.eatTogether.application.service.restaurantService.ReservationManagingService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping ("/api")
public class ReservationController {

    private final ReservationManagingService reservationManagingService;
    //전체 예약정보 조회
    @GetMapping("/reservations")
    public List<ReservationReadResponse> GetReservations(){
        Long id = 1L;
        return reservationManagingService.reservationList(id);
    }

    @GetMapping("/reservation/last-list")
    public List<ReservationReadResponse> GetReservationsLastList(){
        Long id =1L;
        return reservationManagingService.GetReservationsLastList(id);
    }

    //식당 예약정보 조회
    @GetMapping("/restaurants/{restaurantId}/reservations")
    public void GetRestaurantReservations() {
    }

    //특정회원 예약 조회
    @GetMapping("/users/{userId}/reservations")
    public void GetUserReservations() {
    }

    //예약생성
    @PostMapping("/reservations")
    public ResponseEntity<?> createReservations(@RequestBody ReservationRequestDto request) {
        return ResponseEntity.ok(reservationManagingService.createReservation(request));
    }

    //예약수정
    @PutMapping("/reservations/{reservationId}")
    public ResponseEntity<HttpStatus> UpdateReservation(@PathVariable Long reservationId,@RequestParam String state) {
        return reservationManagingService.updateReservationState(reservationId,state);
    }

    //예약삭제
    @DeleteMapping("/reservations/{reservationId}")
    public ResponseEntity<HttpStatus> DeleteReservation(@PathVariable Long reservationId) {
        return reservationManagingService.deleteReservation(reservationId);
    }


}
