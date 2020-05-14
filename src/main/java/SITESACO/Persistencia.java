package SITESACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    
    /**
     * Metodo que guarda en el archivo
     *
     * @param text
     * @return
     */
    public static boolean writeToFile(String listaPersona, String nombrearchivo) {
        try ( FileWriter fw = new FileWriter(nombrearchivo, false);  BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(listaPersona);
            bw.newLine();
            return true;

        } catch (IOException e) {
            System.err.println("Error al escribir");
            return false;
        }

    }

    public static String readFromFile(String nombrearchivo) {
        try (
                 FileReader fr = new FileReader(nombrearchivo);  BufferedReader br = new BufferedReader(fr);) {

            String texto = br.readLine();
            return texto;

        } catch (IOException e) {
            System.err.println("Error al escribir");
            return null;

        }

    }

    public void guardarEnArchivoPacientes(ArrayList<Persona> listaPersona, String nombrearchivo) {

        System.out.println("Guardar en archivo pacientes");
        String listaTexto = "";
        for (Persona persona : listaPersona) {
            Pacientes pac = (Pacientes) persona;
            // fechaing, String tratamiento, String nombre, String doc, String nacimiento
            String contactoString = pac.getFechaing() + "," + pac.getTratamiento() + "," + pac.getNombre() + "," + pac.getDoc() + "," + pac.getNacimiento();
            if (pac.getMedicotrata() != null) {
                contactoString = contactoString + "," + pac.getMedicotrata().getDoc();
            }
            listaTexto = listaTexto + "#" + contactoString;
        }

        writeToFile(listaTexto, nombrearchivo);
    }

    public void guardarEnArchivoEmpleado(ArrayList<Persona> listaPersona, ArrayList<Medicos> listaMedicos, String nombrearchivo) {

        System.out.println("Guardar en archivo empleados");
        String listaTexto = "";
        // guarda las personas
        for (Persona persona : listaPersona) {
            Empleados pac = (Empleados) persona;
            //cargo, tipocargo, salario, nombre, doc, nacimiento
            String contactoString = pac.getCargo() + "," + pac.getTipocargo() + "," + pac.getSalario() + "," + pac.getNombre() + "," + pac.getDoc() + "," + pac.getNacimiento();
            // si es medico se debe guardar mas campos
            if (pac.getTipocargo().equals("medico") == false) {

                listaTexto = listaTexto + "#" + contactoString;

            }
        }
        // guarda los medicos
        for (Medicos medicoData : listaMedicos) {
            Medicos med = (Medicos) medicoData;
//cargo, tipocargo, salario, nombre, doc, nacimiento
            String contactoString = med.getCargo() + "," + med.getTipocargo() + "," + med.getSalario() + "," + med.getNombre() + "," + med.getDoc() + "," + med.getNacimiento();
// si es medico se debe guardar mas campos
            if (med.getTipocargo().equals("medico")) {
// idmed, residente, especialidad
                contactoString = contactoString + "," + med.getIdmed() + "," + med.getResidente()+",";
                for (Especialidad esp : med.getEspecialidad()) {
                    contactoString = contactoString + "/" + esp.getNombre();
                }
            }
            listaTexto = listaTexto + "#" + contactoString;
        }

        writeToFile(listaTexto, nombrearchivo);
    }

}



    