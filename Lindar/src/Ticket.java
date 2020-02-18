import java.util.*;

class Ticket{

    /**
     * Numbers for the ticket
     */
    Map<Integer, List<Integer>> numbers;
    /**
     * Keeps track of amount of numbers in each row
     */
    Map<Integer, Integer> rows;
    /**
     * List of numbers that have not been used yet.
     */
    List<Integer> remainingNumbers;

    /**
     * Creates ticket initialising variables
     * @param remainingNumbers The pool of numbers left to use for the ticket.
     */
    public Ticket(List<Integer> remainingNumbers){
        this.remainingNumbers = remainingNumbers;
        numbers = new HashMap<>();
        rows = new HashMap<>();
        rows.put(1, 0);
        rows.put(2, 0);
        rows.put(3, 0);
        createTicket();
    }

    /**
     * Gets the remaining numbers after the ticket has been created.
     * @return List of integers that were not used for this ticket.
     */
    public List<Integer> getRemainingNumbers(){
        return remainingNumbers;
    }

    /**
     * Creates ticket following Bingo 90 criteria.
     */
    private void createTicket() {
        /**
         * The random number created for the ticket.
         */
        int randomNum;
        /**
         * Indicates which row randomNum should be in.
         */
        int index;
        /**
         * Temporarily holds each column list.
         */
        List<Integer> temp;
        /**
         * The column to generate a number for.
         */
        int col;

        /**
         * Ensures each column has at least one number.
         */
        while((rows.get(1) < 5) || (rows.get(2) < 5) || (rows.get(3) < 5)){

            col = getRandomNumber(1, 9);

            /**
             * Creates list for column if there is not already one.
             */
            if (!numbers.containsKey(col)) {
                temp = new ArrayList<>(Arrays.asList(0, 0, 0));
            } else {
                temp = numbers.get(col);
            }

            /**
             * Generate random number for column.
             * Regenerates number if number is not remaining.
             */
            do{
                randomNum = getRandomNumber((col * 10) - 9, col * 10);
            } while(!remainingNumbers.contains(randomNum));


            /**
             * Generate row index for number to be stored in.
             * Regenerates index if row has 5 numbers already.
             */
            do{
                index = getRandomNumber(0,2);
            } while(rows.get(index + 1) >= 5);

            /**
             * If location has a 0 and the row has less than 5 numbers
             * Increment row counter and set number at location.
             */
            if(temp.get(index).equals(0)){
                rows.merge(index + 1, 1, Integer::sum);
                temp.set(index, randomNum);
                remainingNumbers.remove(Integer.valueOf(randomNum));
            }
            /**
             * Store column and list.
             */
            numbers.put(col, temp);
        }
    }

    /**
     * Prints the ticket.
     */
    public void printTickets(){
        numbers.forEach((key, value) -> System.out.println(value));
        System.out.println();
    }

    /**
     * Generates random number within a range
     * @param min minimum of the range
     * @param max maximum of the range
     * @return random number inclusive of range.
     */
    private int getRandomNumber(int min, int max){
        return (int)(Math.random() * ((max-min) + 1)) + min;
    }
}