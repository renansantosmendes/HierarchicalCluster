package com.mycompany.hierachicalcluster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author renansantos
 */
public class HierarchicalCluster {

    private List<List<Double>> listData;
    private Double[][] data;
    private String fileName;
    private int numberOfClusters;
    private List<Cluster> clusters;
    private Double[][] similarity;

    private class Cluster {

        private List<Double> points;

        public List<Double> getPoints() {
            return this.points;
        }
    }

    public HierarchicalCluster(int numberOfClusters, Double[][] data) {
        this.data = data;
        this.numberOfClusters = numberOfClusters;
        this.clusters = new ArrayList<>();
    }

    public HierarchicalCluster(String fileName, int numberOfClusters) throws IOException {
        this.fileName = fileName;
        this.numberOfClusters = numberOfClusters;
        this.clusters = new ArrayList<>();
        this.listData = readData();
        
        calculateSilimarity();
    }

    private List<List<Double>> readData() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<List<Double>> listData = new ArrayList<>();
        while (br.ready()) {
            String linha = br.readLine();
            String[] teste = linha.split(",");
            List<Double> line = new ArrayList<>();

            for (String string : teste) {
                line.add(Double.parseDouble(string));
            }
            System.out.println(line);
            listData.add(line);
        }
        
        System.out.println("Number of rows = " + listData.size());
        System.out.println("Number of columns = " + listData.get(0).size());
        br.close();

        return listData;
    }

    private void calculateSilimarity(){
        
    }
}
