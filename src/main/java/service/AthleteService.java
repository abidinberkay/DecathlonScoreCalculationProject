package service;

import model.Athlete;
import model.Event;
import projectConstantsAndEnums.ConstantProperties;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AthleteService {

    private Integer fileIndex;
    private Integer position;
    private List<Athlete> athletesWithPositions;

    String samePosition(Integer begin, Integer end) {
        String response = "";
        for (Integer i = begin; i < (begin + end); i++)
            response = response + i.toString() + " - ";
        return response.substring(0, response.length() - 3);
    }

    public Athlete createAthlete(String row) {
        EventService eventService = new EventService();
        if (row == null || row.trim().length() < 1) {
            throw new IllegalArgumentException("The row [" + row + "] has no field, please check it");
        }
        if (row.split(ConstantProperties.FILE_SEPARATOR).length < ConstantProperties.MAX_NUMBER_OF_FIELD_IN_FILE + 1) {
            throw new IllegalArgumentException("The row [" + row + "] missing some fields, please check it");
        }
        if (row.split(ConstantProperties.FILE_SEPARATOR).length > ConstantProperties.MAX_NUMBER_OF_FIELD_IN_FILE + 1) {
            throw new IllegalArgumentException("The row [" + row + "] has more than expected value, please check it");
        }
        String name = row.split(ConstantProperties.FILE_SEPARATOR)[0];
        this.fileIndex = 1;
        String fields = row.substring(row.indexOf(ConstantProperties.FILE_SEPARATOR) + 1);
        List<Event> events = Stream.of(fields.split(ConstantProperties.FILE_SEPARATOR)).map(act -> eventService.createEvent(act)).collect(Collectors.toList());
        return new Athlete(name, getTotalScore(events), "0", events);
    }

    public List<Athlete> getAthletesWithResults(List<String> rows) {
        List<Athlete> athletes = new ArrayList<Athlete>();
        rows.forEach(row -> {
            athletes.add(this.createAthlete(row));
        });
        athletes.sort((a1, a2) -> a2.getTotalScore().compareTo(a1.getTotalScore()));
        this.position = 1;
        this.athletesWithPositions = new ArrayList<Athlete>();
        this.definePositionsForAthletes(athletes);
        return this.athletesWithPositions;
    }

    private void definePositionsForAthletes(List<Athlete> athletes) {
        List<Athlete> athlete = (List<Athlete>) athletes.stream().filter(athleteOne -> athleteOne.getFinalPosition().compareToIgnoreCase("0") == 0 && !this.athletesWithPositions.contains(athleteOne)).collect(Collectors.toList());
        if (athlete != null && athlete.size() > 0) {
            List<Athlete> duplicate = athletes.stream().filter(athleteOne -> athleteOne.getTotalScore().compareTo(athlete.get(0).getTotalScore()) == 0).collect(Collectors.toList());
            if (duplicate.size() > 0) {
                String position1 = this.samePosition(this.position, new Integer(duplicate.size()));
                duplicate.forEach(a -> a.setFinalPosition(position1));
                this.position = this.position + duplicate.size();
                this.athletesWithPositions.addAll(duplicate);
            } else {
                athlete.get(0).setFinalPosition(this.position.toString());
                this.athletesWithPositions.add(athlete.get(0));
                this.position++;
            }
            this.definePositionsForAthletes(athletes);
        }
    }

    private BigDecimal getTotalScore(List<Event> events) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Event e : events) {
            sum = sum.add(e.getScore());
        }
        return sum;
    }
}
