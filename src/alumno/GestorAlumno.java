package alumno;

import java.io.DataOutputStream;
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


	private static final int NUMERO_DE_ALUMNOS = 2;
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



	public void ejecutar() {

		leer5Alumnos();
		System.out.println("");

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
		System.out.println("");
		System.out.println("");

		alumnos.add(alumno);
		guardarFicheroBinario(alumno);

	}

	public void guardarFicheroBinario(Alumno alumno) {

		// escritorio clase     C:\\Users\\usuario\\Desktop\\FicheroAlumnos.dat
		File fichero= new File("C:\\Users\\usuario\\Desktop\\FicheroAlumnos.dat");
		FileOutputStream fos=null;
		DataOutputStream oos=null;
		try {
			fos= new FileOutputStream(fichero);
			oos= new DataOutputStream(fos);


			oos.writeInt(alumno.getNia());
			oos.writeUTF(alumno.getNombre());
			oos.writeUTF(alumno.getApellidos());
			oos.writeLong(alumno.getFecha().getTime());
			oos.writeChar(alumno.getGenero());
			oos.writeUTF(alumno.getCiclo());
			oos.writeUTF(alumno.getCurso());
			oos.writeUTF(alumno.getGrupo());

			System.out.println("Se ha guardado el Alumno correctamente dentro del FicheroAlumnos.dat");
			System.out.println("");
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


