package com.project.eatTogether.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Address {
    @Column(nullable = false)
    private String street;         // 도로명 주소

    @Column(nullable = false)
    private String detail;         // 상세 주소

    @Column(nullable = false)
    private String postcode;        // 우편번호

    @Column(nullable = true)
    private Float latitude;
    @Column(nullable = true)// 위도
    private Float longitude;      // 경도

    /** 전체 주소*/
    public String getFullAddress() {
        return String.format("[%s] %s %s", postcode, street, detail);
    }
}
