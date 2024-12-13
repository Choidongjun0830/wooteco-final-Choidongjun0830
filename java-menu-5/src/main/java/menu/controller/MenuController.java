package menu.controller;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuCategory;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    MenuService menuService = new MenuService();
    CoachService coachService = new CoachService();

    public void setUpProcess() {
        outputView.startRecommand();
        List<Coach> coaches = coachService.getCoaches();
        menuService.initMenuCategories();
        menuService.getCanNotEatMenus(coaches);
    }

    public void recommendProcess() {
        List<MenuCategory> menuCategories = menuService.pickMenuCategories(); //결과 출력에 넘기기
        menuService.pickMenus(menuCategories, coachService.getAllCoaches());
        List<Coach> coaches = coachService.getAllCoaches();

        outputView.printResult(menuCategories, coaches);
    }
}
