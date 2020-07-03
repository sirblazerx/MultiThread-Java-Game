/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author User
 */
public class ExecutorManager {
    private static ExecutorService executorService;

    public ExecutorManager(int thread) {
        executorService = Executors.newFixedThreadPool(thread);
    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }
}
