package dev.esternit.runnerz.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientRunRepository {

    private static final Logger log = LoggerFactory.getLogger(JdbcClientRunRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM run")
                .query(Run.class)
                .list();
    }




    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM Run WHERE id = :id" )
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public void create(Run run) {
        var updated = jdbcClient.sql("INSERT INTO Run(id,title,start_time,end_time,miles,location) values(?,?,?,?,?,?)")
                .params(List.of(run.id(),run.title(),run.startTime(),run.endTime(),run.miles(),run.location().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create run " + run.title());
    }

    public void update(Run run, Integer id) {
        var updated = jdbcClient.sql("update run set title = ?, start_time = ?, end_time = ?, miles = ?, location = ? where id = ?")
                .params(List.of(run.title(),run.startTime(),run.endTime(),run.miles(),run.location().toString(), id))
                .update();

        Assert.state(updated == 1, "Failed to update run " + run.title());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from run where id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete run " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from run").query().listOfRows().size();
    }

    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }

    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("select * from run where location = :location")
                .param("location", location)
                .query(Run.class)
                .list();
    }




//    List<Run> findAll() {
//        return runs;
//    }
//
//    Optional<Run> findById(Integer id) {
//        return runs.stream().filter(run -> run.id() == id).findFirst();
//    }
//
//    void create(Run run){
//        runs.add(run);
//    }
//
//    void update(Run run, Integer id){
//        Optional<Run> existingRun = findById(id);
//        if(existingRun.isPresent()){
//            runs.set(runs.indexOf(existingRun.get()), run);
//        }
//    }
//
//    void delete(Integer id){
//        runs.removeIf(run -> run.id().equals(id));
//    }
//
//    @PostConstruct
//    private void init() {
//        Run run = new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
//        runs.add(run);
//        Run run2 = new Run(2, "Run 2", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 10, Location.INDOOR);
//        runs.add(run2);
//    }
}
