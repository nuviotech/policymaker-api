package com.sellerPolicy.Api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerPolicy.Api.entity.ProductReviews;

public interface ProductReviewRepository extends JpaRepository<ProductReviews, Integer>{

}
