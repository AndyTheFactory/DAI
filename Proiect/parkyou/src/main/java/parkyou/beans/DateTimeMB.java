/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.beans;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.SelectEvent;


@Named
@ManagedBean
@ViewScoped
public class DateTimeMB implements Serializable {
    
    private Date fromDate;
    private Date toDate;
    private Date exactDate;
    private Date minDateFrom;
    private Date maxDateFrom;    
    private Date minDateTo;
    private Date maxDateTo;    
    
    @PostConstruct
    public void init() {
        Date today = new Date();
        long oneDay = 24 * 60 * 60 * 1000;

        fromDate = new Date(today.getTime());
        toDate = new Date(today.getTime());
        
        minDateFrom = new Date(today.getTime());
        maxDateFrom = new Date(today.getTime() + (30 * oneDay));
        minDateTo = new Date(today.getTime());
        maxDateTo = new Date(today.getTime() + (30 * oneDay));
 
    }   
    
    public void onDateSelect(SelectEvent event) {
        Date date = (Date)event.getObject();
        if (event.getComponent().getId().equals("fromDate")){
            minDateTo.setTime(date.getTime());
        }else{
            maxDateFrom.setTime(date.getTime());
        }
    }
    
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getExactDate() {
        return exactDate;
    }

    public void setExactDate(Date exactDate) {
        this.exactDate = exactDate;
    }

    public Date getMinDateFrom() {
        return minDateFrom;
    }

    public void setMinDateFrom(Date minDateFrom) {
        this.minDateFrom = minDateFrom;
    }

    public Date getMaxDateFrom() {
        return maxDateFrom;
    }

    public void setMaxDateFrom(Date maxDateFrom) {
        this.maxDateFrom = maxDateFrom;
    }

    public Date getMinDateTo() {
        return minDateTo;
    }

    public void setMinDateTo(Date minDateTo) {
        this.minDateTo = minDateTo;
    }

    public Date getMaxDateTo() {
        return maxDateTo;
    }

    public void setMaxDateTo(Date maxDateTo) {
        this.maxDateTo = maxDateTo;
    }
    
}
