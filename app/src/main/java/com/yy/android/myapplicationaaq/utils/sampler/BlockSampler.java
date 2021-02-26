package com.yy.android.myapplicationaaq.utils.sampler;

import com.yy.android.myapplicationaaq.utils.HandlerThreadFactory;

import java.util.concurrent.atomic.AtomicBoolean;

import static com.yy.android.myapplicationaaq.utils.BlockConstants.SAMPLE_DELAY;

public abstract class BlockSampler {

    protected long sampleInterval;

    private AtomicBoolean shouldSample = new AtomicBoolean(false);

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            doSample();
            if (shouldSample.get()) {
                HandlerThreadFactory.getTimerThreadHandler().postDelayed(runnable, sampleInterval);
            }
        }
    };

    public BlockSampler(long sampleInterval) {
        this.sampleInterval = sampleInterval;
    }

    public void start() {
        if (shouldSample.get()) {
            return;
        }
        shouldSample.set(true);
        HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(runnable);
        HandlerThreadFactory.getTimerThreadHandler().postDelayed(runnable, SAMPLE_DELAY);
    }

    public void stop() {
        if (!shouldSample.get()) {
            return;
        }
        shouldSample.set(false);
        HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(runnable);
    }

    public abstract void doSample();
}
