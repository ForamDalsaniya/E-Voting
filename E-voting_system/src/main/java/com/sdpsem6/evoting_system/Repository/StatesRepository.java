package com.sdpsem6.evoting_system.Repository;

import com.sdpsem6.evoting_system.Models.States;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesRepository extends MongoRepository<States,String> {
    States findStatesByStateName(String name);
}
