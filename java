class Electrodomestico {
    protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;
    
    protected static final String COLOR_DEFECTO = "blanco";
    protected static final char CONSUMO_ENERGETICO_DEFECTO = 'F';
    protected static final double PRECIO_BASE_DEFECTO = 100.0;
    protected static final double PESO_DEFECTO = 5.0;
    
    protected static final String[] COLORES_DISPONIBLES = { "blanco", "negro", "rojo", "azul", "gris" };
    protected static final char[] CONSUMOS_ENERGETICOS = { 'A', 'B', 'C', 'D', 'E', 'F' };
    protected static final double[] PRECIOS_CONSUMO = { 100.0, 80.0, 60.0, 50.0, 30.0, 10.0 };
    
    public Electrodomestico() {
        this.precioBase = PRECIO_BASE_DEFECTO;
        this.color = COLOR_DEFECTO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
        this.peso = PESO_DEFECTO;
    }
    
    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.color = COLOR_DEFECTO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
        this.peso = peso;
    }
    
    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }
    
    public double getPrecioBase() {
        return precioBase;
    }
    
    public String getColor() {
        return color;
    }
    
    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }
    
    public double getPeso() {
        return peso;
    }
    
    protected char comprobarConsumoEnergetico(char letra) {
        letra = Character.toUpperCase(letra);
        for (char consumo : CONSUMOS_ENERGETICOS) {
            if (letra == consumo) {
                return letra;
            }
        }
        return CONSUMO_ENERGETICO_DEFECTO;
    }
    
    protected String comprobarColor(String color) {
        color = color.toLowerCase();
        for (String col : COLORES_DISPONIBLES) {
            if (color.equals(col)) {
                return color;
            }
        }
        return COLOR_DEFECTO;
    }
    
    public double precioFinal() {
        double precioFinal = precioBase;
        int indiceConsumo = 0;
        for (int i = 0; i < CONSUMOS_ENERGETICOS.length; i++) {
            if (consumoEnergetico == CONSUMOS_ENERGETICOS[i]) {
                indiceConsumo = i;
                break;
            }
        }
        precioFinal += PRECIOS_CONSUMO[indiceConsumo];
        
        if (peso >= 0 && peso < 20) {
            precioFinal += 10.0;
        } else if (peso >= 20 && peso < 50) {
            precioFinal += 50.0;
        } else if (peso >= 50 && peso < 80) {
            precioFinal += 80.0;
        } else if (peso >= 80) {
            precioFinal += 100.0;
        }
        
        return precioFinal;
    }
}

class Lavadora extends Electrodomestico {
    private double carga;
    
    private static final double CARGA_DEFECTO = 5.0;
    
    public Lavadora() {
        super();
        this.carga = CARGA_DEFECTO;
    }
    
    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = CARGA_DEFECTO;
    }
    
    public Lavadora(double carga, double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }
    
    public double getCarga() {
        return carga;
    }
    
    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();
        if (carga > 30.0) {
            precioFinal += 50.0;
        }
        return precioFinal;
    }
}

class Television extends Electrodomestico {
    private double resolucion;
    private boolean sintonizadorTDT;
    
    private static final double RESOLUCION_DEFECTO = 20.0;
