package cs151_project;

import java.util.ArrayList;

public class CalendarModel
{
    private ArrayList<Agenda> agendalist;
    private int AgendaOrder;
    private int currentmonth, currentday, currentyear;
    public CalendarModel()
    {
        agendalist = new ArrayList();
    }
    
    public void addAgenda(Agenda agen)
    {
        agendalist.add(agen);
    }
    public Agenda getAgenda(int n)
    {
        if(agendalist.isEmpty())
        {
            return new Agenda();
        }
        else
        {
            return agendalist.get(n);
        }
    }
    //CHANGES VIEW FOR AGENDA FOR DAY, WEEK, MONTH, AGENDA
    //0,1,2,3
    public void setOrder(int n)
    {
        AgendaOrder = n;
    }
    public int getOrder()
    {
        return AgendaOrder;
    }
    //SETS DAY FOR THE VIEWS
    public void setMonth(int n)
    {
        currentmonth = n;
    }
    public void setDay(int n)
    {
        currentday = n;
    }
    public void setYear(int n)
    {
        currentyear = n;
    }
    public int getMonth()
    {
        return currentmonth;
    }
    public int getDay()
    {
        return currentday;
    }
    public int getYear()
    {
        return currentyear;
    }
    
}
