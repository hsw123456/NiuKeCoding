




public  class MegicFactory extends AbstractFactory  {

 	
    public Vehicle createVehicle() {
    	return new Broom();
    }
	
    public weapon createWeapon() {
    	return new MagicStick();
    }
	
    public Food createFood() {
    	return new MushRoom();
    }
}