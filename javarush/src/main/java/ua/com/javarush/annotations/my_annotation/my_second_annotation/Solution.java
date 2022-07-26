package ua.com.javarush.annotations.my_annotation.my_second_annotation;

@Ticket(
        priority = Ticket.Priority.HIGH,
        createdBy = "Noodles",
        tags = {"bug", "fix asap"}
)

public class Solution {
    public static void main(String[] args) {

    }
}
