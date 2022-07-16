package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.ReserveDto;
import com.it.dto.ReviewDto;
import com.it.entity.ReviewEntity;
import com.it.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ReviewRepository reviewRepository;

	public List<ReviewDto> findReviewsAll() {
		List<ReviewEntity> reserveEntities = reviewRepository.findAll();
		return modelMapper.map(reserveEntities, new TypeToken<List<ReserveDto>>() {}.getType());
	}
	
	
	public ReviewDto findByreviewId(Integer reId) {
		Optional<ReviewEntity> reviewOtn = reviewRepository.findById(reId);
		if (reviewOtn.isPresent()) {
			return modelMapper.map(reviewOtn.get(), new TypeToken<ReviewDto>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveReviews(ReviewDto reviewDto) {
		boolean saveFlg = false;
		try {
			ReviewEntity entity = modelMapper.map(reviewDto, ReviewEntity.class);
			reviewRepository.save(entity);
			saveFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updateReview(Integer reId, ReviewDto reviewDto) {
        boolean updateFlg  = false;
        try {
            Optional<ReviewEntity> reviewOtn = reviewRepository.findById(reId);
            if (reviewOtn.isPresent()) {
                ReviewEntity entity = modelMapper.map(reviewDto, ReviewEntity.class);
                reviewRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }

	
	public boolean deleteReviewById(Integer reId) {
		boolean deleteFlg = false;
		try {
			reviewRepository.deleteById(reId);;
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	

}





