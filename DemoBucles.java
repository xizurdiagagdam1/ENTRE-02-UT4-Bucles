import java.util.Random;
/**
 *    @author - 
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;
    private int numero;

    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int contador = 1;
        int potencia = 1;
        while(Math.pow(2, contador) <= numero){
            potencia = (int)Math.pow(2, contador);
            contador ++;
        }
        return potencia;
    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        int restar = 0;
        System.out.printf("\n%6d =", numero);
        int contador = 1;
        while(contador <= 6 && numero != restar){
            System.out.printf("%6d",mayorPotencia2(numero - restar));
            restar += mayorPotencia2(numero - restar);
            contador ++;
        }
    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {
        int contador = 1;
        int generado;
        System.out.printf("%s", "Nºs aleatorios como suma de potencias de 2");
        while(contador <= n){
            generado = generador.nextInt(256);
            if(generado == 0){
                contador = n + 10;
            }else{
                escribirSumaPotencias(generado);
                contador ++;
            }
        }

        if(contador == n + 10){
            System.out.printf("\n%s", "Proceso terminado porque se ha generado un 0");
        }else{
            System.out.printf("\n%s %d %s", "Proceso terminado porque se han generado ya",n, "aleatorios");
        }
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
        for(int contador = 1; contador <= n; contador ++){
            if(caracter == ASTERISCO){
                System.out.printf("%c",ASTERISCO);
            }else if(caracter == ESPACIO){
                System.out.printf("%c",ESPACIO);
            }else{
                System.out.printf("%s","Los carácteres permitidos son '*' y ' '");
            }
        }
    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public void mostrarEscalera(int escalones, int alto, int ancho){
        System.out.println();
        int multiplicar = 0;
        for(int a = 1; a <= escalones; a ++){
                for(int b = 1; b <= alto; b ++){
                    escribirCaracter(ancho * multiplicar, ' ');
                    escribirCaracter(ancho, '*');
                    System.out.printf("\n");
                }
                multiplicar ++;
        }
    }
}
