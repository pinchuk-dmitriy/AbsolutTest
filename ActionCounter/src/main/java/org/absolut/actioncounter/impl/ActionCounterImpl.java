package org.absolut.actioncounter.impl;

import org.absolut.actioncounter.ActionCounter;
import org.absolut.actioncounter.validation.TimestampValidator;

import java.util.LinkedList;
import java.util.Queue;

public class ActionCounterImpl implements ActionCounter {

    private final Queue<Integer> timestamps;

    public ActionCounterImpl() {
        timestamps = new LinkedList<>();
    }

    public ActionCounterImpl(Queue<Integer> queue) {
        if (queue == null) {
            throw new IllegalArgumentException("Queue must not be null");
        }

        timestamps = queue;
    }

    public void call(int timestamp) {
        TimestampValidator.validateTimestamp(timestamp);

        timestamps.add(timestamp);
        cleanUpQueue(timestamp);
    }

    public int getActions(int timestamp) {
        TimestampValidator.validateTimestamp(timestamp);

        cleanUpQueue(timestamp);

        return timestamps.size();
    }

    private void cleanUpQueue(int timestamp) {
        while (!timestamps.isEmpty() && timestamps.peek() <= timestamp - 300) {
            timestamps.poll();
        }
    }

}
