package com.importer.neo4j_import;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhzy on 2017/7/31.
 */
public class relETL {
    public static void main( String[] args ) throws Exception
    {
        FileReader fileReader = new FileReader("/Users/zhzy/Downloads/file.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


//        File file= new File("D:\\BaiduYunDownload\\clean_test_file.txt");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
//        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        FileWriter fileWriter = new FileWriter("/Users/zhzy/Documents/graphComputer/rel.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedReader.readLine();
        List<String> pathList = new ArrayList<String>();
        bufferedWriter.write(":START_ID,:END_ID,:TYPE");
        bufferedWriter.newLine();
        while (true){
            String line = bufferedReader.readLine();
            if(line == null){
                break;
            }
            String[] termLine = line.split("\t");
            pathList.add(termLine[0]);
        }
        for(int i=0; i<100000; i++){
            String node1 = pathList.get((int)(Math.random()*100000));
            String node2 = pathList.get((int)(Math.random()*100000));
            String line = node1 + "," + node2 +","+ "LINK";
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
