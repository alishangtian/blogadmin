package com.alishangtian.blogadmin.shellutil;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * shell执行器
 *
 * @author maoxiaobing
 */
@Log4j2
public class ShellUtil {
    /**
     *
     */
    public static void execShell() {
        InputStreamReader stdISR = null;
        InputStreamReader errISR = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("pwd");
            process.waitFor();
            String line;
            stdISR = new InputStreamReader(process.getInputStream());
            BufferedReader stdBR = new BufferedReader(stdISR);
            while ((line = stdBR.readLine()) != null) {
                log.info("$info:{}", line);
            }
            errISR = new InputStreamReader(process.getErrorStream());
            BufferedReader errBR = new BufferedReader(errISR);
            while ((line = errBR.readLine()) != null) {
                log.info("$error:{}", line);
            }
        } catch (IOException | InterruptedException e) {
            log.error("{}", e);
        } finally {
            try {
                if (stdISR != null) {
                    stdISR.close();
                }
                if (errISR != null) {
                    errISR.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (IOException e) {
                log.error("{}", e);
            }
        }
    }
}
