/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

/**
 *
 * @author Thắng Bùi
 */
public class Word {
    private String low;
    private String high;

    public Word(String low, String high) {
        this.low = low;
        this.high = high;
    }

    public Word() {
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Word{" + "low=" + low + ", high=" + high + '}';
    }
    
}
