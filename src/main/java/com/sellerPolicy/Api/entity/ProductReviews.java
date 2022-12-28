package com.sellerPolicy.Api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_reviews")
public class ProductReviews {
	@Id
	@Column(name="Review_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int reviewId;
	
	@Column(name="Rating")
	int rating;
	
	@Column(name="Feedback",length=500)
	String feedback;
	
	@Column(name="Img_urls")
	String imagUrls;
	
	@Column(name="Date_Time")
	Date date;
	
	@Column(name="Reviwer_id")
	String reviwerId;
	
	@ManyToOne
    Product product;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getImagUrls() {
		return imagUrls;
	}

	public void setImagUrls(String imagUrls) {
		this.imagUrls = imagUrls;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReviwerId() {
		return reviwerId;
	}

	public void setReviwerId(String reviwerId) {
		this.reviwerId = reviwerId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
