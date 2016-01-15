import java.util.ArrayList;

public class Usuario
{
    //nombre del usuario
    private String nombreCompleto;
    //proteinas  ingeridas por el usuario
    private float proteinasIngeridas;
    //carbohidratos   ingeridas por el usuario
    private float carbohidratosIngeridos;
    //grasas ingeridas por el usuario
    private float grasasIngeridas;
    //calorias totales ingeridas por el usuario
    private float caloriasIngeridas;
    //Alimento mas calorico
    private Alimento aliMasCalorico;
    //Lista de los alimentos ingeridos por el usuario
    private ArrayList<Alimento> alimentos;

    /**
     *Constructor de la clase usuario
     */
    public Usuario (String nombreCompleto)
    {
        this.nombreCompleto = nombreCompleto;   
        proteinasIngeridas = 0;
        carbohidratosIngeridos = 0;
        grasasIngeridas = 0;
        caloriasIngeridas = 0;
        aliMasCalorico = null;
        alimentos = new ArrayList<Alimento>();
    }

    /**
     * Metodo utilizado para dar de comer al usuario
     */
    public void comer(Alimento alimentoQueCome, float gramosDelAlimento)
    {     
        proteinasIngeridas = proteinasIngeridas + (alimentoQueCome.getProteinas() / 100 * gramosDelAlimento);
        carbohidratosIngeridos = carbohidratosIngeridos + (alimentoQueCome.getCarbohidratos() / 100 * gramosDelAlimento);
        grasasIngeridas = grasasIngeridas + (alimentoQueCome.getGrasas() / 100 * gramosDelAlimento);
        caloriasIngeridas = caloriasIngeridas + (alimentoQueCome.getCalorias() / 100 * gramosDelAlimento);

        if (aliMasCalorico == null || aliMasCalorico.getCalorias() <= alimentoQueCome.getCalorias()){
            aliMasCalorico = alimentoQueCome;
        }

        alimentos.add(alimentoQueCome);
    }

    /**
     * Metodo que muestra la informacion de lo ingerido por el usuario.
     */
    public void muestraDatos()
    {
        float totalNutrientes = (proteinasIngeridas + grasasIngeridas + carbohidratosIngeridos) / 100;
        String datosProteinas = "Gramos totales de proteinas ingeridos:     " + proteinasIngeridas;
        String datosCarbohidratos = "Gramos totales de carbohidratos ingeridos: " +             carbohidratosIngeridos;
        String datosGrasas = "Gramos totales de grasas ingeridos:        " + grasasIngeridas;
        if (proteinasIngeridas > 0) {
            datosProteinas = datosProteinas + " (" + proteinasIngeridas / totalNutrientes + "%)";
        }
        if (carbohidratosIngeridos > 0) {
            datosCarbohidratos = datosCarbohidratos + " (" + carbohidratosIngeridos / totalNutrientes + "%      )";
        }
        if (grasasIngeridas > 0) {
            datosGrasas = datosGrasas + " (" + grasasIngeridas / totalNutrientes + "%)";
        }
        System.out.println("Nombre:                                    " + nombreCompleto);
        System.out.println(datosProteinas);    
        System.out.println(datosCarbohidratos);
        System.out.println(datosGrasas);
        System.out.println("Calorias totales ingeridas:                " + caloriasIngeridas);  
    }

    /**
     * Metodo que devuelve el nombre del usuario.
     */
    public String getNombre()
    {
        return nombreCompleto;
    }

    /**
     * Metodo que devuelve las calorias ingeridas por el usuario.
     */
    public float getCalorias()
    {
        return caloriasIngeridas;
    }

    /**
     * Metodo para comparar las calorias entre dos usuarios.
     */
    public void compararCalorias(Usuario usuario)
    {
        String nombreOtro = usuario.getNombre();
        float caloriasOtro = usuario.getCalorias();

        if (caloriasIngeridas > caloriasOtro){
            System.out.println(nombreCompleto + " ha consumido más calorias que " + nombreOtro + " (" + caloriasIngeridas + " frente a " + caloriasOtro + ").");
        }
        else if (caloriasIngeridas < caloriasOtro){
            System.out.println(nombreOtro + " ha consumido más calorias que " + nombreCompleto + " (" + caloriasOtro + " frente a " + caloriasIngeridas + ").");
        }
        else{
            System.out.println(nombreCompleto + " y " + nombreOtro + " han consumido la misma cantidad de calorias (" + caloriasIngeridas + " igual a " + caloriasOtro + ").");
        }
    }

    /**
     * Metodo para imprimir el alimento con mayor calorias.
     */
    public void alimentoMasCalorias()
    {
        if (getCalorias() > 0){
            System.out.println("Alimento más calórico ingerido por este usuario hasta el momento: " + aliMasCalorico.getNombre() + " (" + aliMasCalorico.getCalorias() + " calorias por cada 100 gramos");
        }
        else{
            System.out.println("No se ha ingerido ningun alimento hasta este momento");
        }
    }

    public void datosDeLosalimentos(int nDeAlimento){
        if (nDeAlimento < alimentos.size()){
            Alimento pedido = alimentos.get(nDeAlimento - 1);
            pedido.muestraDatos();
        }
        else if (nDeAlimento <= 0){
            System.out.println("Imposible mostrar los datos de un alimento no ingerido.");
        }
        else{
            System.out.println("No se ha ingerido tantos alimentos");
        }
    }

    
}