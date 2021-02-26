package com.yy.android.lib.wait;

class OutTurn {
    private boolean isSub = true;
    private int count = 0;

    public synchronized void sub() {
        try {
            while (!isSub ) {
                this.wait();
            }
            System. out.println("sub  ---- " + count);
            isSub = false ;
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        count++;

    }

    public synchronized void main() {
        try {
            while (isSub ) {
                this.wait();
            }
            System. out.println("main (((((((((((( " + count);
            isSub = true ;
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        count++;
    }
}