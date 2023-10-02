package org.absolut.actioncounter;

public interface ActionCounter {

    int getActions(int timestamp);

    void call(int timestamp);

}
