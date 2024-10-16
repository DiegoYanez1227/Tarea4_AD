package alumno;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase GestorAlumno que gestiona la creación y almacenamiento de alumnos en un fichero binario0 .dat guardando uno a uno los alumnos por sus campos.
 * 
 * @author Diego
 */
public class GestorAlumno {

    private static final int NUMERO_DE_ALUMNOS = 2;
    Scanner sc = new Scanner(System.in);
    List<Alumno> alumnos = new ArrayList<Alumno>();

    /**
     * Método para leer la información de 5 alumnos.
     */
    public void leer5Alumnos() {
        for (int i = 0; i < NUMERO_DE_ALUMNOS; i++) {
            leer1Alumno();
        }
    }

    /**
     * Método para mostrar la información de los alumnos.
     */
    public void mostrarAlumnos() {
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(alumnos.get(i).toString());
        }
    }

    /**
     * Método principal que ejecuta la clase gestorAlumnos en mi clase main.
     */
    public void ejecutar() {
        leer5Alumnos();
        System.out.println("");
    }

    /**
     * Método para crear la información de un alumno y añadirlo al fichero.
     */
    public void leer1Alumno() {

        Alumno alumno = new Alumno();

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

    /**
     * Método para guardar la información del alumno en un archivo binario.
     * 
     * @param alumno El alumno cuya información se va a guardar.
     */
    public void guardarFicheroBinario(Alumno alumno) {

        File fichero = new File("C:\\Users\\usuario\\Desktop\\FicheroAlumnos.dat");
        FileOutputStream fos = null;
        DataOutputStream oos = null;
        try {
            fos = new FileOutputStream(fichero);
            oos = new DataOutputStream(fos);

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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}