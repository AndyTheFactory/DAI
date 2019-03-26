/*
 * Copyright 2010 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */


package guessNumber;

import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UserNumberBean {
    Integer randomInt = null;
    Integer userNumber = null;
    String response = null;
    private long maximum = 10;
    private long minimum = 0;
    private int nrTries=0;
    private int nrSuccess=0;
    String message="";
    private void genNumber()
    {
        Random randomGR = new Random();
        randomInt = new Integer(randomGR.nextInt(10));
    }
    public UserNumberBean() {
        genNumber();
        System.out.println("Duke's number: " + randomInt);
    }

    public void setUserNumber(Integer user_number) {
        userNumber = user_number;
    }

    public Integer getUserNumber() {
        return userNumber;
    }
    public Integer getNrTries(){
        return nrTries;
    }
    public Integer getNrSuccess(){
        return nrSuccess;
    }

    public String getResponse() {
        String res;
        nrTries+=1;
        if ((userNumber != null) && (userNumber.compareTo(randomInt) == 0)) {
            res=String.format("Yay! You got it! My Number was %d",userNumber);
            nrSuccess+=1;
        } else {
            res=String.format("Sorry, %d is incorrect. My number was %d",userNumber,randomInt);
        }
        genNumber();
        return res;
    }

    public long getMaximum() {
        return (this.maximum);
    }

    public void setMaximum(long maximum) {
        this.maximum = maximum;
    }

    public long getMinimum() {
        return (this.minimum);
    }

    public void setMinimum(long minimum) {
        this.minimum = minimum;
    }
    public void reset(){
        genNumber();
        this.message= "Number was resetted! "+randomInt;
    }
    public Integer getNr(){
        return this.randomInt;
    }
    public String getMessage(){
        return this.message;
    }
}
