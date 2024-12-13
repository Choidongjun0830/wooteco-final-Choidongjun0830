package menu.repository;

import menu.domain.Menu;
import menu.domain.MenuCategory;

import java.util.*;

public class MenuRepository {

    private final List<Menu> menus = new ArrayList<>();

    public void initMenuCategories() {
        String japanese = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
        String korean = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
        String chinese = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
        String asian = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
        String western = "양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
        initJapanese(japanese);
        initJKorean(korean);
        initChinese(chinese);
        initAsian(asian);
        initWestern(western);
    }

    public Menu getMenuByName(String name) {
        for (Menu menu : menus) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        return null;
    }

    private void initJapanese(String menu) {
        List<String> foods = List.of(menu.split(","));
        for (String food : foods) {
            food = food.trim();
            Menu addMenu = new Menu(food, MenuCategory.일식);
            menus.add(addMenu);
        }
    }

    private void initJKorean(String menu) {
        List<String> foods = List.of(menu.split(","));
        for (String food : foods) {
            food = food.trim();
            Menu addMenu = new Menu(food, MenuCategory.한식);
            menus.add(addMenu);
        }
    }

    private void initChinese(String menu) {
        List<String> foods = List.of(menu.split(","));
        for (String food : foods) {
            food = food.trim();
            Menu addMenu = new Menu(food, MenuCategory.중식);
            menus.add(addMenu);
        }
    }

    private void initAsian(String menu) {
        List<String> foods = List.of(menu.split(","));
        for (String food : foods) {
            food = food.trim();
            Menu addMenu = new Menu(food, MenuCategory.아시안);
            menus.add(addMenu);
        }
    }

    private void initWestern(String menu) {
        List<String> foods = List.of(menu.split(","));
        for (String food : foods) {
            food = food.trim();
            Menu addMenu = new Menu(food, MenuCategory.양식);
            menus.add(addMenu);
        }
    }
}
