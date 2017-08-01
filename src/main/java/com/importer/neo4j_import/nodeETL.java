package com.importer.neo4j_import;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by zhzy on 2017/7/31.
 */
public class nodeETL {
    public static void main( String[] args ) throws Exception
    {
        FileReader fileReader = new FileReader("/Users/zhzy/Downloads/file.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


//        File file= new File("D:\\BaiduYunDownload\\clean_test_file.txt");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
//        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        FileWriter fileWriter = new FileWriter("/Users/zhzy/Documents/graphComputer/node.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        String headLine = bufferedReader.readLine().replace("fsimage_xg.path", "fsimage_xg.path:ID").replace("\t",",");
        bufferedWriter.write(headLine);
        bufferedWriter.newLine();
        while (true){
            String line = bufferedReader.readLine();
            if(line == null){
                break;
            }
            String newLine = line.replace("\t", ",");
            bufferedWriter.write(newLine);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
