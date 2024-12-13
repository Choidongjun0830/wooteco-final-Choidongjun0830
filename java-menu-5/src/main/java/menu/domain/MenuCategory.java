package menu.domain;

public enum MenuCategory {
    일식, 한식, 중식, 아시안, 양식;

    public MenuCategory getCategory(String category) {
        return MenuCategory.valueOf(category);
    }
}
