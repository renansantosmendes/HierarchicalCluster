/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hierachicalcluster;

import Jama.Matrix;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;
import java.io.IOException;

/**
 *
 * @author renansantos
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String path = "/home/renansantos/NetBeansProjects/VRPDRTGoogleMapsAPI/"
                + "AlgorithmsResults/9FO/NSGA-II/r050n12tw10k4_2017_12_14";
        String file = "NSGAII-Population_0.csv";

        HierarchicalCluster hc = new HierarchicalCluster(path + "/" + file, 3);
        hc.printDissimilarity();
        hc.findMinDissimilarity(9, 9);
        hc.reduceMatrix(4, 8);
    }
}
