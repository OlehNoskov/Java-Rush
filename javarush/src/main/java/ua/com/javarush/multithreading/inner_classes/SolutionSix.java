package ua.com.javarush.multithreading.inner_classes;

import ua.com.javarush.multithreading.inner_classes.vo.*;

import java.util.List;

public class SolutionSix {

    public List<User> getUsers(){
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return ;
            }
        };
    }


    public List<Location> getLocations(){
        return null;
    }

    public List<Server> getServers(){
        return null;
    }

    public List<Subject> getSubjects(){
        return null;
    }

    public List<Subscription> getSubscriptions(){
        return null;
    }
}
