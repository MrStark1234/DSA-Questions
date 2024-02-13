var ParkingSystem = function (big, medium, small) {
  this.big = big;
  this.medium = medium;
  this.small = small;
};

ParkingSystem.prototype.addCar = function (carType) {
  switch (carType) {
    case 1:
      if (this.big > 0) {
        this.big--;
        return true;
      }
      break;
    case 2:
      if (this.medium > 0) {
        this.medium--;
        return true;
      }
      break;
    case 3:
      if (this.small > 0) {
        this.small--;
        return true;
      }
      break;
  }
  return false;
};

let Parking = new ParkingSystem(2, 1, 0);
console.log(Parking.addCar(1));
console.log(Parking.addCar(1));
console.log(Parking.addCar(1));
console.log(Parking.addCar(2));
console.log(Parking.addCar(3));
