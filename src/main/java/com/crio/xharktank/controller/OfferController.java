package com.crio.xharktank.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crio.xharktank.criocollection.Offer;
import com.crio.xharktank.criocollection.Pitch;
import com.crio.xharktank.repository.OfferRepo;
import com.crio.xharktank.repository.PitchRepo;
import com.crio.xharktank.service.PitchServiceImpl;

@RestController
@RequestMapping("/pitches")
public class OfferController {
	@Autowired private OfferRepo offerRepo;
	@Autowired private PitchRepo pitchRepo;

	@PostMapping("/{pitchid}/makeOffer")
    public ResponseEntity<?> save(@RequestBody @Valid Offer offers, @PathVariable("pitchid") String pitchid) {
		boolean exists = pitchRepo.existsById(pitchid);
		if(exists) {
	 offers.setId(PitchServiceImpl.generateOfferSequence(Offer.SEQUENCE_NAME));
        Offer savedPitch = offerRepo.save(offers);
//        
//        
//        ArrayList<Collections> o = new ArrayList<>();
//        Optional<Pitch> optstudent = pitchRepo.findById(pitchid);
//        Pitch s = optstudent.get();
//        o.add(Collections.singletonMap("investor",offers.getInvestor()));
//        System.out.println(offers);
//        for(int i=0;i<o.size();i++) {
//        	System.out.println(o.get(i));
//        }
////        s.setOffers(offers.getInvestor(),offers.getAmount(),offers.getEquity(),offers.getComment());
//        s.setOffers(o);
//        pitchRepo.save(s);
        
        
        return new ResponseEntity<>(Collections.singletonMap("id", savedPitch.getId()),HttpStatus.CREATED);
		}
		return new ResponseEntity<>("",HttpStatus.NOT_FOUND);
		
    }
}
