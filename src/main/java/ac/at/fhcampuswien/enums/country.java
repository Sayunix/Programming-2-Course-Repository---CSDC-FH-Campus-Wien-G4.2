package ac.at.fhcampuswien.enums;

//creates an enum with all the Countries - country codes ("Alpha-2 code")
public enum country {
    all("All Countries"), ar("Argentinia"),at("Austria"),au("Australia"),be("Belgium"),bg("Bulgaria"),br("Brazil"),ca("Canada"),
    cn("China"),co("Colombia"),cu("Cuba"),cz("Czech Republic"),de("Germany"),eg("Egypt"),fr("France"),
    gb("Great Britain"),gr("Greece"),hk("Hong Kong"),hu("Hungary"),id("Indonesia"),in("India"),ie("Ireland"),
    il("Israel"),it("Italy"),jp("Japan"),lv("Latvia"),lt("Lithuania"),my("Malaysia"),mx("Mexico"),
    ma("Morocco"),nl("Netherlands"),nz("New Zealand"),ng("Nigeria"),no("Norway"), ph("Philippines"),pl("Poland"),
    pt("Portugal"),ro("Romania"),ru("Russia"),sa("Saudi Arabia"),rs("Serbia"),sg("Singapore"),se("Sweden"),
    sk("Slovakia"), si("Slovenia"),za("South Africa"), kr("South Korea"),ch("Switzerland"),tw("Taiwan"),th("Thailand"),
    tr("Turkey"),ua("Ukraine"),ae("United Arab Emirates"),us("USA"),ve("Venezuela");

    //final method to prevent method overriding
    private final String getcountry;

    country(String getCountry) {
        getcountry = getCountry;
    }

    @Override
    public String toString() {
        return getcountry;
    }
}
