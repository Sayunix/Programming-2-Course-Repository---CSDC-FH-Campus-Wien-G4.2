package ac.at.fhcampuswien.enums;

//used to differentiate between everything and top-headlines as a category
public enum endpoint {
    everything("everything"),
    top_headlines("top-headlines");

    private final String getEndpoint;

    endpoint(String endPoint) {
        getEndpoint = endPoint;
    }

    @Override
    public String toString() {
        return getEndpoint;
    }
}
