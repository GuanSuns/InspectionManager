package org.lin.inspection.manager.scheduler;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

public abstract class AbstractScheduler implements Runnable{
    protected Future future;
    protected CountDownLatch setFutureCountDown;
    protected CountDownLatch mainSchedulerCountDown;

    public void setFuture(Future future) {
        this.future = future;
    }

    public void setSetFutureCountDown(CountDownLatch setFutureCountDown) {
        this.setFutureCountDown = setFutureCountDown;
    }

    public void setMainSchedulerCountDown(CountDownLatch mainSchedulerCountDown) {
        this.mainSchedulerCountDown = mainSchedulerCountDown;
    }

    protected Future getFuture() {
        return future;
    }

    protected CountDownLatch getSetFutureCountDown() {
        return setFutureCountDown;
    }

    protected CountDownLatch getMainSchedulerCountDown() {
        return mainSchedulerCountDown;
    }
}
