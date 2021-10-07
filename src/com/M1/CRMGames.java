package com.M1;
import java.util.*;


public class CRMGames {
    public static void showmenu(){
        System.out.println("Selecciona una opción:");

        System.out.println("1 - Crear un nuevo producto");
        System.out.println("2 - Ver todos los productos");
        System.out.println("3 - Ver un producto (por Código de barras)");
        System.out.println("4 - Modificar un producto (por Código de barras)");
        System.out.println("5 - Borrar un producto (por Código de barras)");
        System.out.println("6 - Borrar todos los registros");
        System.out.println("7 - Vender un producto");
        System.out.println("8 - Salir");
    }

    public static void main(String[] args) {


        // 1. Crear el objeto scanner

        // Videojuegos
        List<Videojuegos> item = new ArrayList<>();
        // crear datos demo

        item.add(new Videojuegos(1111L, "Super Mario Galaxy", "Nintendo Switch", 3, 39.99, false, new ArrayList<>(), 1));

        List<String> locations = new ArrayList<>();
        locations.add("expositor1H2");
        Videojuegos videojuegosDemo = new Videojuegos(2222L, "Diablo II", "Ps4", 18, 39.99, false, locations, 1);
        item.add(videojuegosDemo);

        while (true) {

            Scanner scanner = new Scanner(System.in);

            showmenu();
            try {
            int opcion = scanner.nextInt();


            if (opcion == 1) {

                System.out.println("Has seleccionado la opción 1 - Crear un nuevo producto ");

                // 2. leer datos de la consola
                Long code;


                System.out.println("Introduce el código de barras");
                code = scanner.nextLong();
                scanner.nextLine();


                // comprobar si existe un producto con ese código de barras
                // si existe entonces añadimos una cantidad en Stock y  volvemos principal
                // si no existe entonces permitimos crear
                boolean codeOcupado = false;

                for (Videojuegos videojuegos : item) {
                    if (videojuegos.codeBar.equals(code)) {
                        // ya existe un producto con este código de barras, entonce añadimos al stock
                        codeOcupado = true;
                        {
                            System.out.println("que cantidad quiere añadir al Stock= ");
                            int qty = scanner.nextInt();
                            videojuegos.stock += qty;

                            System.out.println("el stock se ha modificado a " + videojuegos.stock);
                        }
                        break;
                    }
                }

                // si codeOcupado es verdadero entonces no continuamos el proceso de creación del producto
                // si codeOcupado es true entonces pasamos al  siguiente paso del bucle while
                if (codeOcupado) {

                    continue;
                }


                System.out.println("Introduce el nombre del producto");
                String nombre = scanner.nextLine();

                System.out.println("ha seleccionado " + nombre);

                System.out.println("Introduce la plataforma de este producto");
                String plataforma = scanner.nextLine();
                System.out.println("ha introducido: " + plataforma);

                System.out.println("Introduce el Pegi del producto");
                int pegi = scanner.nextInt();
                System.out.println("ha introducido: " + pegi);
                scanner.nextLine();
                System.out.println("Introduce el precio (con decimales usando ,)");
                double precio = scanner.nextDouble();
                System.out.println("ha introducido: " + precio);
                scanner.nextLine();
                System.out.println("Introduce si tiene opción de multijugador o no (true o false)");
                boolean multijugador = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println("ha introducido: mutijugador " + multijugador);
                System.out.println("¿Quiere añadir una ubicación? :  (true/false");
                boolean havLocation = scanner.nextBoolean();
                List<String> ubicacion = new ArrayList<>();
                if (havLocation) {

                    System.out.println("Introduce la ubicación ");
                    String location = scanner.next();
                    scanner.nextLine();
                    System.out.println("ha introducido la localización: " + location);
                    ubicacion.add(location);
                }
                System.out.println("Introduce la cantidad de productos: ");
                Integer stock = scanner.nextInt();

                System.out.println("ha introducido: " + stock);
                scanner.nextLine();

                // 3. Crear objeto con los datos de la entrada


                Videojuegos newItem = new Videojuegos(code, nombre, plataforma, pegi, precio, multijugador, ubicacion, stock);
                System.out.println(newItem);
                item.add(newItem);


            } else if (opcion == 2) {
                System.out.println("Has seleccionado la opción 2 - Ver todos productos");

                if (item.isEmpty()) {
                    System.out.println("No hay productos.");
                } else {
                    System.out.println(item);
                    System.out.println("El número de productos es: " + item.size());
                }
            } else if (opcion == 3) {
                System.out.println("Has seleccionado la opción 3 - Ver un producto (por Código de barras) ");

                System.out.println("Introduce el Código de barras a consultar");
                Long code = scanner.nextLong();


                boolean exists = false;
                for (Videojuegos videojuegos : item) {
                    if (videojuegos.codeBar.equals(code)) {
                        exists = true;
                        System.out.println(videojuegos);
                        break;
                    }
                }
                if (!exists) {
                    System.out.println("No existe ningún producto con este código de barras: " + code);
                }


            } else if (opcion == 4) {


                System.out.println("Has seleccionado la opción 4 - Modificar un producto (por Código de barras)");

                // 1. Buscar el producto
                System.out.println("Introduce el Código de barras del producto a modificar");
                Long codeB = scanner.nextLong();
                scanner.nextLine();
                boolean found = false;
                for (Videojuegos videojuegos : item) {
                    if (videojuegos.codeBar.equals(codeB)) {
                        // 2. Pedir nuevos datos y modificar sus atributos con los nuevos valores
                        System.out.println("Introduce el nombre nuevo (nombre actual: " + videojuegos.nombre + ")");
                        videojuegos.nombre = scanner.nextLine();
                        System.out.println("Introduce la plataforma de este producto(nombre actual: " + videojuegos.plataforma + ")");
                        videojuegos.plataforma = scanner.nextLine();
                        System.out.println("Introduce el precio del producto nuevo (precio actual: " + videojuegos.precio + "€)");
                        videojuegos.precio = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Introduce si el item acepta multijugador (estado actual: " + videojuegos.multijugador + ")");
                        videojuegos.multijugador = scanner.nextBoolean();
                        scanner.nextLine();
                        System.out.println("Introduce si quieres modificar la cantidad del stock (estado actual: " + videojuegos.stock + ")");
                        videojuegos.stock = scanner.nextInt();

                        found = true;
                        System.out.println("registro se ha modificado correctamente!");

                        break;
                    }
                }
                if (!found)
                    System.out.println("No existe el empleado con dni: " + codeB);


            } else if (opcion == 5) {
                System.out.println("Has seleccionado la opción 5 - Borrar un producto por Código de barras");

                //  Buscar el producto
                System.out.println("Introduce el Código de Barras del producto");
                Long code = scanner.nextLong();
                scanner.nextLine();

                boolean exists = false;

                Iterator<Videojuegos> iter = item.iterator();
                while (iter.hasNext()) {
                    Videojuegos videojuegos = iter.next();
                    if (videojuegos.codeBar.equals(code)) {
                        iter.remove();
                        exists = true;
                        System.out.println("Producto borrado correctamente!");
                        break;
                    }
                }


                if (!exists) {
                    System.out.println("No existe el producto con el código de barras: " + code);
                }

                // Borrar producto de la lista

            } else if (opcion == 6) {
                System.out.println("Has seleccionado la opción 6 - Borrar todos los productos");
                item.clear();


            } else if (opcion == 7) {
                System.out.println("Has seleccionado la opción 7 - vender un producto ");

                // 2. leer datos de la consola
                Long code;


                System.out.println("Introduce el código de barras");
                code = scanner.nextLong();
                scanner.nextLine();

                // comprobar si existe un producto con ese código de barras
                // si existe entonces descontamos una cantidad del Stock y  volvemos principal
                // si no existe entonces no permitimos vender
                boolean codeOcupado = false;

                for (Videojuegos videojuegos : item) {
                    if (videojuegos.codeBar.equals(code)) {
                        // ya existe un producto con este código de barras, entonces descontamos del stock
                        codeOcupado = true;
                        {
                            System.out.println("que cantidad del Stock quiere vender=   Stock actual= " + videojuegos.stock);
                            Integer qty = scanner.nextInt();
                            scanner.nextLine();
                            {


                                if (videojuegos.stock > qty) {
                                    videojuegos.stock -= qty;

                                    System.out.println("el stock se ha modificado a " + videojuegos.stock);
                                } else if (videojuegos.stock == qty) {
                                    boolean exists = false;

                                    Iterator<Videojuegos> iter = item.iterator();
                                    while (iter.hasNext()) {
                                        videojuegos = iter.next();
                                        if (videojuegos.codeBar.equals(code)) {
                                            iter.remove();
                                            exists = true;
                                            System.out.println("con esta acción el stock se acabo ");
                                            System.out.println(videojuegos.stock);
                                            break;


                                        } else {
                                            System.out.println("no se va a realizar la acción, stock insuficiente");

                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }


            }
        else if (opcion == 8) {
                System.out.println("Hasta la próxima!");

                System.out.println("\n\n");
                // Paso final: cerrar el scanner
                scanner.close();
                break;
            }

        else {
                System.out.println("opción no disponible");}

           }catch (InputMismatchException e) { //no captura bien el error
                e.printStackTrace();
                System.out.println("Error los datos introducido tienen un formato no compatible!");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error genérico!");
            }



        }
    }
    }


