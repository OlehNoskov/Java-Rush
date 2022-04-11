package ua.com.javarush.restaurant;

public class DirectorTablet {

    //Сумма заработанная на рекламе
    public void printAdvertisementProfit (){
    ConsoleHelper.writeMessage("1");
    }
    //Загруженность повара
    public void printCookingWorkLoading (){
        ConsoleHelper.writeMessage("2");
    }
    //Списокактивных роликов и оставшееся кол-во показов по каждому
    public void printActiveVideoSet (){
        ConsoleHelper.writeMessage("3");
    }
    //Список неактивных роликов
    public void printArchivedVideoSet (){
        ConsoleHelper.writeMessage("4");
    }
}