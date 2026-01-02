package inventarioRPG;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class Inventario {
	/* --------------------- ATRIBUTOS --------------------- */
	private final HashMap<Producto, Integer> inventario= new HashMap<>();
	
	/* --------------------- CONSTRUCTOR --------------------- */
	public Inventario() {}
	
	/* --------------------- MÉTODOS --------------------- */
	public void agregarProducto(Producto item, int unids) {
		if (item == null) throw new IllegalArgumentException("Producto no puede ser null");
		if (unids<=0) throw new IllegalArgumentException("Para agregar un producto tienes que añadir un valor positivo");
		if (inventario.containsKey(item)) inventario.merge(item, unids, Integer::sum);
		else inventario.put(item, unids);
	}
	
	public void retirarProducto(Producto item, int unids) {
		if (item == null) throw new IllegalArgumentException("Producto no puede ser null");
		if (unids <=0) throw new IllegalArgumentException("Introduce cantidad correcta a retirar");
		if (!inventario.containsKey(item)) throw new IllegalStateException("El producto indicado no existe.");

		int stock= inventario.get(item).intValue();
		if (stock < unids) throw new StockInsuficienteException("No hay suficiente stock para restar");
		
		inventario.merge(item, -unids, Integer::sum);
		if (inventario.get(item).intValue() == 0) inventario.remove(item);
	}
	
	public int stockDe(Producto item) {
		return inventario.getOrDefault(item, 0);
	}
	
	public void imprimirInventarioOrdenadoPorNombre() {
		inventario.entrySet().stream().sorted(Comparator.comparing(e-> e.getKey().getNombre(), String.CASE_INSENSITIVE_ORDER)).forEach(e-> System.out.println(e.getKey().getNombre() + " : " + e.getValue()));
	}
	
	public void topNMasCaros(int n) {
		inventario.entrySet().stream().sorted(Comparator.comparingDouble((Map.Entry<Producto, Integer> e) -> e.getKey().getPrecio()).reversed()).limit(n).forEach(e-> System.out.println(e.getKey().getNombre() + " : " + e.getValue()));
	}
	
	public List<Producto> obtenerTopNMasCaros(int n){
		if (n <= 0) throw new IllegalArgumentException("n debe ser mayor a 0");
		return inventario.entrySet().stream()
				.sorted(Comparator.comparingDouble((Map.Entry<Producto, Integer> e)-> e.getKey().getPrecio()).reversed())
				.limit(n)
				.map(e-> e.getKey())
				.toList();
	}
	
	public Map<String, Long> contarProductosPorRangoDePrecio(){
		return inventario.keySet().stream()
				.collect(Collectors.groupingBy(
						(Producto p) -> {
							if(p.getPrecio() < 100) {
								return "BARATO";
							} else if (p.getPrecio() <= 500){
								return "MEDIO";
							} else {
								return "CARO";
							}
						},
						Collectors.counting()
						));
	}
	
	public String rangoDePrecio(Producto p) {
		double precio= p.getPrecio();
		if (precio < 100) return "BARATO";
		else if (precio <= 500) return "MEDIO";
		else return "CARO";
	}
	
	public Map<String, Long> contarProductosUsandoMetodoRangoDePrecio() {
		return inventario.keySet().stream()
				.collect(Collectors.groupingBy(
				this::rangoDePrecio,
				Collectors.counting()
				));
	}
	
	public Map<String, Long> contarProductosUsandoMetodoRangoDePrecioSinStreams() {
		Map<String, Long> result= new HashMap<>();
		for (Producto p: inventario.keySet()) {
			String rango= rangoDePrecio(p);
			result.put(rango, result.getOrDefault(rango, 0L) +1);
		}
		return result;
	}

}
