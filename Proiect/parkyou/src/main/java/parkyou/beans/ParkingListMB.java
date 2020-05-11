/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.beans;

import org.omnifaces.cdi.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import parkyou.entity.Parkingspot;
import parkyou.model.Filter;
import parkyou.model.ParkingspotModel;


@Named
@ViewScoped
public class ParkingListMB implements Serializable {
    @Inject
    ParkingspotModel parkingspotModel;
    
    Integer id;

    LazyDataModel<Parkingspot> parking;

    Filter<Parkingspot> filter = new Filter<>(new Parkingspot());
    
    private List<Parkingspot> selectedParking; //cars selected in checkbox column

    List<Parkingspot> filteredValue;// datatable filteredValue attribute (column filters)


    @Inject
    private DateTimeMB dateBean;
    
    @PostConstruct
    public void initDataModel() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String viewId = facesContext.getViewRoot().getViewId();

        if (viewId.contains("parking-schedule")){
            parking = null;
        }else{
            parking = new LazyDataModel<Parkingspot>() {
                @Override
                public List<Parkingspot> load(int first, int pageSize,
                                      String sortField, SortOrder sortOrder,
                                      Map<String, Object> filters) {
                    parkyou.model.SortOrder order = null;
                    if (sortOrder != null) {
                        order = sortOrder.equals(SortOrder.ASCENDING) ? parkyou.model.SortOrder.ASCENDING
                                : sortOrder.equals(SortOrder.DESCENDING) ? parkyou.model.SortOrder.DESCENDING
                                : parkyou.model.SortOrder.UNSORTED;
                    }
                    filter.setFirst(first).setPageSize(pageSize)
                            .setSortField(sortField).setSortOrder(order)
                            .setParams(filters);
                    List<Parkingspot> list = parkingspotModel.paginate(filter);
                    setRowCount((int) parkingspotModel.count(filter));
                    return list;
                }

                @Override
                public int getRowCount() {
                    return super.getRowCount();
                }

                @Override
                public Parkingspot getRowData(String key) {
                    return parkingspotModel.findById(new Integer(key));
                }
            };
        }
    }   
    
    public void selectRange(){
        parking = new LazyDataModel<Parkingspot>() {
            @Override
            public List<Parkingspot> load(int first, int pageSize,
                                  String sortField, SortOrder sortOrder,
                                  Map<String, Object> filters) {
                parkyou.model.SortOrder order = null;
                if (sortOrder != null) {
                    order = sortOrder.equals(SortOrder.ASCENDING) ? parkyou.model.SortOrder.ASCENDING
                            : sortOrder.equals(SortOrder.DESCENDING) ? parkyou.model.SortOrder.DESCENDING
                            : parkyou.model.SortOrder.UNSORTED;
                }
                filter.setFirst(first).setPageSize(pageSize)
                        .setSortField(sortField).setSortOrder(order)
                        .setParams(filters);
                List<Parkingspot> list = parkingspotModel.paginate(filter,
                        dateBean.getFromDate(),
                        dateBean.getToDate()
                        );
                setRowCount((int) parkingspotModel.count(filter));
                return list;
            }

            @Override
            public int getRowCount() {
                return super.getRowCount();
            }

            @Override
            public Parkingspot getRowData(String key) {
                return parkingspotModel.findById(new Integer(key));
            }
        };
    }

    public void clear() {
        filter = new Filter<Parkingspot>(new Parkingspot());
    }
    
    public void onRowSelect(SelectEvent event) {
        System.out.println(event.getObject());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LazyDataModel<Parkingspot> getParking() {
        return parking;
    }

    public void setParking(LazyDataModel<Parkingspot> parking) {
        this.parking = parking;
    }

    public Filter<Parkingspot> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Parkingspot> filter) {
        this.filter = filter;
    }

    public List<Parkingspot> getSelectedParking() {
        return selectedParking;
    }

    public void setSelectedParking(List<Parkingspot> selectedParking) {
        this.selectedParking = selectedParking;
    }

    public List<Parkingspot> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Parkingspot> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public DateTimeMB getDateBean() {
        return dateBean;
    }

    public void setDateBean(DateTimeMB dateBean) {
        this.dateBean = dateBean;
    }
    
    
}
