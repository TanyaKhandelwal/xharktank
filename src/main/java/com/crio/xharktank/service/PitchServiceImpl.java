package com.crio.xharktank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Collection;
import java.util.Objects;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;

import com.crio.xharktank.criocollection.PitchDatabaseSequence;
import com.crio.xharktank.criocollection.OfferDatabaseSequence;
import com.crio.xharktank.criocollection.Pitch;
import com.crio.xharktank.repository.PitchRepo;
@Service
public class PitchServiceImpl implements PitchService{
	
	@Autowired
	private PitchRepo pitchRepo;
	private static MongoOperations mongoOperations;

    @Autowired
    public PitchServiceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public static String generateSequence(String seqName) {

        PitchDatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                PitchDatabaseSequence.class);
        if(!Objects.isNull(counter)) return Integer.toString((int) counter.getSeq());
        else
        	return Integer.toString(1);
//        return Integer.toString(!Objects.isNull(counter) ? counter.getSeq() : 1);

    }
    
    public static String generateOfferSequence(String seqName) {

       OfferDatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                OfferDatabaseSequence.class);
       if(!Objects.isNull(counter)) return Integer.toString((int) counter.getSeq());
       else
       	return Integer.toString(1);

    }
	
}
