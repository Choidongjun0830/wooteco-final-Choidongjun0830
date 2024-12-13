package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuCategory;
import menu.dto.CoachCanNotEatDto;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuService {
    InputView inputView = new InputView();
    MenuRepository menuRepository = new MenuRepository();
    CoachRepository coachRepository = new CoachRepository();

    public void initMenuCategories() {
        menuRepository.initMenuCategories();
    }

    public void getCanNotEatMenus(List<Coach> coaches) {
        while(true) {
            try {
                for (Coach coach : coaches) {
                    List<String> cannotEatMenus = List.of(inputView.getCannotEat(coach.getName()).split(","));
                    if(cannotEatMenus.size() > 2) {
                        throw new IllegalArgumentException("[ERROR] 못먹는 메뉴는  최대 2개여야 합니다.");
                    }
                    if(!cannotEatMenus.isEmpty()) {
                        for (String cannotEatMenu : cannotEatMenus) {
                            Menu menuByName = menuRepository.getMenuByName(cannotEatMenu);
                            if(menuByName == null) {
                                throw new IllegalArgumentException("[ERROR] 등록되지 않은 메뉴입니다.");
                            }
                            coach.addNotEatMenu(menuByName.getName());
                        }
                    }
                }
                return ;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<MenuCategory> pickMenuCategories() {
        boolean duplicateFailFlag = true;
        List<MenuCategory> menuCategories = new ArrayList<>();
        while (duplicateFailFlag) {
            menuCategories.clear();
            for(int i = 0; i < 5; i++) {
                MenuCategory categoryByIdx = MenuCategory.getCategoryByIdx(Randoms.pickNumberInRange(1, 5));
                menuCategories.add(categoryByIdx);
            }
            duplicateFailFlag = checkDuplicateOverThree(menuCategories);
        }
        return menuCategories;
    }

    public List<Menu> pickMenus(List<MenuCategory> menuCategories, List<Coach> coaches) {
        List<Menu> recommendMenus = new ArrayList<>();
        boolean duplicateFailFlag = true;

        while (duplicateFailFlag) {
            recommendMenus.clear();
            for (MenuCategory menuCategory : menuCategories) {
                List<String> menusByCategory = menuRepository.getMenusByCategory(menuCategory);
                for (Coach coach : coaches) {
                    String menuName = Randoms.shuffle(menusByCategory).get(0);
                    while(coach.getNotEatMenus().contains(menuName)) {
                        menuName = Randoms.shuffle(menusByCategory).get(0);
                    }
                    coach.addRecommendMenu(menuName);
                }
            }
            duplicateFailFlag = checkDuplicateMenu(recommendMenus);
        }
        return recommendMenus;
    }

    private boolean checkDuplicateOverThree(List<MenuCategory> menuCategories) {
        Map<MenuCategory, Integer> countResults = new HashMap<>();
        for (MenuCategory menuCategory : menuCategories) {
            countResults.put(menuCategory, countResults.getOrDefault(menuCategory, 0) + 1);
        }

        for (Integer count : countResults.values()) {
            if(count >= 3) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDuplicateMenu(List<Menu> menus) {
        Map<Menu, Integer> countResults = new HashMap<>();
        for (Menu menu : menus) {
            countResults.put(menu, countResults.getOrDefault(menu, 0) + 1);
        }

        for (Integer count : countResults.values()) {
            if(count >= 2) {
                return true;
            }
        }
        return false;
    }
}
