package SITESACO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        //Variables para opciones
        int opc;
        int opcpacientes;
        int opcempleados;
        int opcmedicos;
        int opcmod;
        Persistencia persistencia = new Persistencia();
        //Arreglos de tipo Persona para agregar los objetos
        ArrayList<Persona> pacientes = new ArrayList<Persona>();
        ArrayList<Persona> medicos = new ArrayList<Persona>();
        ArrayList<Medicos> medicosl = new ArrayList<Medicos>();

        ArrayList<Persona> empleados = new ArrayList<Persona>();
        //Lectura de archivos para persistir pacientes y empleados
        String txtEmpleados = Persistencia.readFromFile("empleados.txt"); // en este archivo se leen los empleados y medicos
        String txtPacientes = Persistencia.readFromFile("pacientes.txt");
        if (txtEmpleados != null) {
            empleados = Empleados.convertirTXTaObjetos(txtEmpleados);
            medicosl = Medicos.convertirTXTaObjetosMedicos(txtEmpleados);
            for (Medicos med : medicosl) {
                empleados.add((Persona) med);
                medicos.add(med);
            }
        }
        if (txtPacientes != null) {
            pacientes = Pacientes.convertirTXTaObjetos(txtPacientes, medicos);
        }

        do {
            //Men˙ principal
            String x = JOptionPane.showInputDialog("==============Menu==================\n"
                    + "1.Gestionar pacientes\n"
                    + "2.Gestionar empleados\n"
                    + "3.Gestionar medicos\n"
                    + "0.Salir");
            opc = Integer.parseInt(x);
            switch (opc) {
                case 1:
                    do {
                        //Men˙ para gestionar un paciente
                        String y = JOptionPane.showInputDialog("1.Registro del paciente\n"
                                + "2.Ver lista de pacientes\n"
                                + "3.Ver historia clÌnica de un paciente\n"
                                + "4.Cambiar medico tratante\n"
                                + "5.Dar de alta a un paciente\n"
                                + "6.Eliminar\n"
                                + "7. Agregar medico al paciente\n"
                                + "0.Regresar");
                        opcpacientes = Integer.parseInt(y);
                        switch (opcpacientes) {
                            case 1:
                                //Agregar un paciente al arreglo pacientes
                                Pacientes paciente = new Pacientes();
                                paciente.agregarPersona();
                                pacientes.add(paciente);
                                JOptionPane.showMessageDialog(null, "Paciente agregado.");
                                persistencia.guardarEnArchivoPacientes(pacientes, "pacientes.txt");
                                break;
                            case 2:
                                //Ver todos los pacientes agregados
                                paciente = new Pacientes();
                                paciente.verLista(pacientes);

                                break;
                            case 3:
                                //Buscar un paciente en particular
                                paciente = new Pacientes();
                                paciente = (Pacientes) paciente.buscar(pacientes);
                                if (paciente != null) {
                                    paciente.verDetalles();
                                } else {
                                    JOptionPane.showMessageDialog(null, "No existe ese paciente");
                                }

                                break;
                            case 4:
                                //Cambiar el mÈdico de un paciente
                                paciente = new Pacientes();
                                paciente = (Pacientes) paciente.buscar(pacientes);
                                paciente.asignarMedicoPorEspecialidad(medicos);
                                JOptionPane.showMessageDialog(null, "Cambio de mÈdico Èxitoso");
                                persistencia.guardarEnArchivoEmpleado(empleados, medicosl, "empleados.txt");
                                break;
                            case 5:
                                //Dar de alta un paciente
                                paciente = new Pacientes();
                                paciente = (Pacientes) paciente.buscar(pacientes);
                                if (paciente != null) {
                                    paciente.darAlta(pacientes);
                                    persistencia.guardarEnArchivoPacientes(pacientes, "pacientes.txt");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No existe ese paciente");
                                }

                                break;
                            case 6:
                                //Eliminar un paciente del arreglo
                                paciente = new Pacientes();
                                paciente.Eliminar(pacientes);
                                persistencia.guardarEnArchivoPacientes(pacientes, "pacientes.txt");

                            case 7:
                                //Busca el paciente y le agrega un mÈdico dependiendo de la especialidad
                                paciente = new Pacientes();
                                paciente = (Pacientes) paciente.buscar(pacientes);
                                if (paciente != null) {
                                    paciente.asignarMedicoPorEspecialidad(medicos);
                                    persistencia.guardarEnArchivoPacientes(pacientes, "pacientes.txt");

                                } else {
                                    JOptionPane.showMessageDialog(null, "No existe ese paciente");
                                }

                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Esa opcion no existe");
                                break;
                        }

                    } while (opcpacientes != 0);
                    break;
                case 2:
                    do {
                        //Men˙ para gestionar un empleado
                        String f = JOptionPane.showInputDialog("1.Agregar un empleado\n"
                                + "2.Ver lista de empleados\n"
                                + "3.Ver detalles de un empleado.\n"
                                + "4.Modificar salario, cargo o tipo de empleado.\n"
                                + "5.Retirar empleado\n"
                                + "0.Regresar");
                        opcempleados = Integer.parseInt(f);
                        switch (opcempleados) {
                            case 1:
                                //Agregar un empleado al arreglo empleados
                                Empleados empleado = new Empleados();
                                empleado.agregarPersona();
                                empleados.add(empleado);
                                //Si el empleado es mÈdico se agrega al arreglo medicos
                                if (empleado.getTipocargo().equalsIgnoreCase("medico")) {

                                    Medicos med = new Medicos(empleado);
                                    med.agregarPersona();
                                    medicos.add(med);
                                    medicosl.add(med);
                                }
                                JOptionPane.showMessageDialog(null, "Nuevo emplado agregado");
                                persistencia.guardarEnArchivoEmpleado(empleados, medicosl, "empleados.txt");
                                break;
                            case 2:
                                //Ver todos los empleados
                                empleado = new Empleados();
                                empleado.verLista(empleados);

                                break;
                            case 3:
                                //Buscar un empleado en particular
                                empleado = new Empleados();
                                empleado = (Empleados) empleado.buscar(empleados);
                                if (empleado != null) {
                                    empleado.verDetalles();

                                } else {
                                    JOptionPane.showMessageDialog(null, "No existe ese empleado");

                                }

                                break;
                            case 4:
                                //Modificaciones de empleados
                                do {
                                    //Men˙ para modificar atributos de un empleado
                                    String l = JOptionPane.showInputDialog("1.Salario\n"
                                            + "2.Cargo\n"
                                            + "3.Tipo de empleado\n"
                                            + "0.Regresar");
                                    opcmod = Integer.parseInt(l);
                                    switch (opcmod) {
                                        case 1:
                                            //Modificar salario
                                            empleado = new Empleados();
                                            empleado = (Empleados) empleado.buscar(empleados);
                                            if (empleado != null) {
                                                empleado.salario = Integer.parseInt(JOptionPane.showInputDialog("Nuevo salario del empleado"));
                                                empleado.setSalario(empleado.salario);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No existe ese empleado");

                                            }
                                            persistencia.guardarEnArchivoEmpleado(empleados, medicosl, "empleados.txt");
                                            break;
                                        case 2:
                                            //Modificar Cargo
                                            empleado = new Empleados();
                                            empleado = (Empleados) empleado.buscar(empleados);
                                            if (empleado != null) {
                                                empleado.cargo = JOptionPane.showInputDialog("Nuevo cargo del empleado");
                                                empleado.setCargo(empleado.cargo);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No existe ese empleado");

                                            }
                                            persistencia.guardarEnArchivoEmpleado(empleados, medicosl, "empleados.txt");
                                            break;
                                        case 3:
                                            //Modificar tipo de cargo
                                            empleado = new Empleados();
                                            empleado = (Empleados) empleado.buscar(empleados);
                                            if (empleado != null) {
                                                empleado.tipocargo = JOptionPane.showInputDialog("Nuevo tipo de cargo del empleado");
                                                empleado.setTipocargo(empleado.tipocargo);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No existe ese empleado");

                                            }
                                            persistencia.guardarEnArchivoEmpleado(empleados, medicosl, "empleados.txt");
                                            break;

                                        case 0:
                                            break;

                                    }

                                } while (opcmod != 0);

                                break;
                            case 5:
                                //Eliminar un empleado
                                empleado = new Empleados();
                                empleado.Eliminar(empleados);
                                persistencia.guardarEnArchivoEmpleado(empleados, medicosl, "empleados.txt");
                                break;
                            case 0:
                                break;

                        }

                    } while (opcempleados != 0);
                    break;
                case 3:
                    do {
                        //Men˙ para gestionar mÈdicos
                        String g = JOptionPane.showInputDialog("1.Ver listado de mÈdicos registrados.\n"
                                + "2.Ver detalles de un mÈdico.\n"
                                + "3.Agregar especialidad.\n"
                                + "4.Retirar un mÈdico.\n"
                                + "0.Regresar");
                        opcmedicos = Integer.parseInt(g);
                        switch (opcmedicos) {
                            case 1:
                                //Ver todos los mÈdicos
                                Medicos medicos2 = new Medicos();
                                medicos2.verLista(medicos);

                                break;
                            case 2:
                                //Buscar un mÈdico en particular
                                medicos2 = new Medicos();
                                medicos2 = (Medicos) medicos2.buscarMedico(medicosl);

                                if (medicos2 != null) {
                                    medicos2.verDetallesMedico(pacientes);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No existe ese mÈdico");
                                }

                                break;
                            case 3:
                                //Agregar un nueva especialidad al mÈdico
                                medicos2 = new Medicos();
                                medicos2 = (Medicos) medicos2.buscarMedico(medicosl);
                                if (medicos2 != null) {
                                    medicos2.agregarEspecial();
                                } else {
                                    JOptionPane.showMessageDialog(null, "No existe ese mÈdico");
                                }
                                persistencia.guardarEnArchivoEmpleado(empleados, medicosl, "empleados.txt");

                                break;
                            case 4:
                                //Eliminar a un mÈdico
                                medicos2 = new Medicos();
                                medicos2.eliminarMed(medicos, medicosl, pacientes);
                                persistencia.guardarEnArchivoEmpleado(empleados, medicosl, "empleados.txt");

                                break;
                            case 0:
                                break;

                        }

                    } while (opcmedicos != 0);
                    break;
                //Opcion para salir del programa
                case 0:
                    JOptionPane.showMessageDialog(null, "Has salido del programa");
                    break;
            }

        } while (opc != 0);
    }

}
