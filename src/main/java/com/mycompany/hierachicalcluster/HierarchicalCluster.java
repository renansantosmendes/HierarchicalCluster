package com.mycompany.hierachicalcluster;

import Jama.Matrix;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

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
    private double[][] data;
    private String fileName;
    private int numberOfClusters;
    private List<Cluster> clusters;
    private double[][] similarity;
    private double[][] dissimilarity;
    private int numberOfRows;
    private int numberOfColumns;
    
    private class Cluster {
        
        private List<Double> points;
        
        public List<Double> getPoints() {
            return this.points;
        }
    }
    
    public HierarchicalCluster(int numberOfClusters, double[][] data) {
        this.data = data;
        this.numberOfClusters = numberOfClusters;
        this.clusters = new ArrayList<>();
    }
    
    public HierarchicalCluster(String fileName, int numberOfClusters) throws IOException {
        this.fileName = fileName;
        this.numberOfClusters = numberOfClusters;
        this.clusters = new ArrayList<>();
        this.listData = readData();
        
        createMatrix();
        calculateSilimarity();
        calculateDissilimarity();
    }
    
    public List<List<Double>> getListData() {
        return listData;
    }
    
    public double[][] getData() {
        return data;
    }
    
    public List<Cluster> getClusters() {
        return clusters;
    }
    
    public double[][] getSimilarity() {
        return similarity;
    }
    
    public double[][] getdissimilarity() {
        return similarity;
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
            listData.add(line);
        }
        
        System.out.println("Number of rows = " + listData.size());
        System.out.println("Number of columns = " + listData.get(0).size());
        
        this.numberOfRows = listData.size();
        this.numberOfColumns = listData.get(0).size();
        br.close();
        
        return listData;
    }
    
    private void createMatrix() {
        this.data = new double[this.numberOfRows][this.numberOfColumns];
        for (int k = 0; k < this.numberOfRows; k++) {
            for (int i = 0; i < this.numberOfColumns; i++) {
                this.data[k][i] = listData.get(k).get(i);
            }
        }
    }
    
    public void printMatrixData() {
        for (int j = 0; j < this.numberOfRows; j++) {
            for (int i = 0; i < this.numberOfColumns; i++) {
                System.out.print(this.data[j][i] + " ");
            }
            System.out.println();
        }
    }
    
    public void printSimilarity() {
        for (int j = 0; j < similarity.length; j++) {
            for (int i = 0; i < similarity.length; i++) {
                System.out.print(this.similarity[j][i] + " ");
            }
            System.out.println();
        }
    }
    
    public void printDissimilarity() {
        for (int j = 0; j < dissimilarity.length; j++) {
            for (int i = 0; i < dissimilarity.length; i++) {
                System.out.print(this.dissimilarity[j][i] + " ");
            }
            System.out.println();
        }
    }
    
    private void calculateSilimarity() {
        PearsonsCorrelation corr = new PearsonsCorrelation(this.data);
        System.out.println(corr.getCorrelationMatrix());
        this.similarity = corr.getCorrelationMatrix().getData();
        
    }
    
    private void calculateDissilimarity() {
        dissimilarity = new double[similarity.length][similarity.length];
        for (int j = 0; j < similarity.length; j++) {
            for (int i = 0; i < similarity.length; i++) {
                dissimilarity[j][i] = 1 - similarity[j][i];
            }
        }
    }
    
    public void findMinDissimilarity(int rows, int columns) {
        double minDissimilarity = 2.0;
        int column = 0;
        int row = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (minDissimilarity > dissimilarity[i][j] && dissimilarity[i][j] != 0) {
                    minDissimilarity = dissimilarity[i][j];
                    column = i;
                    row = j;
                }
            }
        }
        
        System.out.println("Minumum = " + minDissimilarity);
        System.out.println("column = " + column);
        System.out.println("row = " + row);
    }
    
    public void reduceMatrix(int column1, int column2) {
        int newNumberOfColumns = this.numberOfColumns - 1;//olhar uma forma de atualizar esse número -> pensar num atributo estático
        double[][] originalData = this.data;
        double[][] reducedData = new double[newNumberOfColumns][this.numberOfRows];
        double[] columnData = new double[this.numberOfColumns];
        Matrix m = new Matrix(this.data);//focar aqui
        Matrix red;
        
        int numberOfObjectives = this.numberOfColumns;
        red = new Matrix(m.getRowDimension(), m.getColumnDimension() - 1);
        red.setMatrix(0, m.getRowDimension() - 1, 0, column1 - 1, m.getMatrix(0, m.getRowDimension() - 1, 0, column1 - 1));
        red.print(0, 0);
        
        Matrix cluster = new Matrix(this.numberOfRows, 1);
        m.getMatrix(0, m.getRowDimension() - 1, column1, column1).print(0, 0);
        m.getMatrix(0, m.getRowDimension() - 1, column2, column2).print(0, 4);
        //cluster.setMatrix(column2, column1, column2,0,m.getMatrix(0,m.getRowDimension() - 1,column1,column1));
    }
    
}
