package ac.at.fhcampuswien.enums;

public enum sortBy {
    relevancy("Relevancy"),
    popularity("Popular"),
    publishedAt("Newest Article First");

    private final String getSort;

    sortBy(String getsort) {
        getSort = getsort;
    }

    @Override
    public String toString() {
        return getSort;
    }
}
