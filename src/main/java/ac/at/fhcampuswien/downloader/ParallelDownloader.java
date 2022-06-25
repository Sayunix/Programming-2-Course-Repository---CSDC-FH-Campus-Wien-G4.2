package ac.at.fhcampuswien.downloader;

import ac.at.fhcampuswien.classes.NewsAPIException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Class is needed for exercise 4 - ignore for exercise 3 solution
public class ParallelDownloader extends Downloader {

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewsAPIException {
        // TODO implement download function using multiple threads
        // Hint: use ExecutorService with Callables

        int proc = Runtime.getRuntime().availableProcessors();
        ExecutorService threads = Executors.newFixedThreadPool(proc);

        List<Callable<String>> Tasks = new ArrayList<>();
        for (String url : urls) {
            Callable<String> task = () -> saveUrl2File(url);
            Tasks.add(task);
        }
        int count = 0;
        try {
            List<Future<String>> futures = threads.invokeAll(Tasks);
            for (Future<String> f : futures) {
                if (f.get() != null) {
                    count++;
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new NewsAPIException(e.getMessage());
        }
        threads.shutdown();

        return count;
    }
}