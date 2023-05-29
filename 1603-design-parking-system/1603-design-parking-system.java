class ParkingSystem {

    int park[];
    public ParkingSystem(int big, int medium, int small) {
        park = new int[3];
        park[0] = big;
        park[1] = medium;
        park[2] = small;
    }
    
    public boolean addCar(int carType) {
        if(park[carType - 1] > 0){
            park[carType - 1]--;
            return true;
        }else
            return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */