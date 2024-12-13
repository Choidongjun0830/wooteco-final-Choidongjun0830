package menu.domain;

public class Menu {

    private String name;
    private MenuCategory menuCategory;

    public Menu(String name, MenuCategory menuCategory) {
        this.name = name;
        this.menuCategory = menuCategory;
    }

    public String getName() {
        return name;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    @Override
    public String toString() {
        return name;
    }
}