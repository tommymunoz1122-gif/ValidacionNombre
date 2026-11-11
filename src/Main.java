import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> catalogo = new LinkedHashMap<>();
        catalogo.put("Minecraft", 30);
        catalogo.put("Mario Kart", 50);
        catalogo.put("Stardew Valley", 15);

        List<String> compras = new ArrayList<>();
        String opcion;

        do {
            mostrarMenu();
            opcion = Valida.leerString("Seleccione una opción").trim();

            switch (opcion) {
                case "1" -> {
                    System.out.println("Juegos disponibles");
                    for (var juego : catalogo.entrySet()) {
                        mostrarPrecio(juego.getKey(), juego.getValue());
                    }
                }
                case "2" -> {
                    String juego = buscarJuego(catalogo);
                    if (juego != null) {
                        mostrarPrecio(juego, catalogo.get(juego));
                    }
                }
                case "3" -> {
                    String juego = buscarJuego(catalogo);
                    if (juego != null) {
                        compras.add(juego);
                        System.out.println("Compra registrada.");
                        mostrarPrecio(juego, catalogo.get(juego));
                    }
                }
                case "4" -> {
                    if (compras.isEmpty()) {
                        System.out.println("Todavía no hay compras.");
                    } else {
                        System.out.println("Juegos comprados");
                        for (String juego : compras) {
                            mostrarPrecio(juego, catalogo.get(juego));
                        }
                    }
                }
                case "5" -> {
                    int total = 0;
                    for (String juego : compras) {
                        total += catalogo.get(juego);
                    }
                    System.out.println("Total de compras: $" + total);
                }
                case "6" -> System.out.println("Fin del programa.");
                default -> System.out.println("Opción inválida. Elija del 1 al 6.");
            }
        } while (!opcion.equals("6"));
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("=== TIENDA DE VIDEOJUEGOS ===");
        System.out.println("1. Ver catálogo");
        System.out.println("2. Buscar juego por nombre");
        System.out.println("3. Comprar juego por nombre");
        System.out.println("4. Ver compras");
        System.out.println("5. Ver total de compras");
        System.out.println("6. Salir");
    }

    private static String buscarJuego(Map<String, Integer> catalogo) {
        String nombre = Valida.leerString("Ingrese el nombre del juego").trim();
        for (String juego : catalogo.keySet()) {
            if (juego.equalsIgnoreCase(nombre)) {
                return juego;
            }
        }
        System.out.println("No se encontró el juego: " + nombre);
        return null;
    }

    private static void mostrarPrecio(String juego, int precio) {
        System.out.println(juego + " - $" + precio);
    }
}
