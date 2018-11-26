package pub.menu.sort;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pub.entity.Beer;
import pub.entity.Pub;
import pub.menu.MenuItem;
import pub.menu.RootMenuItem;
import pub.operations.SortAction;

import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class MenuSortOperation implements MenuItem {
    private static final Logger LOGGER = Logger.getLogger(MenuSortOperation.class.getName());

    private Lock lock = new ReentrantLock();

    protected static final Scanner SCANNER = new Scanner(System.in);

    protected SortAction operation;
    protected RootMenuItem rootMenuItem;
    protected Pub pub;

    public MenuSortOperation(SortAction operation, RootMenuItem rootMenuItem, Pub pub) {
        this.rootMenuItem = rootMenuItem;
        this.operation = operation;
        this.pub = pub;
    }

    public void execute() {

            try {
                lock.lock();
                List<Beer> resultList = operation.execute(pub.getBeers());
                System.out.println("Result: " + resultList);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String resultInfo = gson.toJson(resultList);
                FileWriter writer = new FileWriter("Result" + operation.toString() + ".txt", false);
                writer.write(resultInfo);
                writer.close();
            } catch (Exception e) {
                LOGGER.log(Level.INFO, e.getMessage(), e);
            } finally {
                lock.unlock();
            }
    }
}