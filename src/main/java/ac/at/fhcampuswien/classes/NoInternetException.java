package ac.at.fhcampuswien.classes;

import java.net.NoRouteToHostException;

public class NoInternetException extends NoRouteToHostException {
    NoInternetException(){
        super("You have no connection to the internet!");
    }
}
