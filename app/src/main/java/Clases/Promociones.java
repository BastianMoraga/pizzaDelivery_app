package Clases;

public class Promociones {

    private String pizzasPromo;
    private String masterPizza;
    private String pizzaMax;

    public  Promociones()
    {
        pizzasPromo = "5990";
        masterPizza = "12990";
        pizzaMax = "18500";
    }

    public String getPizzasPromo() {
        return pizzasPromo;
    }

    public void setPizzasPromo(String pizzasPromo) {
        this.pizzasPromo = pizzasPromo;
    }

    public String getMasterPizza() {
        return masterPizza;
    }

    public void setMasterPizza(String masterPizza) {
        this.masterPizza = masterPizza;
    }

    public String getPizzaMax() {
        return pizzaMax;
    }

    public void setPizzaMax(String pizzaMax) {
        this.pizzaMax = pizzaMax;
    }
}
