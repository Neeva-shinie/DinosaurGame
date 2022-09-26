package game;

/**
 * Currency
 */
public interface Transaction {
    /**
     * A static class to implement methods
     */
    class Points{
        private int ecoPoints = 100;

        /**
         * Constructor
         */

        public Points() {
        }

        /**
         * adding points
         * @param points int
         * @return ecopoints
         */
        public int addpoints(int points){
            ecoPoints += points;
            return ecoPoints;
        }
        /**
         * remove points
         * @param points int
         * @return ecopoints
         */
        public int removepoints(int points){
            if(ecoPoints != 0){
                ecoPoints-=points;
            }
            else{
                System.out.println("Insufficient points");
            }
           return ecoPoints;
        }
        /**
         * display points
         * @return final ecopoints
         */

        public String displaypoints(){
            String finalpoint;
            finalpoint = String.valueOf(ecoPoints);
            return  finalpoint;
        }



    }


}
