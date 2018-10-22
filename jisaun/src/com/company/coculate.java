package com.company;

import java.util.ArrayList;
import java.util.List;

public class coculate {
    public static List<produce> getExerciseList(int exerciseCount) {
        List<produce> exerciseList = new ArrayList<produce>();
        for (int i = 0; i < exerciseCount; i++) {
            exerciseList.add(new produce());
        }
        return exerciseList;
    }
}
