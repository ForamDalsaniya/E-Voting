package com.sdpsem6.evoting_system.Repository;

import com.sdpsem6.evoting_system.Models.Party;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends MongoRepository<Party, Integer> {
}
