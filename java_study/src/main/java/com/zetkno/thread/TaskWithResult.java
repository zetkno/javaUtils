package com.zetkno.thread;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.*;

import static org.apache.poi.hslf.record.RecordTypes.List;

public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult" + id;

    }
}
class B extends FutureTask {

    public B(@NotNull Callable callable) {
        super(callable);
    }
}
class CallableDemo {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> resutl = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            resutl.add(exec.submit(new TaskWithResult(i)));
            for (Future<String> fs : resutl) {

            }
        }
    }
}
