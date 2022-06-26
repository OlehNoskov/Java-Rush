package ua.com.javarush.solution_tasks_for_implemika.second_task;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestWay {
    private final String INPUT_FILE = "inputCities.txt";

    private final int MAX_COST_WAY = 200_000;
    private int countCities = 10_000;

    private List<Way> shortestPaths;
    private Town[] citiesArray;
    private int[][] relationMatrix;

    private int countOfVertices;
    private int countOfVertexInTree;
    private int currentVertex;
    private int startToCurrent;

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {

            while (reader.ready()) {
                // search amount cities
                countCities = Integer.parseInt(reader.readLine());
                addAllTown();

                for (int i = 0; i < countCities; i++) {
                    // search name Town
                    String nameTown = reader.readLine();
                    addTown(nameTown, i);
                    // search count neighbour cities
                    int countOfNeighbours = Integer.parseInt(reader.readLine());

                    for (int j = 0; j < countOfNeighbours; j++) {
                        String pathToNeighbour = reader.readLine();
                        String[] substrings = pathToNeighbour.split(" ");

                        if (substrings.length != 2) {
                            throw new RuntimeException("Input data is incorrect!");
                        }
                        setCostWay(i, Integer.parseInt(substrings[0]) - 1, Integer.parseInt(substrings[1]));
                    }
                }
                int countOfWays = Integer.parseInt(reader.readLine());

                for (int j = 0; j < countOfWays; j++) {
                    String citiesToFindWay = reader.readLine();
                    String[] substrings = citiesToFindWay.split(" ");

                    if (substrings.length != 2) {
                        throw new RuntimeException("Input data is incorrect!");
                    }

                    //read name Town source from string and comparison it with elements array cities
                    Town currentCity = Arrays.stream(citiesArray)
                            .filter(city -> city.getName().equals(substrings[0]))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Town source not found!"));

                    //read name Town destination from string and comparison it with elements array cities
                    Town finalCity = Arrays.stream(citiesArray)
                            .filter(city -> city.getName().equals(substrings[1]))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Town destination not found!"));
                    shortestWays(currentCity.getIndex(), finalCity.getIndex());

                    cleanData();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Something wrong!");
        }
    }

    //show result in console
    private void showingCostWaysToConsole(int startTree, int finalIndex) {
        if (shortestPaths.get(finalIndex).getDistance() == MAX_COST_WAY) {
            System.out.println("This way is long!");
        } else {
            String costWay = shortestPaths.get(finalIndex).getDistance() + "";
            System.out.println(costWay);
        }
    }

    //search shortest way
    private void shortestWays(int start, int end) {
        citiesArray[start].setInTree(true);
        countOfVertexInTree = 1;

        for (int i = 0; i < countOfVertices; i++) {
            int tempDist = relationMatrix[start][i];
            Way cityPath = new Way(tempDist);
            cityPath.getParentVertices().add(start);
            shortestPaths.add(cityPath);
        }
        while (countOfVertexInTree < countOfVertices) {
            int indexMin = getMinCostWay();
            int minDistance = shortestPaths.get(indexMin).getDistance();

            if (minDistance == MAX_COST_WAY) {
                break;
            } else {
                currentVertex = indexMin;
                startToCurrent = shortestPaths.get(indexMin).getDistance();
            }
            citiesArray[currentVertex].setInTree(true);
            countOfVertexInTree++;
            updateCostWays();
        }
        showingCostWaysToConsole(start, end);
    }

    private void updateCostWays() {
        int vertexIndex = 1;
        while (vertexIndex < countOfVertices) {
            if (citiesArray[vertexIndex].isInTree()) {
                vertexIndex++;
                continue;
            }
            int currentToFringe = relationMatrix[currentVertex][vertexIndex];
            int startToFringe = startToCurrent + currentToFringe;
            int shortPathDistance = shortestPaths.get(vertexIndex).getDistance();

            if (startToFringe < shortPathDistance) {
                List<Integer> newParents = new ArrayList<>(shortestPaths.get(currentVertex).getParentVertices());
                newParents.add(currentVertex);
                shortestPaths.get(vertexIndex).setParentVertices(newParents);
                shortestPaths.get(vertexIndex).setDistance(startToFringe);
            }
            vertexIndex++;
        }
    }

    // get path with minimal cost
    private int getMinCostWay() {
        int min = MAX_COST_WAY;
        int indexMin = 0;

        for (int i = 1; i < countOfVertices; i++) {
            if (!citiesArray[i].isInTree() && shortestPaths.get(i).getDistance() < min) {
                min = shortestPaths.get(i).getDistance();
                indexMin = i;
            }
        }
        return indexMin;
    }

    //add new Town in array
    private void addTown(String nameTown, int index) {
        citiesArray[countOfVertices++] = new Town(nameTown, index);
    }

    //set cost way
    private void setCostWay(int start, int end, int cost) {
        relationMatrix[start][end] = cost;
    }

    //adding all Town
    private void addAllTown() {
        citiesArray = new Town[countCities];
        relationMatrix = new int[countCities][countCities];
        countOfVertices = 0;
        countOfVertexInTree = 0;

        for (int i = 0; i < countCities; i++) {
            for (int k = 0; k < countCities; k++) {
                relationMatrix[i][k] = MAX_COST_WAY;
                shortestPaths = new ArrayList<>();
            }
        }
    }

    // clear all data
    private void cleanData() {
        countOfVertexInTree = 0;
        for (int i = 0; i < countOfVertices; i++) {
            citiesArray[i].setInTree(false);
        }
        countOfVertexInTree = 0;
        for (int i = 0; i < countCities; i++) {
            for (int k = 0; k < countCities; k++) {
                shortestPaths = new ArrayList<>();
            }
        }
    }
}