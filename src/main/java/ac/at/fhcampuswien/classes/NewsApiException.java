package ac.at.fhcampuswien.classes;

public class NewsApiException extends Exception {

    //String errorMessage = "It seems you have no network connection.";

    public NewsApiException(String errorMessage){
        super(errorMessage);

    }

//     try {
//        checkIfNewsresponseEmpty(newsResponse);
//    }
//    catch(Exception e) {
//        System.out.println("A problem occured: " + e);
//    }
//
//    static void checkIfNewsresponseEmpty(NewsResponse newsResponse) throws NewsApiException{
//        if(newsResponse == null){
//            throw new NewsApiException("\n"+ "There are currently no news to your search " +
//                    "request, please try a different search.");
//        }
//        else {
//            System.out.println("Search result:\n");
//        }
//
//
//    }


}
