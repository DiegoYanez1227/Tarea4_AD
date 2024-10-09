package alumno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GestorAlumno {


	private static final int NUMERO_DE_ALUMNOS = 5;
	Scanner sc = new Scanner(System.in);
	List<Alumno> alumnos= new ArrayList<Alumno>();


	public void leer5Alumnos() {
		for (int i = 0; i < NUMERO_DE_ALUMNOS; i++) {
			leer1Alumno();
		}
	}

	public void mostrarAlumnos() {
		for(int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i).toString());
		}
	}

	public void  menu1() {
		System.out.println("******* MENU *******");
		System.out.println("1. Crear 1 Alumno");
		System.out.println("2. Crear 5 Alumnos");
		System.out.println("3. Ordenar por NIA");
		System.out.println("4. Ordenar por el criterio elegido");
	}

	public void  menu2() {
		System.out.println("******* MENU 2 *******");
		System.out.println("1. Ordenar por Nombre");
		System.out.println("2. Ordenar por Apellidos");
		System.out.println("3. Ordenar por Fecha de nacimiento");
		System.out.println("4. Ordenar por Genero");
		System.out.println("5. Ordenar por Ciclo");
		System.out.println("6. Ordenar por Curso");
		System.out.println("7. Ordenar por Grupo");
	}

	public static void ordenarYMostrar(List<Alumno> alumnos, Comparator<Alumno> criterio, String mensaje) {
		Collections.sort(alumnos, criterio);
		System.out.println("\n" + mensaje + ":");
		alumnos.forEach(System.out::println);
	}

	public void ejecutar() {
		int opcion;
		int opcion2;

		do {
			menu1();
			System.out.print("Elige una opción: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Has elegido leer 1 Alumno");
				leer1Alumno();
				break;
			case 2:
				System.out.println("Has elegido leer 5 Alumnos");
				leer5Alumnos();
				break;
			case 3:
				System.out.println("Has elegido ordenar por Nia");
				ordenarYMostrar(alumnos, Comparator.comparing(Alumno::getNia), "Ordenado por NIA");
				break;
			case 4:
				System.out.println("Has elegido ordenar por el criterio elegido");
				menu2();
				System.out.print("Elige una opción: ");
				opcion2 = sc.nextInt();

				switch (opcion2) {
				case 1:
					ordenarYMostrar(alumnos, Comparator.comparing(Alumno::getNombre), "Ordenado por nombre");
					break;
				case 2:
					ordenarYMostrar(alumnos, Comparator.comparing(Alumno::getApellidos), "Ordenado por apellidos");
					break;
				case 3:
					ordenarYMostrar(alumnos, Comparator.comparing(Alumno::getFecha), "Ordenado por fecha de nacimiento");
					break;
				case 4:
					ordenarYMostrar(alumnos, Comparator.comparing(Alumno::getGenero), "Ordenado por género");
					break;
				case 5:
					ordenarYMostrar(alumnos, Comparator.comparing(Alumno::getCiclo), "Ordenado por ciclo");
					break;
				case 6:
					ordenarYMostrar(alumnos, Comparator.comparing(Alumno::getCurso), "Ordenado por curso");
					break;
				case 7:
					ordenarYMostrar(alumnos, Comparator.comparing(Alumno::getGrupo), "Ordenado por grupo");
					break;
				default:
					System.out.println("Opción no válida, intenta nuevamente.");
				}
				break;
			case 0:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida, intenta de nuevo.");
			}
		} while (opcion != 0);
	}

	public void leer1Alumno() {
		
		Alumno alumno= new Alumno();
		
		System.out.println("Introduzca el NIA del alumno:");
		int nia = sc.nextInt();
		alumno.setNia(nia);
		System.out.println("----------");

		sc.nextLine();
		System.out.println("Introduzca el Nombre del alumno:");
		String nombre = sc.nextLine();
		alumno.setNombre(nombre);
		sc.nextLine();
		System.out.println("----------");

		System.out.println("Introduzca el Apellidos del alumno:");
		String apellidos = sc.nextLine();
		alumno.setApellidos(apellidos);
		sc.nextLine();
		System.out.println("----------");

		System.out.println("Introduzca la fecha de nacimiento del alumno siguiendo el patron dd/MM/aaaa");
		String fechaN = sc.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		try {
			alumno.setFecha(formato.parse(fechaN));
			System.out.println(formato.parse(fechaN));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sc.nextLine();
		System.out.println("----------");


		System.out.println("Introduzca el Genero del alumno:");
		String genero = sc.nextLine();
		alumno.setGenero(genero.charAt(0));
		sc.nextLine();
		System.out.println("----------");


		System.out.println("Introduzca el Ciclo del alumno:");
		String ciclo = sc.nextLine();
		alumno.setCiclo(ciclo);
		sc.nextLine();
		System.out.println("----------");

		System.out.println("Introduzca el Curso del alumno:");
		String curso = sc.nextLine();
		alumno.setCurso(curso);
		sc.nextLine();
		System.out.println("----------");

		System.out.println("Introduzca el Grupo del alumno:");
		String grupo = sc.nextLine();
		alumno.setGrupo(grupo);
		System.out.println("----FIN DE LA CREACION DE ALUMNO-----");

		alumnos.add(alumno);
	}
	
	public void guardarFicheroBinario() {
		System.out.println("Introduzca la ruta del archivo en el que quiera guardar a los alumnos");
		String ruta=sc.nextLine();
		
		File fichero= new File("FicheroAlumnos.dat");
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {
			 fos= new FileOutputStream(fichero);
			 oos= new ObjectOutputStream(fos);
			 
			  for (int i = 0; i < alumnos.size(); i++) {
				oos.writeObject(i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
