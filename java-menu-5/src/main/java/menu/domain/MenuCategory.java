package menu.domain;

public enum MenuCategory {
    일식(1),
    한식(2),
    중식(3),
    아시안(4),
    양식(5);

    private int idx;

    MenuCategory(int idx) {
        this.idx = idx;
    }

    public static MenuCategory getCategory(String category) {
        return MenuCategory.valueOf(category);
    }

    public static MenuCategory getCategoryByIdx(int idx) {
        for(MenuCategory category : MenuCategory.values()) {
            if(category.idx == idx) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid idx: " + idx);
    }

    @Override
    public String toString() {
        return name();
    }
}
