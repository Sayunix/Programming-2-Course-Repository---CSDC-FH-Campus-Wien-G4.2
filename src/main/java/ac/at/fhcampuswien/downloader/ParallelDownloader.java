package ac.at.fhcampuswien.downloader;

import ac.at.fhcampuswien.classes.NewsAPIException;
import ac.at.fhcampuswien.classes.NewsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Class is needed for exercise 4 - ignore for exercise 3 solution
public class ParallelDownloader extends Downloader {
    private static ParallelDownloader _instance = null;

    private ParallelDownloader(){};

    public static ParallelDownloader getInstance(){
        if (_instance == null){
            _instance = new ParallelDownloader();
        }
        return _instance;
    }

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewsAPIException {
        // TODO implement download function using multiple threads
        // Hint: use ExecutorService with Callables

        int proc = Runtime.getRuntime().availableProcessors(); //how many processors do I have available
        ExecutorService threads = Executors.newFixedThreadPool(proc);//ExecuterService=Threadmanager,
        // get as many threads as processors available

        List<Callable<String>> Tasks = new ArrayList<>(); //Callable are tasks which are given to the ExecutorService  to process
        for (String url : urls) {
            Callable<String> task = () -> saveUrl2File(url); //Getting a List of URLs, creating a Callable Object for them to save them
            //Lambda Expression, gives the opportunity to code it without creating a own class
            Tasks.add(task);//Saves callable element created to task List
        }
        int count = 0;
        try {
            List<Future<String>> futures = threads.invokeAll(Tasks); //invokeAll= Gives instruction to ExecService to process tasks from List "Tasks"
            for (Future<String> f : futures) {
                if (f.get() != null) {
                    count++; //Saving the amount of successful downloads
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new NewsAPIException(e.getMessage());
        }
        threads.shutdown();

        return count;
    }
}