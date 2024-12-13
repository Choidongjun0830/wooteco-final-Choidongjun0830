package menu.controller;

import menu.domain.Coach;
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

    public void startProcess() {
        outputView.startRecommand();
        List<Coach> coaches = coachService.getCoaches();
        menuService.initMenuCategories();
        for (Coach coach : coaches) {
            menuService.getCanNotEatMenus(coaches);
        }
        List<Coach> allCoaches = coachService.getAllCoaches();
        for (Coach coach : allCoaches) {
            System.out.println("coach = " + coach);
        }
    }
}
