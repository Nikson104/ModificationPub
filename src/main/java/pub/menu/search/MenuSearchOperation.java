package pub.menu.search;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pub.entity.Beer;
import pub.entity.Pub;
import pub.menu.MenuItem;
import pub.menu.RootMenuItem;
import pub.operations.SearchAction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class MenuSearchOperation implements MenuItem {
    private static final Logger LOGGER = Logger.getLogger(MenuSearchOperation.class.getName());
    protected String text;

    protected static final Scanner SCANNER = new Scanner(System.in);

    protected SearchAction operation;
    protected RootMenuItem rootMenuItem;
    protected Pub pub;

    public MenuSearchOperation(SearchAction operation, RootMenuItem rootMenuItem, Pub pub) {
        this.rootMenuItem = rootMenuItem;
        this.operation = operation;
        this.pub = pub;
    }

    public void execute(Object param) {
            try {
                writeToFile(createJson(param));
            } catch (Exception e) {
                LOGGER.log(Level.INFO, e.getMessage(), e);
            }
    }

    public synchronized String createJson(Object param) throws InterruptedException {
        List<Beer> resultList = operation.execute(pub.getBeers(), param);
        System.out.println("Result: " + resultList + "Thread: " + Thread.currentThread().getName());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(resultList);
    }

    public synchronized void writeToFile(String resultList) throws IOException, InterruptedException {
        System.out.println("Result: " + resultList + "Thread: " + Thread.currentThread().getName());
        FileWriter writer = new FileWriter("ResultInfo.txt", false);
        writer.write(resultList);
        writer.close();
    }
}