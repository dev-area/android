package com.example.app2;

/*
 * Copyright (c) 2011 Adam Outler
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights 
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adam
 */
//define <output and input> to this abstract class
public class Shell implements Runnable {

    //for internal access
    public Shell() {
    }
    //for external access
    //Send a command to the shell

 
    public String sendShellCommand(String[] cmd) {
        String AllText = "";
        try {
            String line;
            Process process = new ProcessBuilder(cmd).start();
            BufferedReader STDOUT = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader STDERR = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            try {
                process.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
            }
            while ((line = STDERR.readLine()) != null) {
                AllText = AllText + "\n" + line;
            }
            while ((line = STDOUT.readLine()) != null) {
                AllText = AllText + "\n" + line;
                while ((line = STDERR.readLine()) != null) {
                    AllText = AllText + "\n" + line;
                }
            }
            //log.level0(cmd[0]+"\":"+AllText);
            return AllText;
        } catch (IOException ex) {
            return "CritERROR!!!";
        }

    }

    public String silentShellCommand(String[] cmd) {

        String AllText = "";
        try {
            String line;
            Process process = new ProcessBuilder(cmd).start();
            BufferedReader STDOUT = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = STDOUT.readLine()) != null) {
                AllText = AllText + "\n" + line;

            }
            return AllText;
        } catch (IOException ex) {
            return "CritERROR!!!";
        }

    }

    public String arrayToString(String[] stringarray) {
        String str = " ";
        for (int i = 0; i < stringarray.length; i++) {
            str = str + " " + stringarray[i];
        }
        return str;
    }

    private boolean testForException(Process process) {

        if (process.exitValue() >= 0) {

            return false;
        } else {
            return true;
        }


    }



    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}