package com.sdpsem6.evoting_system.Repository;

import com.sdpsem6.evoting_system.Models.Constituency;
import com.sdpsem6.evoting_system.Models.States;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface ConstituencyRepository extends MongoRepository<Constituency,String> {
    List<Constituency> getConstituenciesByState(States state);
//    List<Constituency> getConstituenciesByState_StateName(String state);
}
