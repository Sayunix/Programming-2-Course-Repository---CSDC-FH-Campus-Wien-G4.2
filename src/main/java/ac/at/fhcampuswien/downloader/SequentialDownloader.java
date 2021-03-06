package ac.at.fhcampuswien.downloader;


import ac.at.fhcampuswien.classes.NewsAPIException;
import ac.at.fhcampuswien.classes.NewsResponse;

import java.util.List;

// Class is needed for exercise 4 - ignore for exercise 3 solution
public class SequentialDownloader extends Downloader {
    private static SequentialDownloader _instance = null;

    private SequentialDownloader(){};

    public static SequentialDownloader getInstance(){
        if (_instance == null){
            _instance = new SequentialDownloader();
        }
        return _instance;
    }

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewsAPIException{
        int count = 0;
        for (String url : urls) {
            try {
                String fileName = saveUrl2File(url);
                if(fileName != null)
                    count++;
            } catch (NewsAPIException e){
                System.err.println(e.getMessage());
                throw new NewsAPIException(e.getMessage());
            } catch (Exception e){
                throw new NewsAPIException("Different problem occurred in " + this.getClass().getName() + ". Message: " + e.getMessage());
            }
        }
        return count;
    }
}