package com.test.task.bussystem.Service;

import com.test.task.bussystem.model.BusDirection;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class BusSystemService {
    public BusDirection checkDirection(String from, String to) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("busStops.txt"))) {
            while (bufferedReader.ready()) {
                String readLine = bufferedReader.readLine() + " ";
                String id = readLine.substring(0, readLine.indexOf(" "));

                if (readLine.contains(" " + from + " ") && readLine.contains(" " + to + " ")
                        && readLine.indexOf(" " + from + " ") < readLine.indexOf(" " + to + " "))
                    return new BusDirection(from, to, true);
            }
            return new BusDirection(from, to, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BusDirection(from, to, false);
    }
}
