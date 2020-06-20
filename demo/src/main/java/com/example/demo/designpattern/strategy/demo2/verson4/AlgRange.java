package com.example.demo.designpattern.strategy.demo2.verson4;

import com.example.demo.designpattern.strategy.demo2.verson2.ISortAlg;

/**
 * @author limh
 * @version 2020年06月20日 08:57 limh Exp $
 */
public class AlgRange {

    private long start;
    private long end;
    private ISortAlg alg;

    public AlgRange(long start, long end, ISortAlg alg) {
        this.start = start;
        this.end = end;
        this.alg = alg;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public ISortAlg getAlg() {
        return alg;
    }

    public void setAlg(ISortAlg alg) {
        this.alg = alg;
    }

    public boolean inRange(long size) {
        return size >= start && size < end;
    }
}
