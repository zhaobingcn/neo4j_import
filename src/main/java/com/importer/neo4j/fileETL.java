package com.importer.neo4j;


import java.io.*;

/**
 * Hello world!
 *
 */
public class fileETL
{
    public static void main( String[] args ) throws Exception
    {
        FileReader fileReader = new FileReader("D:\\BaiduYunDownload\\file.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


//        File file= new File("D:\\BaiduYunDownload\\clean_test_file.txt");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
//        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        FileWriter fileWriter = new FileWriter("D:\\ProfessionalSoftware\\batch-import-tool-master\\node.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        String headLine = "l:label\t" + bufferedReader.readLine().replace("fsimage_xg.path", "path:string:PATH");
        bufferedWriter.write(headLine);
        bufferedWriter.newLine();
        while (true){
            String line = bufferedReader.readLine();
            if(line == null){
                break;
            }
            String newLine = "NODE\t" + line;
            bufferedWriter.write(newLine);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
