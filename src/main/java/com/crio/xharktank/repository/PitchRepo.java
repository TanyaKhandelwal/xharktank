package com.crio.xharktank.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.crio.xharktank.criocollection.Offer;
import com.crio.xharktank.criocollection.Pitch;

@Repository
public interface PitchRepo extends MongoRepository<Pitch, String>{
	
//	@Query(sort="{'createdOn':-1}")
	List<Pitch> findById(int pitchid);
	boolean existsById(String pitchid);
	
//	@Query(sort="{'createdOn':-1}")
//	List<Pitch> findAll();

}
