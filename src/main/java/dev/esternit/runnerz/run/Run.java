package dev.esternit.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(
                @Id
                Integer id,
                  @NotEmpty
                  String title,
                  LocalDateTime startTime,
                  LocalDateTime endTime,
                  @Positive
                  Integer miles,
                  Location location,
                @Version
                Integer version
) {

    public Run {
        if(!endTime.isAfter(startTime)){
            throw new IllegalArgumentException("End time must be after start time");
        }
    }
}
