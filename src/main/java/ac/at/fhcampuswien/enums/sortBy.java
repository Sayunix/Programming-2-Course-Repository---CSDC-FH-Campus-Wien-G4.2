package ac.at.fhcampuswien.enums;

//sorts news by relevancy, popularity or publishing date
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
