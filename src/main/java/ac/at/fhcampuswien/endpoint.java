package ac.at.fhcampuswien;

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
