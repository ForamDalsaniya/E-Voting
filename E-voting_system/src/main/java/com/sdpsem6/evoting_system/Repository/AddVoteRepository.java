package com.sdpsem6.evoting_system.Repository;

import com.sdpsem6.evoting_system.Models.AddVote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddVoteRepository extends MongoRepository<AddVote,Integer> {
}
