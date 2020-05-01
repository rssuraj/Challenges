package com.geektrust.familytree;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.geektrust.familytree.constants.FamilyConstants;
import com.geektrust.familytree.enums.GenderEnum;
import com.geektrust.familytree.family.Family;

/**
 * Hello world!
 *
 */
public class FamilyTree 
{
    public static void main( String[] args )
    {
        if(args.length > 0) {
            try (BufferedReader br = Files.newBufferedReader(Paths.get(args[0]))) {
                Family family = new Family();
                String line = null;
                while((line = br.readLine()) != null) {
                    List<String> params = null;
                    if(line.startsWith(FamilyConstants.ADD_CHILD)) {
                        params = getParameters(line, 3);
                        System.out.println(family.addChild(params.get(0), params.get(1), params.get(2)));
                    }
                    else if(line.startsWith(FamilyConstants.GET_RELATIONSHIP)) {
                        params = getParameters(line, 2);
                        System.out.println(family.getRelationship(params.get(0), params.get(1)));
                    }
                    else {
                        System.out.print(line + " ---- ");
                        System.out.println("Command not implemented Yet!!");
                    }
                }
            }
            catch(IOException e) {
                System.out.println("Error while creating BufferedReader for file name = " + args[0]);
                e.printStackTrace();    
            }
            
            return;
        }

        System.out.println("Please provide filename.txt as a command line argument");
    }

    private static List<String> getParameters(String line, int paramCount) {
        List<String> parameters = new ArrayList<String>();
        String[] inputs = line.split(" ");

        for(int i = 0; i < paramCount; i++) {
            parameters.add(inputs[i + 1]);
        }

        return parameters;
    }
}
