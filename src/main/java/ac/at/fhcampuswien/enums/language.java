package ac.at.fhcampuswien.enums;

public enum language {
    ar("Arabic"), cs("Czech"), zh("Chinese"), da("Danish"), nl("Dutch"), en("English"), fi("Finnish"), fr("French"), de("German"),
    el("Greek, Modern"), he("Hebrew"), hi("Hindi"), hu("Hungaria"), it("Italian"), ms("Malay"), no("Norwegian"), pl("Polish"),
    pt("Portuguese"), ro("Romanian"), ru("Russian"), sk("Slovak"), sl("Slovenian"), es("Spanish"), sv("Swedish"), th("Thai"),
    tr("Turkish"), uk("Ukrainian"), vi("Vietnamese");

    private final String getLanguage;

    language(String getlanguage) {
        getLanguage = getlanguage;
    }

    @Override
    public String toString() {
        return getLanguage;
    }
}
