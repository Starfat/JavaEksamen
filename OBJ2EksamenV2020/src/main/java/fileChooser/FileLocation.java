package fileChooser;
import java.util.prefs.Preferences;

/** Denne har funksjoner 
 * for lagre og å hente ut søkesti for siste 
 * fil som har blitt lagt til i programmet.
 * Brukes av FileChooser.java 
*/

public enum FileLocation {
    FileLocation();
    private static Preferences prefs = Preferences.userRoot()
                                          .node(FileLocation.class.getName());

    public String get(String defaultValue) {
        return prefs.get(this.name(), defaultValue);
    }

    public void put(String value) {
        prefs.put(this.name(), value);
    }
}