package ua.com.javarush.multithreading.inner_classes;

import ua.com.javarush.multithreading.inner_classes.vo.*;

import java.util.List;

public class SolutionSix {

    public List<User> getUsers(){

        return new AbstractDbSelectExecutor<User>(){
            @Override
            public String getQuery() {
                return ("SELECT * FROM USER");
            }
        }.execute();
    }

    public List<Location> getLocations(){
        return new AbstractDbSelectExecutor<Location>(){
            @Override
            public String getQuery() {
                return ("SELECT * FROM LOCATION");
            }
        }.execute();
    }

    public List<Server> getServers(){
        return new AbstractDbSelectExecutor<Server>(){
            @Override
            public String getQuery() {
                return ("SELECT * FROM LOCATION");
            }
        }.execute();
    }

    public List<Subject> getSubjects(){
        return new AbstractDbSelectExecutor<Subject>(){
            @Override
            public String getQuery() {
                return ("SELECT * FROM LOCATION");
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions(){
        return new AbstractDbSelectExecutor<Subscription>(){
            @Override
            public String getQuery() {
                return ("SELECT * FROM LOCATION");
            }
        }.execute();
    }

    public static void print (List list){
        String format = "Id=%d, name = '%s', description=%s";
        for (Object obj : list){
            NamedItem namedItem = (NamedItem) obj;
            System.out.println(String.format(format, namedItem.getId(), namedItem.getName(), namedItem.getDescription()));
        }
    }

    public static void main(String[] args) {
        SolutionSix solutionSix = new SolutionSix();
        print(solutionSix.getUsers());
        print(solutionSix.getLocations());
        print(solutionSix.getServers());
        print(solutionSix.getSubjects());
        print(solutionSix.getSubscriptions());
    }
}
