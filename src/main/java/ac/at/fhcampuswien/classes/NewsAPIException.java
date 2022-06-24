/*package ac.at.fhcampuswien.classes;

public class NewsAPIException extends RuntimeException{
    NewsAPIException(){
        super("Exceeded amount of requests!\nYou consumed the amount of requests for 2 API-KEYS!!!");
    }
}
*/

package ac.at.fhcampuswien.classes;

public class NewsAPIException extends RuntimeException{
    public NewsAPIException() {
        super();
    }
    public NewsAPIException(String message) {
        super(message);
    }
}