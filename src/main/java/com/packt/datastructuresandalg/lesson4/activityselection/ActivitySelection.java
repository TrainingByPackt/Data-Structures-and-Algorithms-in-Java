package com.packt.datastructuresandalg.lesson4.activityselection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {
    static class Activity {
        public int id;
        public int start;
        public int finish;

        public Activity(int i, int s, int f) {
            id = i;
            start = s;
            finish = f;
        }
    }

    public List<Activity> select(List<Activity> activities) {
        List<Activity> selected = new ArrayList<>();
        List<Activity> sortedActivities = new ArrayList<>(activities);
        Collections.sort(sortedActivities, (o1, o2) -> Integer.signum(o1.finish - o2.finish));
        if (sortedActivities.size() > 0)
            selected.add(sortedActivities.get(0));
        for (int i = 1; i < sortedActivities.size(); i++)
            if (sortedActivities.get(i).start >= selected.get(selected.size() - 1).finish)
                selected.add(sortedActivities.get(i));
        return selected;
    }

    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 600, 720));
        activities.add(new Activity(2, 1200, 1380));
        activities.add(new Activity(3, 1020, 1140));
        activities.add(new Activity(4, 600, 630));
        activities.add(new Activity(5, 1140, 1230));
        activities.add(new Activity(6, 1290, 1380));
        activities.add(new Activity(7, 750, 810));
        activities.add(new Activity(8, 1200, 1320));
        activities.add(new Activity(9, 1020, 1170));
        activities.add(new Activity(10, 960, 1140));
        activities.add(new Activity(11, 900, 1020));

        ActivitySelection selection = new ActivitySelection();
        List<Activity> selected = selection.select(activities);
        for (int i = 0; i < selected.size(); i++) {
            System.out.print(selected.get(i).id);
            if (i + 1 < selected.size())
                System.out.print(", ");
            else
                System.out.print("\n");
        }
    }
}
