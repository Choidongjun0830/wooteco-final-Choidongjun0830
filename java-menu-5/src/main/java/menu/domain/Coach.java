package menu.domain;

import java.util.ArrayList;
import java.util.List;

//코치는 2~5명.
public class Coach {
    // 이름은 2글자 ~ 4글자
    private String name;
    private List<String> recommendMenus = new ArrayList<>();
    private List<String> notEatMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public Coach(String name, List<String> recommendMenus, List<String> notEatMenus) {
        this.name = name;
        this.recommendMenus = recommendMenus;
        this.notEatMenus = notEatMenus;
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendMenus() {
        return recommendMenus;
    }

    public List<String> getNotEatMenus() {
        return notEatMenus;
    }

    public void addRecommendMenu(String menu) {
        recommendMenus.add(menu);
    }

    public void addNotEatMenu(String menu) {
        notEatMenus.add(menu);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", recommendMenus=" + recommendMenus +
                ", notEatMenus=" + notEatMenus +
                '}';
    }
}
