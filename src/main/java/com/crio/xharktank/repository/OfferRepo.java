package com.crio.xharktank.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crio.xharktank.criocollection.Offer;

@Repository
public interface OfferRepo extends MongoRepository<Offer,String>{

}
