package dev.esternit.runnerz.run;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run, Integer> {

//    @Query("SELECT * FROM Run WHERE location = :location") - also a possible way to do it
    List<Run> findAllByLocation(String location);

}
