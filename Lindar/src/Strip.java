import java.util.*;

class Strip{

    List<Ticket> ticketStrip;
    List<Integer> stripGrid;

    public Strip(){
        ticketStrip = new ArrayList<>();
        stripGrid = new ArrayList<>();

        for (int i = 1; i <= 90; i++) {
            stripGrid.add(i);
        }
    }

    public List<Ticket> generateStrip(){
        generateTickets();
        return ticketStrip;
    }

    private void generateTickets(){
        Ticket t1 = new Ticket(stripGrid);
        ticketStrip.add(t1);
        /*Ticket t2 = new Ticket(t1.getRemainingNumbers());
        Ticket t3 = new Ticket(t2.getRemainingNumbers());
        Ticket t4 = new Ticket(t3.getRemainingNumbers());
        Ticket t5 = new Ticket(t4.getRemainingNumbers());
        Ticket t6 = new Ticket(t5.getRemainingNumbers());
        ticketStrip.addAll(Arrays.asList(t1, t2 ,t3 ,t4 ,t5 , t6));*/
    }
}