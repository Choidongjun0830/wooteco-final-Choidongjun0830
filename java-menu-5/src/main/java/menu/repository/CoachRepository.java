package menu.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    List<Coach> coaches = new ArrayList<>();

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public List<Coach> getAllCoaches() {
        return coaches;
    }
}
