package menu.service;

import menu.domain.Coach;
import menu.repository.CoachRepository;
import menu.view.InputView;

import java.util.List;

public class CoachService {

    InputView inputView = new InputView();
    CoachRepository coachRepository = new CoachRepository();

    public List<Coach> getCoaches() {
        while(true) {
            try {
                List<String> coaches = List.of(inputView.getCoachesInput().split(","));
                if(coaches.size() < 2 || coaches.size() > 5) {
                    throw new IllegalArgumentException("[ERROR] 2명 이상, 5명 이하의 코치를 입력해주세요.");
                } //
                for (String coachName : coaches) {
                    if(coachName.length() < 2 || coachName.length() > 4) {
                        throw new IllegalArgumentException("[ERROR] 코치 이름의 길이는 2글자에서 4글자 사이로 입력해주세요.");
                    } //
                    Coach coach = new Coach(coachName);
                    coachRepository.addCoach(coach);
                }
                return coachRepository.getAllCoaches();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Coach> getAllCoaches() {
        return coachRepository.getAllCoaches();
    }
}
