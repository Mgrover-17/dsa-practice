class ParkingSystem {
// int big;
// int medium;
// int small;
//     public ParkingSystem(int big, int medium, int small) {
//             this.big=big;
//             this.medium=medium;
//             this.small=small;
//     }

//     public boolean addCar(int carType) {
//         if(carType==1 && big>0){
//             big--;
//             return true;
//         }
//         else if(carType==2 && medium>0){
//             medium--;
//             return true;
//         }
//         else if(carType==3 && small>0){
//             small--;
//             return true;
//         }
//         else{
//             return false;
//         }
//     }
// }

    int slots[]=new int[4];
    public ParkingSystem(int big, int medium, int small){
        slots[1]=big;
        slots[2]=medium;
        slots[3]=small;
    }
    public boolean addCar(int carType){
        if(slots[carType]>0){
            slots[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */