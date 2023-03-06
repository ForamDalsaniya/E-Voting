package com.sdpsem6.evoting_system.Repository;

import com.sdpsem6.evoting_system.Models.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//public interface CandidateRepository extends Mon {
public interface CandidateRepository extends MongoRepository<Candidate,String> {

//    public List<Candidate> getCandidatesByState(String state);
//    List<Candidate> findAllByState(String state);
    List<Candidate> findAllByStateAndConstituency(String state, String constituency);
}
