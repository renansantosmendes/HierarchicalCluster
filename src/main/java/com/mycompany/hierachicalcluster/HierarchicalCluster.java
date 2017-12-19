package com.mycompany.hierachicalcluster;

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

    private Object[][] integerData;
    private String fileName;
    private int numberOfClusters;
    private List<Cluster> clusters;
    
    private class Cluster{
        private List<Integer> points;
        
        public List<Integer> getPoints(){
            return this.points;
        }
    }

    public HierarchicalCluster(int numberOfClusters, Integer[][] integerData) {
        this.integerData = integerData;
        this.numberOfClusters = numberOfClusters;
        this.clusters = new ArrayList<>();
    }
    
     public HierarchicalCluster(int numberOfClusters, Double[][] integerData) {
        this.integerData = integerData;
        this.numberOfClusters = numberOfClusters;
        this.clusters = new ArrayList<>();
    }
     
     public HierarchicalCluster(String fileName, int numberOfClusters) {
        //this.integerData = integerData;
        this.fileName = fileName;
        this.numberOfClusters = numberOfClusters;
        this.clusters = new ArrayList<>();
    }
    
    
    

}
