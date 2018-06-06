/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hierachicalcluster;

import java.io.IOException;

/**
 *
 * @author renansantos
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        String path = "/home/renansantos/NetBeansProjects/VRPDRTGoogleMapsAPI/AlgorithmsResults/9FO/NSGA-II/r050n12tw10k4_2017_12_14";
//        String file = "NSGAII-Population_0.csv";
        
        String path = "/home/renansantos";
        String file = "solutions.csv";

        int numberOfClusters = 2;
        HierarchicalCluster hc = new HierarchicalCluster(path + "/" + file, numberOfClusters, CorrelationType.PEARSON);
        hc.reduce();
        hc.printTransformationList();
        //hc.printMatrixData();
    }
}
