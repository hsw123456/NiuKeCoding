




public  class DefaultFactory extends AbstractFactory  {

 	
    public Vehicle createVehicle() {
    	return new Car();
    }
	
    public weapon createWeapon() {
    	return new AK47();
    }
	
    public Food createFood() {
    	return new Apple();
    }
}