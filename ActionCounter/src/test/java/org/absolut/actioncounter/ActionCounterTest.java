package org.absolut.actioncounter;

import org.absolut.actioncounter.impl.ActionCounterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class ActionCounterTest {

    private Queue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
    private ActionCounterImpl actionCounter;

    @BeforeEach
    void init() {
        linkedBlockingQueue.clear();
        actionCounter = new ActionCounterImpl(linkedBlockingQueue);
    }

    @Test
    void actionCounterWithValidVariables() {
        actionCounter.call(1);
        actionCounter.call(2);
        actionCounter.call(2);

        assertEquals(3, actionCounter.getActions(4));
        assertEquals(3, linkedBlockingQueue.size());

        actionCounter.call(300);

        assertEquals(4, actionCounter.getActions(300));
        assertEquals(4, linkedBlockingQueue.size());
        assertEquals(3, actionCounter.getActions(301));
        assertEquals(3, linkedBlockingQueue.size());
        assertEquals(1, actionCounter.getActions(305));
        assertEquals(1, linkedBlockingQueue.size());
    }

    @Test
    void createInvalidActionCounter() {
        assertThrows(IllegalArgumentException.class, () -> new ActionCounterImpl(null));
    }

    @Test
    void createValidActionCounter() {
        assertDoesNotThrow(() -> new ActionCounterImpl(new LinkedBlockingQueue<>()));
    }

}
