package menu.view;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void startRecommand() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResult(List<MenuCategory> menuCategories, List<Coach> coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        List<String> menuNames = new ArrayList<>();
        for (MenuCategory menuCategory : menuCategories) {
            menuNames.add(menuCategory.name());
        }
        Map<String, List<String>> recommendResults = new HashMap<>();
        for (Coach coach : coaches) {
            recommendResults.put(coach.getName(), coach.getRecommendMenus());
        }
        System.out.println("[ 카테고리 | " + String.join(" | ", menuNames) + " ]");
        for (Map.Entry<String, List<String>> stringListEntry : recommendResults.entrySet()) {
            System.out.println("[ " + stringListEntry.getKey() + " | " + String.join(" | ", stringListEntry.getValue()) + " ]");
        }
        System.out.println("추천을 완료했습니다.");
    }
}
