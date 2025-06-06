package com.project.eatTogether.domain.entity;

import com.project.eatTogether.domain.entity.baseentity.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ReviewDeclare extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewDeclareId;

    @OneToOne
    @JoinColumn(name="rs_review_id")
    private RsReview rsReview;

    @Column
    private String reviewDeclareContent;    //신고 사유

    @Column(nullable = false)
    private LocalDate reviewDeclareCreatedAt;

    @Column
    private String reviewDeclareState;      //신고 상태


}
