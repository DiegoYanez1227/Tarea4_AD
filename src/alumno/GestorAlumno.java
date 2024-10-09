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
		System.out.println("0. Salir del Programa");
		System.out.println("1. Crear 1 Alumno");
		System.out.println("2. Crear 5 Alumnos");
		System.out.println("3.Guardar en fichero binario todos los alumnos campo a campo");
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
				System.out.println("Has elegido guardar los archivos dentro del fichero binario");
				guardarFicheroBinario();
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
			 System.out.println("Se han guardado los Alumnos correctamente dentro del fichero.dat");
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
