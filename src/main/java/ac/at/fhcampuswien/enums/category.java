package ac.at.fhcampuswien.enums;

//enum class used for sorting after the following topics:
public enum category {
    business("Business"),
    entertainment("Entertainment"),
    general("General"),
    health("Health"),
    science("Science"),
    sports("Sports"),
    technology("Technology");

    private final String getcategory;

    category(String getCategory) {
        getcategory = getCategory;
    }

    @Override
    public String toString() {
        return getcategory;
    }
}
