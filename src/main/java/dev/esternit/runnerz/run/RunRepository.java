package dev.esternit.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init() {
        Run run = new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
        runs.add(run);
        Run run2 = new Run(2, "Run 2", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 10, Location.INDOOR);
        runs.add(run2);
    }
}