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
        String path = "/home/renansantos/NetBeansProjects/VRPDRTGoogleMapsAPI/AlgorithmsResults/9FO/NSGA-II/r050n12tw10k4_2017_12_14";
        String file = "NSGAII-Population_0.csv";
        new HierarchicalCluster(path+"/"+file,3);

//        BufferedReader br = new BufferedReader(new FileReader(path+"/"+file));
//        List<List<Double>> listData = new ArrayList<>();
//        while (br.ready()) {
//            String linha = br.readLine();
//            String [] teste = linha.split(",");//Double.parseDouble(string)
//            List<Double> line = new ArrayList<>();
//            
//            for(String string: teste){
//                line.add(Double.parseDouble(string));
//            }
//            System.out.println(line);
//            listData.add(line);
//        }
//        System.out.println("Number of rows = " + listData.size());
//        System.out.println("Number of columns = " + listData.get(0).size());
//        
//        br.close();
    }
}
