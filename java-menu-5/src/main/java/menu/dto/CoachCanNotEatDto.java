package menu.dto;

import menu.domain.Menu;

import java.util.List;

public class CoachCanNotEatDto {
    private String name;
    private List<Menu> menus;

    public CoachCanNotEatDto(List<Menu> menus, String name) {
        this.menus = menus;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
