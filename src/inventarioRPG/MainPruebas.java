package inventarioRPG;

import java.util.Map;

public class MainPruebas {
	public static void main(String[] args) {
		Inventario inv= new Inventario();
		
        // Productos con los precios que te pedí
        Producto p50  = new Producto(1, "Pocion", 50);
        Producto p100 = new Producto(2, "Daga", 100);
        Producto p500 = new Producto(3, "Armadura", 500);
        Producto p700 = new Producto(4, "Espada Legendaria", 700);
        
        inv.agregarProducto(p50, 1);
        inv.agregarProducto(p100, 1);
        inv.agregarProducto(p500, 1);
        inv.agregarProducto(p700, 1);
        
        Map<String, Long> conteo= inv.contarProductosPorRangoDePrecio();
        System.out.println(conteo);
        
        inv.agregarProducto(p700, 99);
        System.out.println(inv.contarProductosPorRangoDePrecio());
        
        System.out.println(inv.contarProductosUsandoMetodoRangoDePrecioSinStreams());
	}
}
