package ua.com.javarush.multithreading.inner_classes;

import java.math.BigDecimal;

public class SolutionSeven {

    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public class Apt3Bedroom extends Building.Apartments{
        Apt3Bedroom(Building building) {
            building.super();
        }
    }

    public class BidHall extends Building.Hall{
        public BidHall(Building building, BigDecimal square) {
            building.super(square);
        }
    }

    public static void main(String[] args) {

    }
}
