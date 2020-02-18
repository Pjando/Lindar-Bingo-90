import java.util.List;

class TicketGenerator{

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Strip s = new Strip();
        List<Ticket> t = s.generateStrip();

        t.forEach(Ticket::printTickets);

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " +
                timeElapsed / 1000000);
    }
}