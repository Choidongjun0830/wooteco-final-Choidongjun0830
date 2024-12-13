package menu.service;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.dto.CoachCanNotEatDto;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.view.InputView;

import java.util.List;

public class MenuService {
    InputView inputView = new InputView();
    MenuRepository menuRepository = new MenuRepository();

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
                            coach.addNotEatMenu(menuByName);
                        }
                    }
                }
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
