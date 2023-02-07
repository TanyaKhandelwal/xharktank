package com.crio.xharktank.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.crio.xharktank.criocollection.Offer;
import com.crio.xharktank.criocollection.Pitch;
import com.crio.xharktank.repository.PitchRepo;
import com.crio.xharktank.service.PitchService;
import com.crio.xharktank.service.PitchServiceImpl;
import com.mongodb.client.result.UpdateResult;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOptions;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
//import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.mongodb.core.query.Update;

@RestController
@RequestMapping("/pitches")
public class PitchController {
	
//	private PitchService pitchService;
	@Autowired private PitchRepo pitchRepo;
	@Autowired
    private MongoTemplate mongoTemplate;
	@Autowired private static MongoOperations mongoOperations;
	
	 @PostMapping()
	    public ResponseEntity<?> save(@RequestBody @Valid Pitch pitch) {
		 pitch.setId(PitchServiceImpl.generateSequence(Pitch.SEQUENCE_NAME));
	        Pitch savedPitch = pitchRepo.save(pitch);
	        return new ResponseEntity<>(Collections.singletonMap("id", savedPitch.getId()),HttpStatus.CREATED);
	        
	        
	    }
	@GetMapping()
	 public List<Pitch> list() {	
		List<Pitch> pitches = pitchRepo.findAll(Sort.by(Sort.Direction.DESC,"createdOn"));	
		return pitches;
		}
	
	
	@GetMapping("/{pitchid}")
	public ResponseEntity<?> getEntryByUser(@PathVariable("pitchid") String pitchid) {
		// TODO Auto-generated method stub
		boolean exists = pitchRepo.existsById(pitchid);
		if(exists) {
        return new ResponseEntity<>(pitchRepo.findById(pitchid),HttpStatus.OK);
		}
		return new ResponseEntity<>("",HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/save")
//	public void getAndSaveStocks() {
//
//		RestTemplate restTemplate = new RestTemplate();
//		StockData stockData = restTemplate.getForObject(Constants.API,StockData.class);
//		List<Company> sl = stockData.getCompanies();
//
//		PastPrice pastPrice = new PastPrice();
//		List<Price> prices = new ArrayList<>();
//		for (Company company : sl) {
//		    Price price = new Price();
//		    price.setDate(CurrentDate.getCurrentTimeWithTimeZone());
//		    price.setPrice(company.getLTP());
//		    prices.add(price);
//
//		}
//
//		pastPrice.setSymbol(company.getSymbol());
//		pastPrice.setPrices(prices); 
//
//	    }
	
}
